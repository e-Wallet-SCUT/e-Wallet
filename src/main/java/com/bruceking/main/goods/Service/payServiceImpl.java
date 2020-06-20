package com.bruceking.main.goods.Service;

import com.bruceking.main.goods.bean.Pay;
import com.bruceking.main.goods.mapper.PayMapper;
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
}
