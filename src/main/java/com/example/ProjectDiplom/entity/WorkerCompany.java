package com.example.ProjectDiplom.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkerCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workers_id")
    private WorkersInfo workersInfo;

    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;
}
