package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PatientDto;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final ModelMapper modelMapper;
    private final PatientRepository patientRepository;

    public List<PatientDto> getShowAllfromService() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(temp -> modelMapper.map(temp, PatientDto.class)).toList();
    }

    public PatientDto getShowByIdfromService(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return modelMapper.map(patient, PatientDto.class);
    }

    public ResponseEntity<PatientDto> postCreatefromService(PatientDto patientDto) {
        patientRepository.save(modelMapper.map(patientDto, Patient.class));
        return ResponseEntity.ok().body(patientDto);
    }

    public ResponseEntity<Void> deleteIdfromService(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patientRepository.delete(patient.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
