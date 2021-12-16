package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.Task;
import com.example.ProjectDiplom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByTask_name(String name);
    Optional<Task> findByUser(User user);


}
