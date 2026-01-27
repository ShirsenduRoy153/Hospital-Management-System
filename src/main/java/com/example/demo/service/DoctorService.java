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
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    // POST
    public ResponseEntity<Void> createfromService(DoctorDto doctorDto) {
        doctorRepository.save(modelMapper.map(doctorDto, Doctor.class));
        return ResponseEntity.status(HttpStatus.CREATED).build(); // or body(modelMapper...)
    }

    // GET ALL
    public ResponseEntity<List<DoctorDto>> showAllfromService() {
        List<Doctor> doctors = doctorRepository.findAll();
        return ResponseEntity.ok(doctors.stream().map(doct -> modelMapper.map(doct, DoctorDto.class)).toList());
    }

    // GET BY ID
    public ResponseEntity<DoctorDto> showByIdfromService(long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            return ResponseEntity.ok(modelMapper.map(doctorOptional, DoctorDto.class));
        } else
            return ResponseEntity.ok().build();
    }

    // Update
    public ResponseEntity<DoctorDto> updatefromService(Long id, DoctorDto doctorDto) {
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

    // DELETE
    public ResponseEntity<Void> deletefromService(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            doctorRepository.delete(doctor.get());
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.noContent().build();
    }
}