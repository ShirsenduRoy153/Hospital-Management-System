package com.example.demo.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDto {
    private Long appointment_id;
    private LocalDate appointmentDate;
    private DayOfWeek dayOfWeek;
    private LocalTime appointmentTime;
    private AppointmentResponseDto patientDto;
    private DoctorResponseDto doctorDto;
}
