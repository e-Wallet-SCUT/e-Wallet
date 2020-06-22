package com.bruceking.goods.Service;

import com.bruceking.clearing.pojo.Transaction;
import com.bruceking.goods.bean.Pay;

import com.bruceking.goods.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class payServiceImpl implements payService {

    @Autowired
    private PayMapper payMapper;

    @Override
    public void AddPay(Pay pay) {
        payMapper.AddPay(pay);
    }

    @Override
    public void AddTransaction(Transaction transaction) {
        payMapper.insertTransaction(transaction);
    }

    @Override
    public int SelectTransaction(int PrimaryID) {
        return payMapper.selectTransaction(PrimaryID);
    }


}
