package com.emma.bankaccountservice.web;

import com.emma.bankaccountservice.Repositories.BankAccountRepository;
import com.emma.bankaccountservice.Services.BankAccountService;
import com.emma.bankaccountservice.entities.BankAccount;
import com.emma.bankaccountservice.entities.dto.BankAccountRequestDto;
import com.emma.bankaccountservice.entities.dto.BankAccountResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private BankAccountRepository bankAccountRepository;


    @QueryMapping
    public List<BankAccount> accountList() {
        //return bankAccountService.getAccounts();
        return bankAccountRepository.findAll();

    }

    @QueryMapping
    public BankAccountResponseDto accountById(@Argument String id) {
        return bankAccountService.getAccount(id);
    }

    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDto bankAccount) {
        return bankAccountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDto updateAccount(@Argument String id, @Argument BankAccountRequestDto bankAccount) {
        return bankAccountService.updateAccount(id ,bankAccount);
    }

    @MutationMapping
    public  Boolean deleteAccount(@Argument String id) {
        bankAccountService.deleteAccount(id);
        return true;
    }


}
