package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.AppointmentResponseDto;
import com.example.demo.dto.MedicalRecordResponseDto;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.MedicalRecord;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(MedicalRecord.class, MedicalRecordResponseDto.class)
                .addMappings(n -> n.map(MedicalRecord::getPatient,
                        MedicalRecordResponseDto::setPatientDto));
        modelMapper.typeMap(Appointment.class, AppointmentResponseDto.class)
                .addMappings(mapper -> {
                    mapper.map(Appointment::getDoctor, AppointmentResponseDto::setDoctorDto);
                    mapper.map(Appointment::getPatient, AppointmentResponseDto::setPatientDto);
                });
        return modelMapper;
    }
}
