package com.bruceking.main.goods.Service;


import com.bruceking.main.goods.bean.Pay;
import com.bruceking.main.goods.bean.Transaction;

public interface payService {
    void AddPay(Pay pay);
    void AddTransaction(Transaction transaction);
    int SelectTransaction(int PrimaryID);
}
