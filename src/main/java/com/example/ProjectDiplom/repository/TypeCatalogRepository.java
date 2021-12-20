package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.TypeCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeCatalogRepository extends JpaRepository<TypeCatalog, Long> {
    Optional<TypeCatalog> findByName(String name);
}
