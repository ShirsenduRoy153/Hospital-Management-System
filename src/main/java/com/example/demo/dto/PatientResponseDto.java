package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {
    private Long patient_id;
    private String name;
    private Integer age;
    private Float height;
    private Float weight;
}
