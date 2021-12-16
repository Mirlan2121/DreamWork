package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.User;
import com.example.ProjectDiplom.entity.WorkersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkersRepository extends JpaRepository<WorkersInfo, Long> {
    Optional<WorkersInfo> findByName(String name);
    Optional<WorkersInfo> findByUser(User user);
}
