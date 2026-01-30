package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PatientRequestDto;
import com.example.demo.dto.PatientResponseDto;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final ModelMapper modelMapper;
    private final PatientRepository patientRepository;

    // create
    public ResponseEntity<Void> createfromService(PatientRequestDto patientDto) {
        patientRepository.save(modelMapper.map(patientDto, Patient.class));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // update
    public ResponseEntity<PatientRequestDto> updatefromService(PatientRequestDto patientRequestDto, Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patient.get().setName(patientRequestDto.getName());
            patient.get().setAge(patientRequestDto.getAge());
            patient.get().setHeight(patientRequestDto.getHeight());
            patient.get().setWeight(patientRequestDto.getWeight());
            patientRepository.save(patient.get());
            return ResponseEntity.ok().body(patientRequestDto);
        } else
            return ResponseEntity.notFound().build();
    }

    // read
    public ResponseEntity<List<PatientResponseDto>> readAllfromService() {
        List<Patient> patients = patientRepository.findAll();
        return ResponseEntity.ok()
                .body(patients.stream().map(temp -> modelMapper.map(temp, PatientResponseDto.class)).toList());
    }

    public ResponseEntity<PatientResponseDto> readByIdfromService(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent())
            return ResponseEntity.ok().body(modelMapper.map(patient, PatientResponseDto.class));
        else
            return ResponseEntity.notFound().build();
    }

    // delete
    public ResponseEntity<Void> deleteByIdfromService(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patientRepository.delete(patient.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
