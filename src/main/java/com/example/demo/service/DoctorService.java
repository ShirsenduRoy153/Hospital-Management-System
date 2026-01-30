package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorRequestDto;
import com.example.demo.dto.DoctorResponseDto;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    // Create
    public ResponseEntity<Void> createfromService(DoctorRequestDto doctorDto) {
        doctorRepository.save(modelMapper.map(doctorDto, Doctor.class));
        return ResponseEntity.status(HttpStatus.CREATED).build(); // or body(modelMapper...)
    }

    // Update
    public ResponseEntity<DoctorRequestDto> updatefromService(Long id, DoctorRequestDto doctorDto) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            doctor.get().setName(doctorDto.getName());
            doctor.get().setAge(doctorDto.getAge());
            doctor.get().setSpecialization(doctorDto.getSpecialization());
            doctor.get().setDepartment(doctorDto.getDepartment());
            doctorRepository.save(doctor.get());
            return ResponseEntity.ok().body(doctorDto);
        } else
            return ResponseEntity.noContent().build();
    }

    // Read
    public ResponseEntity<List<DoctorResponseDto>> readAllfromService() {
        List<Doctor> doctors = doctorRepository.findAll();
        return ResponseEntity.ok(doctors.stream().map(doct -> modelMapper.map(doct, DoctorResponseDto.class)).toList());
    }

    public ResponseEntity<DoctorResponseDto> readByIdfromService(long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            return ResponseEntity.ok(modelMapper.map(doctorOptional, DoctorResponseDto.class));
        } else
            return ResponseEntity.notFound().build();
    }

    // Delete
    public ResponseEntity<Void> deletefromService(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            doctorRepository.delete(doctor.get());
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.noContent().build();
    }
}