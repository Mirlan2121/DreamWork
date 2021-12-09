package com.example.ProjectDiplom.model;

import com.example.ProjectDiplom.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerInfoModel {
    private String name;
    private String serName;
    private String status;
    private Integer phone;
    private Integer balance;

}
