package com.BankingManagementSystem.Controller;

import com.BankingManagementSystem.Entity.Account;
import com.BankingManagementSystem.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

// Login Method
    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody LoginController loginController) {
        String Email = loginController.getEmail();
        String Password = loginController.getPassword();
        Account account = accountService.login(Email,Password);
        if(account == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(account);
        }
    }

// Create Account Method
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
       Account createAccount = accountService.createAccount(account);
       return ResponseEntity.ok(createAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> getAccountDetails(@PathVariable Long id) {
        Optional<Account> optionalAccount = accountService.getAccountDetails(id);
        if(optionalAccount.isPresent()) {
            return ResponseEntity.ok(optionalAccount);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Account> updateAccountDetails(@PathVariable Long id, @RequestBody Account account) {
        Account account1 = accountService.updateAccountDetails(id, account);
        if(account == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(account1);
        }

    }

    @PostMapping("/{id}/deposite")
    public Account depositeMoney(@PathVariable Long id, @RequestBody Map<String, Double> request) {
       Double Amount = request.get("amount");
       return accountService.depositeMoney(id,Amount);
    }

    @PostMapping("/{id}/withdraw")
    public Account withdrawMoney(@PathVariable Long id, @RequestBody Map<String,Double> request) {
        Double Amount = request.get("amount");
        return accountService.withdrawMoney(id,Amount);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
       Account account = accountService.deleteAccount(id);
       if(account != null) {
           return ResponseEntity.notFound().build();
       } else {
            return ResponseEntity.ok("Account Deleted Successfully !");
       }

    }


}
