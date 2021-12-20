package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName (String name);
    Optional<Company> findById(Long id);
}
