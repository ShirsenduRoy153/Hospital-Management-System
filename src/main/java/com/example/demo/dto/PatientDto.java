package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private String name;
    private Integer age;
    private Float height;
    private Float weight;
    private List<MedicalRecordDto> medicalRecords;
    private List<AppointmentDto> appointments;
}
