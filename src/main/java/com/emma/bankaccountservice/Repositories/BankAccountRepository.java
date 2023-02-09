package com.emma.bankaccountservice.Repositories;

import com.emma.bankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
