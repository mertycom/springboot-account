package com.mertycom.account.service;

import com.mertycom.account.dto.request.CreateAccountRequest;
import com.mertycom.account.model.Account;
import com.mertycom.account.model.Transaction;
import com.mertycom.account.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction initiateMoney(final Account account, BigDecimal amount) {
        return transactionRepository.save(new Transaction(amount,account));
    }
}
