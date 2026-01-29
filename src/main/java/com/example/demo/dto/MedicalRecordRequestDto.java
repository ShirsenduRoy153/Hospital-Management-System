package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordRequestDto {
    private Long medicalrecord_id;
    private String medicalCondition;
    private Long patient_id;
}
