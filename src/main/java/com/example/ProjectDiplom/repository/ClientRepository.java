package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.ClientInfo;
import com.example.ProjectDiplom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientInfo, Long> {
    Optional<ClientInfo> findByName (String name);
    Optional<ClientInfo> findByUser_username(String username);
    Optional<ClientInfo> findByUser(User user);
}
