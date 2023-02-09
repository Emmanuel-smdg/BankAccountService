package com.emma.bankaccountservice.Services;

import com.emma.bankaccountservice.entities.dto.BankAccountRequestDto;
import com.emma.bankaccountservice.entities.dto.BankAccountResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankAccountService {
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountRequestDto);
    public List<BankAccountResponseDto> getAccounts();
    public BankAccountResponseDto getAccount(String id);
    public BankAccountResponseDto updateAccount(String id, BankAccountRequestDto bankAccountRequestDto);
    public void deleteAccount(String id);
}
