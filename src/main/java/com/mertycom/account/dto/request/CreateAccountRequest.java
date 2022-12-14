package com.mertycom.account.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountRequest {
    @NotBlank(message = "CustomerId must not be empty")
    private String customerId;

    @Min(value = 0,message = "Initial Credit value must not be negative value")
    private BigDecimal initialCredit;
}
