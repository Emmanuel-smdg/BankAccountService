package com.emma.bankaccountservice.entities.dto;

import com.emma.bankaccountservice.entities.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDto {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency ;
    private AccountType type ;
}
