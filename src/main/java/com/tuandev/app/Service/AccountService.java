package com.tuandev.app.Service;


import com.tuandev.app.Constants.User.UserStatus;
import com.tuandev.app.Dto.Request.CreateAccountRequest;
import com.tuandev.app.Entity.Account;
import com.tuandev.app.Entity.Bank;
import com.tuandev.app.Entity.User;
import com.tuandev.app.Exception.ResourceNotFoundException;
import com.tuandev.app.Repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService {
    BankService bankService;
    UserService userService;
    AccountRepository accountRepository;

    public Account create(CreateAccountRequest createAccountRequest){
        Bank bank = bankService.getById(createAccountRequest.getBankId());
        User user = userService.getById(createAccountRequest.getUserId());

        Account account = Account.builder()
                .user(user)
                .bank(bank)
                .number(createAccountRequest.getNumber())
                .build();

        return accountRepository.save(account);
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public Account getById(int id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
    }

    public void deactivateAccount(int id){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
        accountRepository.save(account);
    }
}
