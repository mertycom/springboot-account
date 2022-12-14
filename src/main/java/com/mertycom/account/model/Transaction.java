package com.mertycom.account.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
@ToString(exclude = { "account" })
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.uuid.UuidGenerator")
    private String id;
    private TransactionType transactionType= TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Transaction(BigDecimal amount, Account account) {
        this.id =null;
        this.amount = amount;
        this.transactionDate=LocalDateTime.now();
        this.transactionType=TransactionType.INITIAL;
        this.account = account;
    }
}
