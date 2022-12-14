package com.mertycom.account.dto.converter;

import com.mertycom.account.dto.AccountCustomerDto;
import com.mertycom.account.dto.CustomerDto;
import com.mertycom.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter customerAccountDtoConverter) {
        this.customerAccountDtoConverter = customerAccountDtoConverter;
    }


    public AccountCustomerDto convertToAccountCustomer(Customer from){
        if(from==null)
            return new AccountCustomerDto("","","");
        return new AccountCustomerDto(from.getId(),from.getName(),from.getSurName());
    }

    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurName(),
                from.getAccounts().stream()
                        .map(customerAccountDtoConverter::convert)
                        .collect(Collectors.toSet()));

    }
}
