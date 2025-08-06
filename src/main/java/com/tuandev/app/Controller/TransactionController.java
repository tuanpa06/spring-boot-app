package com.tuandev.app.Controller;

import com.tuandev.app.Dto.Request.CreateTransactionRequest;
import com.tuandev.app.Entity.Transaction;
import com.tuandev.app.Service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody @Valid CreateTransactionRequest createTransactionRequest) {
        Transaction transaction = transactionService.create(createTransactionRequest);
        return ResponseEntity.ok(transaction);
    }
}

