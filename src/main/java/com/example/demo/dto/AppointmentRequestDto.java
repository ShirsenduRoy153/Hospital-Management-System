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
public class AppointmentRequestDto {
    private LocalDate appointmentDate;
    private DayOfWeek dayOfWeek;
    private LocalTime appointmentTime;
    private Long doctor_id;
    private Long patient_id;
}
