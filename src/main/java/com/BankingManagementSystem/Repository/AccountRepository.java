package com.BankingManagementSystem.Repository;

import com.BankingManagementSystem.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByEmailAndPassword(String email, String password);
}
