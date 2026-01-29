package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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

    // GET
    public ResponseEntity<List<PatientResponseDto>> showAllfromService() {
        List<Patient> patients = patientRepository.findAll();
        return ResponseEntity.ok()
                .body(patients.stream().map(temp -> modelMapper.map(temp, PatientResponseDto.class)).toList());
    }

    public ResponseEntity<PatientResponseDto> showByIdfromService(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent())
            return ResponseEntity.ok().body(modelMapper.map(patient, PatientResponseDto.class));
        else
            return ResponseEntity.notFound().build();
    }

    // CREATE
    public ResponseEntity<PatientRequestDto> createfromService(PatientRequestDto patientDto) {
        patientRepository.save(modelMapper.map(patientDto, Patient.class));
        return ResponseEntity.ok().body(patientDto);
    }

    // DELETE
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
