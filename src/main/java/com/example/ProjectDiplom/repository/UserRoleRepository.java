package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.ClientInfo;
import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.entity.UserRole;
import com.example.ProjectDiplom.entity.WorkersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByUser(User user);
    Optional<UserRole> findByUser(ClientInfo clientInfo);
    Optional<UserRole> findByUser(WorkersInfo workersInfo);
}
