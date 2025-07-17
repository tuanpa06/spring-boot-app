package com.tuandev.app.Repository;

import com.tuandev.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByIsActive(int isActive);
    Optional<User> findByUsername(String username);
}
