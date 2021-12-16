package com.example.ProjectDiplom.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "workers_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkersInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "workers_name", nullable = false, unique = true)
    private String name;

    @Column(name = "workers_ser_name", nullable = false, unique = true)
    private String serName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "cus_status")
    private String status;

    @Column(name = "phone", nullable = false)
    private Integer phone;

    @Column(name = "cus_type", nullable = false)
    private String type;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
