package com.tuandev.app.Service;

import com.tuandev.app.Dto.Request.CreateBankRequest;
import com.tuandev.app.Dto.Request.UpdateBankRequest;
import com.tuandev.app.Dto.Request.UpdateUserRequest;
import com.tuandev.app.Entity.Bank;
import com.tuandev.app.Entity.User;
import com.tuandev.app.Mapper.BankMapper;
import com.tuandev.app.Repository.BankRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BankService {
    BankRepository bankRepository;
    BankMapper bankMapper;
    PasswordEncoder passwordEncoder;

    public Bank create(CreateBankRequest createBankRequest){
        Bank bank = bankMapper.bank(createBankRequest);
        return bankRepository.save(bank);
    }

    public Bank update(int id, UpdateBankRequest request) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank not found with id: " + id));

        bank.setCode(request.getCode());
        bank.setDescription(request.getDescription());
        bank.setUpdatedAt(LocalDate.now());
        return bankRepository.save(bank);
    }

    public Bank getById(int id){
        return bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank not found with id: " + id));
    }

    public void delete(int id){
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank not found with id: " + id));
        bankRepository.delete(bank);
    }
}
