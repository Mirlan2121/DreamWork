package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.WorkerCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserCompanyRepository extends JpaRepository<WorkerCompany, Long> {
    @Query(value = "select * from user_company where user_id = :id", nativeQuery = true)
    Optional<List<WorkerCompany>> findByUserId(@Param("id") Long id);
    Optional<WorkerCompany> findByCompanyId(Long id);
}
