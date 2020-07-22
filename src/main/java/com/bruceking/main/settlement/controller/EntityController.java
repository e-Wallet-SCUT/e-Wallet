package com.bruceking.main.settlement.controller;

import com.bruceking.main.settlement.bean.Entity;
import com.bruceking.main.settlement.mapper.EntityMapper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @GetMapping("/entity")
    public List<Entity> getEntity(){
        return entityMapper.getAllEntity();
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
