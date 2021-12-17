package com.example.ProjectDiplom.entity;

import com.example.ProjectDiplom.enam.TaskStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", nullable = false)
    private String name;

    @Column(name = " description")
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;


    @OneToOne
    @JoinColumn(name = "custom_id")
    private ClientInfo clientInfo;

    @OneToOne
    @JoinColumn(name = "workers_id")
    private WorkersInfo workersInfo;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne
    @JoinColumn(name = "type_catalog_id")
    private TypeCatalog typeCatalog;
}
