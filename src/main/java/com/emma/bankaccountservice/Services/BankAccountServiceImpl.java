package com.emma.bankaccountservice.Services;

import com.emma.bankaccountservice.Repositories.BankAccountRepository;
import com.emma.bankaccountservice.entities.BankAccount;
import com.emma.bankaccountservice.entities.dto.BankAccountMapper;
import com.emma.bankaccountservice.entities.dto.BankAccountRequestDto;
import com.emma.bankaccountservice.entities.dto.BankAccountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    /**
     * @param bankAccountRequestDto
     * @return
     */
    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountRequestDto) {
        BankAccount bankAccount = BankAccountMapper.INSTANCE.fromDto(bankAccountRequestDto);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return BankAccountMapper.INSTANCE.toDto(bankAccount);
    }

    /**
     * @return
     */
    @Override
    public List<BankAccountResponseDto> getAccounts() {
        List<BankAccountResponseDto> list = bankAccountRepository.findAll().stream()
                .map(BankAccountMapper.INSTANCE::toDto).collect(Collectors.toList());
        return list;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public BankAccountResponseDto getAccount(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return BankAccountMapper.INSTANCE.toDto(bankAccount);
    }

    /**
     * @param id
     * @param bankAccountRequestDto
     * @return
     */
    @Override
    public BankAccountResponseDto updateAccount(String id, BankAccountRequestDto bankAccountRequestDto) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        BankAccount account = BankAccountMapper.INSTANCE.fromDto(bankAccountRequestDto);
        account.setId(bankAccount.getId());
        BankAccount savedAccount = bankAccountRepository.save(account);
        return BankAccountMapper.INSTANCE.toDto(savedAccount);

    }

    /**
     * @param id
     */
    @Override
    public void deleteAccount(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        bankAccountRepository.delete(bankAccount);
    }
}
