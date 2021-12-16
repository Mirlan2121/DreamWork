package com.example.ProjectDiplom.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer_info")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ClientInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cus_name", nullable = false)
    private String name;

    @Column(name = "cus_ser_name", nullable = false)
    private String serName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "cus_balance")
    private Double balance;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "gender")
    private Boolean gender;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
