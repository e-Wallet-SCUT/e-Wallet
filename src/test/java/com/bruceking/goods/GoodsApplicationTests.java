package com.bruceking.goods;

import com.bruceking.clearing.pojo.Transaction;
import com.bruceking.settlement.mapper.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class GoodsApplicationTests {

    @Resource
    TransactionRepository transactionRepository;

    @Test
    void contextLoads() {
    }

}
