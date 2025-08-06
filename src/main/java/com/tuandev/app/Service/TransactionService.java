package com.tuandev.app.Service;

import com.tuandev.app.Dto.Request.CreateTransactionRequest;
import com.tuandev.app.Entity.Account;
import com.tuandev.app.Entity.Bank;
import com.tuandev.app.Entity.Transaction;
import com.tuandev.app.Exception.ResourceNotFoundException;
import com.tuandev.app.Repository.AccountRepository;
import com.tuandev.app.Repository.BankRepository;
import com.tuandev.app.Repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class TransactionService {
    TransactionRepository transactionRepository;
    AccountRepository accountRepository;
    BankRepository bankRepository;

    @Transactional
    public Transaction create(CreateTransactionRequest createTransaction){
        Account senderAccount = accountRepository.findByNumber(createTransaction.getSenderNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Sender not found"));

        Account receiverAccount = accountRepository.findByNumber((createTransaction.getReceiverNumber()))
                .orElseThrow(() -> new ResourceNotFoundException("Receiver not found"));

        var amount = createTransaction.getAmount();
        var senderBalance = senderAccount.getBalance();
        var receiverBalance = receiverAccount.getBalance();
        var senderCode = createTransaction.getSenderBank();
        var receiverCode = createTransaction.getReceiverBank();

        Bank senderBank = bankRepository.findByCode(senderCode)
                .orElseThrow(() -> new ResourceNotFoundException("Bank with code " + senderCode + "not found"));

        Bank receiverBank = bankRepository.findByCode(receiverCode)
                .orElseThrow(() -> new ResourceNotFoundException("Bank with code " + receiverCode + "not found"));

        if ( senderBalance < amount){
            throw new RuntimeException("Insufficient balance");
        }

        // Update balance
        senderAccount.setBalance(senderBalance - amount);
        receiverAccount.setBalance(receiverBalance + amount);

        Transaction transaction = Transaction.builder()
                .senderNumber(createTransaction.getSenderNumber())
                .receiverNumber(createTransaction.getReceiverNumber())
                .senderBank(senderBank.getName())
                .receiverBank(receiverBank.getName())
                .amount(amount)
                .note(createTransaction.getNote())
                .build();

        transaction = transactionRepository.save(transaction);
        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);

        return transaction;
    }
}

