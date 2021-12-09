package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
//    Optional<UserRole> findByUsername(String username);
}
