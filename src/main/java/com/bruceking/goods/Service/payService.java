package com.bruceking.goods.Service;


import com.bruceking.clearing.pojo.Transaction;
import com.bruceking.goods.bean.Pay;

public interface payService {
    void AddPay(Pay pay);
    void AddTransaction(Transaction transaction);
    int SelectTransaction(int PrimaryID);
}
