package com.tuandev.app.Controller;


import com.tuandev.app.Dto.Request.CreateAccountRequest;
import com.tuandev.app.Entity.Account;
import com.tuandev.app.Service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
        Account account = accountService.create(createAccountRequest);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAll();
        return ResponseEntity.ok(accounts);
    }

    @PatchMapping("/de-activate/{id}")
    public ResponseEntity<String> deactivateUser(@PathVariable int id){
        accountService.deactivateAccount(id);
        return ResponseEntity.ok("Account with id = " + id + " has been deactivated successfully.");
    }
}



