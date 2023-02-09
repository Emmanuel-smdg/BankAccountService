package com.emma.bankaccountservice.web;

import com.emma.bankaccountservice.Services.BankAccountService;
import com.emma.bankaccountservice.entities.dto.BankAccountRequestDto;
import com.emma.bankaccountservice.entities.dto.BankAccountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountRestController {
    private final BankAccountService bankAccountService;

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDto> bankAccount() {
        return bankAccountService.getAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDto getAccount(@PathVariable String id) {
        return bankAccountService.getAccount(id);
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDto save(@RequestBody BankAccountRequestDto bankAccount) {
        return bankAccountService.addAccount(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDto update(@PathVariable String id, @RequestBody BankAccountRequestDto bankAccount) {
        return bankAccountService.updateAccount(id, bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        bankAccountService.deleteAccount(id);
    }
}
