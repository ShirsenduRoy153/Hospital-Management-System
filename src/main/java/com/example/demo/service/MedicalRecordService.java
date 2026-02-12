package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MedicalRecordRequestDto;
import com.example.demo.dto.MedicalRecordResponseDto;
import com.example.demo.entity.MedicalRecord;
import com.example.demo.entity.Patient;
import com.example.demo.repository.MedicalRecordRepository;
import com.example.demo.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    // CREATE
    public ResponseEntity<Void> createfromService(MedicalRecordRequestDto medicalRecordRequestDto) {
        Patient patient = patientRepository.findById(medicalRecordRequestDto.getPatient_id())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedicalCondition(medicalRecordRequestDto.getMedicalCondition());
        medicalRecord.setPatient(patient);

        medicalRecordRepository.save(medicalRecord);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // UPDATE
    public ResponseEntity<MedicalRecordResponseDto> updatefromService(MedicalRecordRequestDto medicalRecordRequestDto,
            Long id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordRepository.findById(id);
        if (medicalRecord.isPresent()) {
            medicalRecord.get().setMedicalCondition(medicalRecordRequestDto.getMedicalCondition());
            Optional<Patient> patient = patientRepository.findById(medicalRecordRequestDto.getPatient_id());
            if (patient.isPresent()) {
                medicalRecord.get().setPatient(patient.get());
                medicalRecordRepository.save(medicalRecord.get());
                return ResponseEntity.status(HttpStatus.OK)
                        .body(modelMapper.map(medicalRecord, MedicalRecordResponseDto.class));
            } else
                return ResponseEntity.notFound().build();
        } else
            return ResponseEntity.notFound().build();
    }

    // READ
    public ResponseEntity<List<MedicalRecordResponseDto>> readAllfromService() {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findAll();
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(medicalRecords.stream().map(n -> modelMapper.map(n, MedicalRecordResponseDto.class)).toList());
    }

    public ResponseEntity<MedicalRecordResponseDto> readByIdfromService(Long id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordRepository.findById(id);
        if (medicalRecord.isPresent()) {
            MedicalRecordResponseDto medicalRecordResponseDto = modelMapper.map(medicalRecord,
                    MedicalRecordResponseDto.class);
            return ResponseEntity.status(HttpStatus.FOUND).body(medicalRecordResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    public ResponseEntity<Void> deletefromService(Long id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordRepository.findById(id);
        if (medicalRecord.isPresent())
            return ResponseEntity.status(HttpStatus.OK).build();
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}