package com.tuandev.app.Repository;

import com.tuandev.app.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    boolean existsByCode(String code);
    Optional<Bank> findByCode(String code);
}
