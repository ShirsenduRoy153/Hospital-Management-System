package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientSummaryDto {
    private Long patient_id;
    private String name;
    private Integer age;
    private Float height;
    private Float weight;
    private List<MedicalRecordResponseDto> medicalRecords;
}
