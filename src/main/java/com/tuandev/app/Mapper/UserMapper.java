package com.tuandev.app.Mapper;

import com.tuandev.app.Dto.Request.CreateUserRequest;
import com.tuandev.app.Dto.Response.UserResponse;
import com.tuandev.app.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(CreateUserRequest request);
    UserResponse toUserResponse(User user);
}
