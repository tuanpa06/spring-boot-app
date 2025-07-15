package com.tuandev.app.Controller;

import com.tuandev.app.Dto.Request.CreateUserRequest;
import com.tuandev.app.Dto.Request.UpdateUserRequest;
import com.tuandev.app.Entity.User;
import com.tuandev.app.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest){
        User user = userService.create(createUserRequest);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody UpdateUserRequest updateUserRequest){
        User user = userService.update(id, updateUserRequest);
        return ResponseEntity.ok(user);
    }
}
