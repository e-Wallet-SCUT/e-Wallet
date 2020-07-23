package com.bruceking.main.settlement.controller;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.JSONObject;
import com.bruceking.main.loginPage.customer;
import com.bruceking.main.settlement.bean.Charge;
import com.bruceking.main.settlement.bean.Entity;
import com.bruceking.main.settlement.bean.Transaction;
import com.bruceking.main.settlement.mapper.EntityMapper;
import com.bruceking.main.userInfo.userInfoService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

@RestController
public class EntityController {

    @Resource
    EntityMapper entityMapper;

    @Resource
    userInfoService userInfoService;

    @GetMapping("/getEntity")
    public List<Entity> getEntity(){
        return entityMapper.getAllEntity();
    }

    @GetMapping("/getEntityById")
    public List<Entity> getEntityById(){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        Integer id = user.getCustomer_id();
//        Integer id = 2;
        return entityMapper.getEntityByEntityId(id);
    }

    @PostMapping("/entityCharge")
    public String charge(@RequestBody Charge charge){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        Integer id = user.getCustomer_id();
//        Integer id = 2;
        Entity entity = entityMapper.getEntityByEntityId(id).stream().findFirst().orElse(null);
        BigDecimal bigDecimal = entity.getCurrency_amount().add(charge.getValue());
        entityMapper.updateCurrencyAmount(id,bigDecimal);
        return "success!";
    }

    @PostMapping("/insertEntity")
    public String insert(Entity entity){
        try {
            entityMapper.insertEntity(entity);
            return "success!";
        }catch (Exception e){
            return "failed!";
        }
    }

    @GetMapping("/genkey")
    public String genKey(){
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGen.initialize(512,new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        String privateKeyString  = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        return "PrivateKey=" + privateKeyString + "\nPublicKey=" + publicKeyString;
    }
}
