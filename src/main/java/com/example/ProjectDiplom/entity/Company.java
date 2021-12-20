package com.example.ProjectDiplom.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name", nullable = false)
    private String name;
    @Column(name = " description", nullable = false)
    private String description;
    @Column(name = "address")
    private String address;
    @Column(name = "company_email", nullable = false)
    private String email;
    @Column(name = "company_phone", nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "type_catalog_id")
    private TypeCatalog typeCatalog;
}
