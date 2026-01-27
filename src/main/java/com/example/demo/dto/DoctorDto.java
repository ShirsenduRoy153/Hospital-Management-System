package com.example.demo.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDto {
    private Long doctor_id;
    private String name;
    private Integer age;
    private String specialization;
    private String department;
    private List<AppointmentDto> appointments;
}
