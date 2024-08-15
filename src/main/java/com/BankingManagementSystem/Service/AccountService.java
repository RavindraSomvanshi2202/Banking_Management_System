package com.BankingManagementSystem.Service;

import com.BankingManagementSystem.Entity.Account;
import com.BankingManagementSystem.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account login(String email, String password) {
         return accountRepository.findByEmailAndPassword(email,password);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountDetails(Long id) {
       return accountRepository.findById(id);
    }

    public Account updateAccountDetails(Long id, Account account) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(optionalAccount.isPresent()) {
            Account existingAccount = optionalAccount.get();
            existingAccount.setEmail(account.getEmail());
            existingAccount.setPassword(account.getPassword());
            existingAccount.setAccountHolderName(account.getAccountHolderName());
            existingAccount.setBalance(account.getBalance());
            existingAccount.setContact(account.getContact());
            existingAccount.setAddress(account.getAddress());
            return accountRepository.save(existingAccount);
        }
        return null;
    }

    public Account depositeMoney(Long id, Double amount) {
        Account deposite = getAccountDetails(id).orElseThrow(() -> new RuntimeException("Account not found !"));
        deposite.setBalance(deposite.getBalance() + amount);
        return accountRepository.save(deposite);
    }

    public Account withdrawMoney(Long id, Double amount) {
        Account account = getAccountDetails(id).orElseThrow(() -> new RuntimeException("Account not found !"));
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    public Account deleteAccount(Long id) {
         accountRepository.deleteById(id);
        return null;
    }
}
