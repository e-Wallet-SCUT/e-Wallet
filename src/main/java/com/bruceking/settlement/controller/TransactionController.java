package com.bruceking.settlement.controller;

import com.bruceking.settlement.bean.Transaction;
import com.bruceking.settlement.mapper.EntityMapper;
import com.bruceking.settlement.mapper.TransactionMapper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {

    private final BigDecimal fee_rate = new BigDecimal(0.005);
    private final BigDecimal maximum_transaction_amount = new BigDecimal(1000000);

    @Resource
    TransactionMapper transactionMapper;

    @Resource
    EntityMapper entityMapper;

    @GetMapping("/tx/{Entity_id}")
//    @Cacheable(value = "tx")
    public List<Transaction> getTxByEntityId(@PathVariable("Entity_id") Integer Entity_id){
        List<Transaction> txs =  transactionMapper.getTxByEntityId(Entity_id);
        return txs;
    }

    @GetMapping("/tx/date/{Date}")
    public List<Transaction> getTxByTime(@PathVariable("Date") String date){
        List<Transaction> txs =  transactionMapper.getTxByTime(date);
        return txs;
    }

    @GetMapping("/tx")
    public List<Transaction> getAllTransaction(){
        List<Transaction> txs =  transactionMapper.getAllTransaction();
        return txs;
    }

    @GetMapping("/insert")
    public String insert(Transaction transaction){
        Integer entity_id = transaction.getTransaction_from_entity_id();
        RSAPublicKey publicKey = getPublicKey(entityMapper.getPublicKey(entity_id));

        String signString = transaction.getSignString();
        String sign = transaction.getTransaction_sign().replace(' ','+');
        transaction.setTransaction_sign(sign);

        transaction.setTransaction_currency_fee(fee_rate.multiply(transaction.getTransaction_currency_amount()));

        //--------------------------
        if(sign.equals("AutoSign")){
            RSAPrivateKey privateKey = getPrivateKey(entityMapper.getPrivateKey(entity_id));
            sign = getSign(signString, privateKey);
            transaction.setTransaction_sign(sign);
        }
        //--------------------------
        if (transactionMapper.checkSign(sign) != null){
            return "交易已被插入，插入失败";
        }

        if (!verify(signString, sign, publicKey)){
            return "签名验证失败，插入失败";
        }

        if(transaction.getTransaction_currency_amount().compareTo(maximum_transaction_amount) == 1){
            return "交易金额过大，插入失败";
        }

        transaction.setTransaction_time(new Date());
        transactionMapper.insertTx(transaction);
        return "插入成功"+transaction.toString();
    }


    public RSAPublicKey getPublicKey(String publicKey){
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
            RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public RSAPrivateKey getPrivateKey(String privateKey){
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
            RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getSign(String plainText, RSAPrivateKey privateKey){
        try{
            Signature privateSignature = Signature.getInstance("SHA256withRSA");
            privateSignature.initSign(privateKey);
            privateSignature.update(plainText.getBytes("UTF-8"));
            byte[] signature = privateSignature.sign();
            return Base64.encodeBase64String(signature);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verify(String plainText, String signature, RSAPublicKey publicKey){
        try{
            Signature publicSignature = Signature.getInstance("SHA256withRSA");
            publicSignature.initVerify(publicKey);
            publicSignature.update(plainText.getBytes("UTF-8"));
            byte[] signatureBytes = Base64.decodeBase64(signature);
            return publicSignature.verify(signatureBytes);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
