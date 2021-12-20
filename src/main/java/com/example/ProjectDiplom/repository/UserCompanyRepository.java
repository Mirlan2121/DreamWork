package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.UserCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserCompanyRepository extends JpaRepository<UserCompany, Long> {
    @Query(value = "select * from user_company where user_id = :id", nativeQuery = true)
    Optional<List<UserCompany>> findByUserId(@Param("id") Long id);
    Optional<UserCompany> findByCompanyId(Long id);
}
