package com.tuandev.app.Controller;

import com.tuandev.app.Dto.Request.CreateBankRequest;
import com.tuandev.app.Dto.Request.CreateUserRequest;
import com.tuandev.app.Dto.Request.UpdateBankRequest;
import com.tuandev.app.Dto.Request.UpdateUserRequest;
import com.tuandev.app.Entity.Bank;
import com.tuandev.app.Entity.User;
import com.tuandev.app.Service.BankService;
import com.tuandev.app.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banks")
public class BankController {
    private final BankService bankService;

    @PostMapping
    public ResponseEntity<Bank> createBank(@RequestBody @Valid CreateBankRequest createBankRequest){
        Bank bank = bankService.create(createBankRequest);
        return ResponseEntity.ok(bank);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bank> updateUser(@PathVariable int id, @RequestBody @Valid UpdateBankRequest updatebankRequest) {
        Bank bank = bankService.update(id, updatebankRequest);
        return ResponseEntity.ok(bank);
    }


}
