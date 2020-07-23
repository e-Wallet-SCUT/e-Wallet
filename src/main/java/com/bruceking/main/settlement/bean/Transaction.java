package com.bruceking.main.settlement.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer transaction_id;
    private Integer transaction_from_entity_id;
    private String transaction_from_entity_account;
    private Integer transaction_to_entity_id;
    private String transaction_to_entity_account;
    private BigDecimal transaction_currency_amount;
    private BigDecimal transaction_currency_fee;
    private Integer transaction_currency_id;
    private Date transaction_time;
    private Date transaction_send_time;
    private String transaction_sign;
    private String transaction_ac_sign;

    public String getSignString() {
        return "SignString{" +
                "transaction_from_entity_id=" + transaction_from_entity_id +
                ", transaction_from_entity_account='" + transaction_from_entity_account + '\'' +
                ", transaction_to_entity_id=" + transaction_to_entity_id +
                ", transaction_to_entity_account='" + transaction_to_entity_account + '\'' +
                ", transaction_currency_amount=" + transaction_currency_amount +
                ", transaction_currency_id=" + transaction_currency_id +
                ", transaction_send_time=" + transaction_send_time +
                '}';
    }

    public String getAcSignString(){
        return "AcSignString{" +
                "transaction_id=" + transaction_id +
                ", transaction_sign='" + transaction_sign + '\'' +
                '}';
    }
}
