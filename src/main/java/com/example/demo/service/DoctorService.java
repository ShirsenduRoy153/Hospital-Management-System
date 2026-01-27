package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorDto;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepo;
    private final ModelMapper modelMapper;

    // GET ALL
    public ResponseEntity<List<DoctorDto>> getAllfromService() {
        List<Doctor> doctors = doctorRepo.findAll();
        return ResponseEntity.ok(doctors.stream().map(doct -> modelMapper.map(doct, DoctorDto.class)).toList());
    }

    // GET BY ID
    public ResponseEntity<DoctorDto> getByIdfromService(long id) {
        Optional<Doctor> doctorOptional = doctorRepo.findById(id);
        if (doctorOptional.isPresent()) {
            return ResponseEntity.ok(modelMapper.map(doctorOptional, DoctorDto.class));
        } else
            throw new RuntimeException("Doctor not present");
    }

    // POST
    public ResponseEntity<Void> postfromService(DoctorDto doctorDto) {
        doctorRepo.save(modelMapper.map(doctorDto, Doctor.class));
        return ResponseEntity.status(HttpStatus.CREATED).build(); // or body(modelMapper...)
    }

}