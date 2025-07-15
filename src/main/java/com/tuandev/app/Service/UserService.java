package com.tuandev.app.Service;

import com.tuandev.app.Dto.Request.CreateUserRequest;
import com.tuandev.app.Dto.Request.UpdateUserRequest;
import com.tuandev.app.Entity.User;
import com.tuandev.app.Mapper.UserMapper;
import com.tuandev.app.Repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public User create(CreateUserRequest createUserRequest){
        User user = userMapper.toUser(createUserRequest);
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        return userRepository.save(user);
    }

    public User update(int id, UpdateUserRequest updateUserRequest){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));
        user.setEmail(updateUserRequest.getEmail());
        user.setGender(updateUserRequest.getGender());
        user.setPhoneNumber(updateUserRequest.getPhoneNumber());
        user.setBod(updateUserRequest.getBod());

        return userRepository.save(user);
    }
}
