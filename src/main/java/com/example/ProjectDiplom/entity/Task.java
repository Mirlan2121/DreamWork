package com.example.ProjectDiplom.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name", nullable = false)
    private String name;
    @Column(name = "task_type")
    private String type;
    @Column(name = " description")
    private String description;

    @OneToOne
    @JoinColumn(name = "custom_id")
    private ClientInfo clientInfo;

    @OneToOne
    @JoinColumn(name = "workers_id")
    private WorkersInfo workersInfo;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
