package com.example.ProjectDiplom.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "type_catalog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TypeCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "catalog_name")
    private String name;

}
