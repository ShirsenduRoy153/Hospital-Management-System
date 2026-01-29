package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordResponseDto {
    private Long medicalrecord_id;
    private String medicalCondition;
    private PatientResponseDto patientDto;
}
