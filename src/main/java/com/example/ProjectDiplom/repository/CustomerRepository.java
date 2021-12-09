package com.example.ProjectDiplom.repository;

import com.example.ProjectDiplom.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerInfo, Long> {
//    Optional<CustomerInfo> findByCustomerName(String customerName);

}
