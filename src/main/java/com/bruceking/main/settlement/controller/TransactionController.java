package com.bruceking.main.settlement.controller;

import com.bruceking.main.loginPage.customer;
import com.bruceking.main.settlement.bean.AcSign;
import com.bruceking.main.settlement.bean.Currency;
import com.bruceking.main.settlement.bean.Entity;
import com.bruceking.main.settlement.bean.Transaction;
import com.bruceking.main.settlement.mapper.CurrencyMapper;
import com.bruceking.main.settlement.mapper.EntityMapper;
import com.bruceking.main.settlement.mapper.TransactionMapper;
import com.bruceking.main.userInfo.userInfoService;
import com.bruceking.main.settlement.mapper.TransactionRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {

    private final BigDecimal fee_rate = new BigDecimal(0.005);
    private final BigDecimal maximum_transaction_amount = new BigDecimal(1000000);

    @Resource
    CurrencyMapper currencyMapper;

    @Resource
    TransactionMapper transactionMapper;

    @Resource
    EntityMapper entityMapper;

    @Resource
    TransactionRepository transactionRepository;

    @Autowired
    private userInfoService userInfoService;

    @GetMapping("/getTransactionUser")
//    @Cacheable(value = "tx")
    public Integer getTransactionUser(){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        Integer id = user.getCustomer_id();
//        Integer id = 2;
        return id;
    }

    @GetMapping("/getTransaction")
//    @Cacheable(value = "tx")
    public List<Transaction> getTransactionByEntityId(){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        Integer id = user.getCustomer_id();
//        Integer id = 2;
        return transactionRepository.findByEntityId(id);
    }

    @PostMapping("/getTransactionByDate")
//    @Cacheable(value = "tx")
    public List<Transaction> getTransactionByDate(@RequestBody List<String> date){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        Integer id = user.getCustomer_id();
//        Integer id = 2;
        return transactionRepository.findByEntityIdAndDate(id, date.get(0), date.get(1));
    }

    @GetMapping("/getAcTransaction")
//    @Cacheable(value = "tx")
    public List<Transaction> getAcTransactionByEntityId(){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        Integer id = user.getCustomer_id();
//        Integer id = 2;
        return transactionRepository.findAcByEntityId(id);
    }

    @PostMapping("/getAcTransactionByDate")
//    @Cacheable(value = "tx")
    public List<Transaction> getAcTransactionByDate(@RequestBody List<String> date){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        Integer id = user.getCustomer_id();
//        Integer id = 2;
        return transactionRepository.findAcByEntityIdAndDate(id, date.get(0), date.get(1));
    }

    @GetMapping("/getNotAcTransaction")
//    @Cacheable(value = "tx")
    public List<Transaction> getNotAcTransactionByEntityId(){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        Integer id = user.getCustomer_id();
//        Integer id = 2;
        return transactionRepository.findNotAcByEntityId(id);
    }

    @PostMapping("/getNotAcTransactionByDate")
//    @Cacheable(value = "tx")
    public List<Transaction> getNotAcTransactionByDate(@RequestBody List<String> date){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        Integer id = user.getCustomer_id();
//        Integer id = 2;
        return transactionRepository.findNotAcByEntityIdAndDate(id, date.get(0), date.get(1));
    }

    @PostMapping("/SignTransaction")
    public String signTransaction(AcSign acSign){
        Transaction transaction = transactionRepository.findByTransactionId(acSign.getTransaction_id());

        if (transaction.getTransaction_status() != 0){
            return "交易已被验证或交易已被关闭";
        }

        Integer entity_id = transaction.getTransaction_to_entity_id();
        RSAPublicKey publicKey = getPublicKey(entityMapper.getPublicKey(entity_id));

        String signString = transaction.getAcSignString();
        String sign = acSign.getTransaction_ac_sign().replace(' ','+');

        if(sign.length() < 10){
            RSAPrivateKey privateKey = getPrivateKey(entityMapper.getPrivateKey(entity_id));
            sign = getSign(signString, privateKey);
        }

        if (!verify(signString, sign, publicKey))
            return "签名验证失败";

        Date time = new Date();

        transactionMapper.updateTransactionAcSign(transaction.getTransaction_id(),sign,time,1);
        return "验证成功";
    }

    @PostMapping("/insertTransaction")
    public String insert(Transaction transaction){
        Integer entity_id = transaction.getTransaction_from_entity_id();
        RSAPublicKey publicKey = getPublicKey(entityMapper.getPublicKey(entity_id));

        String signString = transaction.getSignString();
        String sign = transaction.getTransaction_sign().replace(' ','+');
        transaction.setTransaction_sign(sign);

        transaction.setTransaction_currency_fee(fee_rate.multiply(transaction.getTransaction_currency_amount()));

        long delta = new Date().getTime() - transaction.getTransaction_send_time().getTime();
        if (delta > 1800000){
            return "交易超时，插入失败";
        }

        //--------------------------
        if(sign.length() < 10){
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

        //----------------
        int type = transaction.getTransaction_currency_id();
        Entity from = entityMapper.getEntityByEntityId(transaction.getTransaction_from_entity_id()).get(0);
        Entity to = entityMapper.getEntityByEntityId(transaction.getTransaction_to_entity_id()).get(0);
        BigDecimal amount = transaction.getTransaction_currency_amount();

        List<Currency> currencies = currencyMapper.getAllCurrency();
        BigDecimal exchangeRate[] = new BigDecimal[currencies.size()+1];
        for (int i=1;i<=currencies.size();i++){
            exchangeRate[i] = currencies.get(i-1).getCurrency_er();
        }

        BigDecimal from_position = amount.divide(exchangeRate[type], 4).multiply(exchangeRate[from.getCurrency_id()]);
        BigDecimal to_position = amount.divide(exchangeRate[type], 4).multiply(exchangeRate[to.getCurrency_id()]);

        if(from_position.compareTo(from.getCurrency_amount().add(from.getCurrency_used())) == 1){
            return "余额不足，请充值余额再发起交易";
        }

        entityMapper.updateCurrencyUsed(from.getEntity_id(), from.getCurrency_used().subtract(from_position));
        entityMapper.updateCurrencyUsed(to.getEntity_id(), to.getCurrency_used().add(to_position));


        //--------------------------

        transaction.setTransaction_time(new Date());
        transaction.setTransaction_status(0);
        transactionMapper.insertTx(transaction);
        return "插入成功"+transaction.toString();
    }

//    @GetMapping("/transaction/date/{Date}")
//    public List<Transaction> getTxByTime(@PathVariable("Date") String date){
//        List<Transaction> txs =  transactionMapper.getTxByTime(date);
//        return txs;
//    }

//    @GetMapping("/transaction")
//    public List<Transaction> getAllTransaction(){
//        List<Transaction> txs =  transactionMapper.getAllTransaction();
//        return txs;
//    }

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
            System.out.println(signature);
            byte[] signatureBytes = Base64.decodeBase64(signature);
            System.out.println(signatureBytes);
            return publicSignature.verify(signatureBytes);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
