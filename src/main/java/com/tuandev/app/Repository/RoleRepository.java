package com.tuandev.app.Repository;

import com.tuandev.app.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findById(int id);
}
