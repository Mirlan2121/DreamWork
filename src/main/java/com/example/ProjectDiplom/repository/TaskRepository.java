package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TaskRepository extends JpaRepository<Task, Long> {

}
