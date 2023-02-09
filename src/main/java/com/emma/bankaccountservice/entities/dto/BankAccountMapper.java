package com.emma.bankaccountservice.entities.dto;

import com.emma.bankaccountservice.entities.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankAccountMapper {
    BankAccountMapper INSTANCE = Mappers.getMapper( BankAccountMapper.class );

    BankAccount fromDto(BankAccountRequestDto bankAccountRequestDto);

    BankAccountResponseDto toDto(BankAccount bankAccount);
}
