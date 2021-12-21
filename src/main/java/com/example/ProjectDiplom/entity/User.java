package com.example.ProjectDiplom.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String userInfo;
    private LocalDateTime createDate;
    private Long active;

    @PrePersist
    public void CreateDate(){
        this.createDate = LocalDateTime.now();
    }


}
