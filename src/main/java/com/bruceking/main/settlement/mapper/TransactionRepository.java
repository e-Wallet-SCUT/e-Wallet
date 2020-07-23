package com.bruceking.main.settlement.mapper;

import com.bruceking.main.settlement.bean.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    @Query(value = "select * from extransaction WHERE transaction_from_entity_id = ?1 or transaction_to_entity_id = ?1 ORDER BY ?#{#pageable}",
//            countQuery = "select count(*) from extransaction WHERE transaction_from_entity_id = ?1 or transaction_to_entity_id = ?1", nativeQuery = true)
//    Page<Transaction> findById(Integer id, Pageable pageable);

    @Query(value = "select * from extransaction WHERE transaction_from_entity_id = ?1 or transaction_to_entity_id = ?1 ", nativeQuery = true)
    List<Transaction> findByEntityId(Integer id);

    @Query(value = "select * from extransaction WHERE (transaction_from_entity_id = ?1 or transaction_to_entity_id = ?1) and transaction_ac_sign is not null", nativeQuery = true)
    List<Transaction> findAcByEntityId(Integer id);

    @Query(value = "select * from extransaction WHERE (transaction_from_entity_id = ?1 or transaction_to_entity_id = ?1) and transaction_ac_sign is null", nativeQuery = true)
    List<Transaction> findNotAcByEntityId(Integer id);

    @Query(value = "select * from extransaction WHERE transaction_id = ?1", nativeQuery = true)
    Transaction findByTransactionId(Integer id);

    @Modifying
    @Query(value = "update extransaction set transaction_ac_sign = ?1 where  transaction_id =?1", nativeQuery = true)
    void updateTransactionAcSign(Integer id, String sign);

}
