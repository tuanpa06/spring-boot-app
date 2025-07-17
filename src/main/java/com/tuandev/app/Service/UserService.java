package com.tuandev.app.Service;

import com.tuandev.app.Constants.User.UserStatus;
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

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public User create(CreateUserRequest createUserRequest){
        if (userRepository.findByUsername(createUserRequest.getUsername()).isPresent())
            throw new RuntimeException("Username already exists: " + createUserRequest.getUsername());

        User user = userMapper.toUser(createUserRequest);
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        user.setIsActive(UserStatus.ACTIVE.getValue());
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

    public List<User> getAll(){
        return userRepository.findByIsActive(UserStatus.ACTIVE.getValue());
    }

    public User getById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public void delete(int id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }

    public void deactivateUser(int id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setIsActive(UserStatus.INACTIVE.getValue());
        userRepository.save(user);
    }
}
