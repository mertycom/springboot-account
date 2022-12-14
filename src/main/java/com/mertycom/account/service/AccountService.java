package com.mertycom.account.service;

import com.mertycom.account.dto.AccountDto;
import com.mertycom.account.dto.converter.AccountDtoConverter;
import com.mertycom.account.dto.request.CreateAccountRequest;
import com.mertycom.account.model.Account;
import com.mertycom.account.model.Customer;
import com.mertycom.account.model.Transaction;
import com.mertycom.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService, TransactionService transactionService, AccountDtoConverter converter) {

        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest request){
        Customer customer = customerService.findCustomerById(request.getCustomerId());

        Account account = new Account(request.getInitialCredit(), LocalDateTime.now(), customer);
        if(request.getInitialCredit().compareTo(BigDecimal.ZERO)>0){
            Transaction transaction = transactionService.initiateMoney(account,request.getInitialCredit());
            account.getTransactions().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }
}
