package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorRequestDto {
    private String name;
    private Integer age;
    private String specialization;
    private String department;
}