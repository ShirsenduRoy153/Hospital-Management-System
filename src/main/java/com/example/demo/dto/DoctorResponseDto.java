package com.example.demo.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorResponseDto {
    private Long doctor_id;
    private String name;
    private Integer age;
    private String specialization;
    private String department;
    private List<AppointmentResponseDto> appointments;
}
