package com.tuandev.app.Controller;

import com.tuandev.app.Dto.Request.CreateUserRequest;
import com.tuandev.app.Dto.Request.UpdateUserRequest;
import com.tuandev.app.Entity.User;
import com.tuandev.app.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserRequest createUserRequest){
        User user = userService.create(createUserRequest);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody @Valid UpdateUserRequest updateUserRequest){
        User user = userService.update(id, updateUserRequest);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.delete(id);
        String a = "User with id = " + id + " has been deleted successfully.";
        return ResponseEntity.ok(a);
    }
}
