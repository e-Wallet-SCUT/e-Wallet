package com.bruceking.settlement.mapper;

import com.bruceking.settlement.bean.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "select * from extransaction", nativeQuery = true)
    List<Transaction> findAll();
}
