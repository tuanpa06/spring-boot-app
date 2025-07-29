package com.tuandev.app.Controller;

import com.tuandev.app.Dto.Request.CreateBankRequest;
import com.tuandev.app.Dto.Request.UpdateBankRequest;
import com.tuandev.app.Entity.Bank;
import com.tuandev.app.Service.BankService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Bank> updateBank(@PathVariable int id, @RequestBody @Valid UpdateBankRequest updatebankRequest) {
        Bank bank = bankService.update(id, updatebankRequest);
        return ResponseEntity.ok(bank);
    }

    @GetMapping
    public ResponseEntity<List<Bank>> getAllBanks(){
        List<Bank> banks = bankService.getAll();
        return ResponseEntity.ok(banks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBank(@PathVariable int id){
        Bank bank = bankService.getById(id);
        return ResponseEntity.ok(bank);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBank(@PathVariable int id){
        bankService.delete(id);
        return ResponseEntity.ok("Bank with id = " + id + " has been deleted successfully.");
    }
}
