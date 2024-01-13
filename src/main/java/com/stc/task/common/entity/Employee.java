package com.stc.task.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
@Entity
public class Employee {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private double salary;
}
