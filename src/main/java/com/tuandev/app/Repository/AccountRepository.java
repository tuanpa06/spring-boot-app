package com.tuandev.app.Repository;

import com.tuandev.app.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    boolean existsByNumber(String number);
    Optional<Account> findByNumber(String number);
}
