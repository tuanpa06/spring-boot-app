package com.tuandev.app.Mapper;

import com.tuandev.app.Dto.Request.CreateBankRequest;
import com.tuandev.app.Dto.Request.CreateUserRequest;
import com.tuandev.app.Dto.Response.BankResponse;
import com.tuandev.app.Dto.Response.UserResponse;
import com.tuandev.app.Entity.Bank;
import com.tuandev.app.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankMapper {
    Bank bank(CreateBankRequest request);
}

