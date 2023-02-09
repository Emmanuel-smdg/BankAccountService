package com.emma.bankaccountservice.Repositories;

import com.emma.bankaccountservice.entities.BankAccount;
import com.emma.bankaccountservice.entities.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

    @RestResource(path = "/byType")
    List<BankAccount> findByType(@Param("t") AccountType type);

}
