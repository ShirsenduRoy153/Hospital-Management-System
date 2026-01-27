package com.example.demo.dto;

import lombok.Data;

@Data
public class MedicalRecordDto {
    private Long medicalrecord_id;
    private String medicalCondition;
    private PatientDto patientDto;
}
