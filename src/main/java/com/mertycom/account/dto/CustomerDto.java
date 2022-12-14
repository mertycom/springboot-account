package com.mertycom.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CustomerDto {
    private String id;
    private String name;
    private String surName;
    private Set<CustomerAccountDto> accounts;
}
