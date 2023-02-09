package com.emma.bankaccountservice.entities.dto;

import com.emma.bankaccountservice.entities.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDto {
    private Double balance;
    private String currency ;
    private AccountType type ;
}
