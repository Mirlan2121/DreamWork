package com.example.ProjectDiplom.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "created_date")
        private LocalDateTime createDate;
        @Column(name = "update_date")
        private LocalDateTime updateDate;

        @PrePersist
        private void onCreate() {
            this.createDate = LocalDateTime.now();
        }

        @PreUpdate
        private void onUpdate() {
            this.updateDate = LocalDateTime.now();
        }
    }
