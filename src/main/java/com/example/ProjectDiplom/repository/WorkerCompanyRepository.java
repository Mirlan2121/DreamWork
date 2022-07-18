package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.WorkerCompany;
import com.example.ProjectDiplom.entity.WorkersInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerCompanyRepository extends JpaRepository<WorkerCompany, Long> {

    Optional<WorkerCompany> findById( Long id);
    Optional<WorkerCompany> findByCompanyId(Long id);

}
