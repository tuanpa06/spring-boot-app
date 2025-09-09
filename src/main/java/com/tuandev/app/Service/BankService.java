package com.tuandev.app.Service;

import com.tuandev.app.Dto.Request.CreateBankRequest;
import com.tuandev.app.Dto.Request.UpdateBankRequest;
import com.tuandev.app.Entity.Bank;
import com.tuandev.app.Exception.ResourceNotFoundException;
import com.tuandev.app.Mapper.BankMapper;
import com.tuandev.app.Repository.BankRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BankService {
    BankRepository bankRepository;
    BankMapper bankMapper;

    public Bank create(CreateBankRequest createBankRequest){
        Bank bank = bankMapper.bank(createBankRequest);
        return bankRepository.save(bank);
    }

    public Bank update(int id, UpdateBankRequest request) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found with id: " + id));

        bank.setCode(request.getCode());
        bank.setDescription(request.getDescription());
        return bankRepository.save(bank);
    }

    public List<Bank> getAll(){
        return bankRepository.findAll();
    }

    public Bank getById(int id){
        return bankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found with id: " + id));
    }

    public void delete(int id){
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found with id: " + id));
        bankRepository.delete(bank);
    }
}
