package com.example.ProjectDiplom.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(name = "workers_name", nullable = false)
    private String name;

    @Column(name = "workers_ser_name", nullable = false)
    private String serName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "gender")
    private Boolean gender;

    private LocalDateTime createDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "type_catalog_id")
    private TypeCatalog typeCatalog;

    @PrePersist
    public void CreateDate(){
        this.createDate = LocalDateTime.now();
    }

}
