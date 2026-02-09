package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PatientRequestDto;
import com.example.demo.dto.PatientResponseDto;
import com.example.demo.service.PatientService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    // create
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody PatientRequestDto patientDto) {
        return patientService.createfromService(patientDto);
    }

    // update
    @PutMapping("update/{id}")
    public ResponseEntity<PatientRequestDto> update(@RequestBody PatientRequestDto patientDto,
            @PathVariable Long id) {
        return patientService.updatefromService(patientDto, id);
    }

    // read
    @GetMapping("/readAll")
    public ResponseEntity<List<PatientResponseDto>> readAll() {
        return patientService.readAllfromService();
    }

    @GetMapping("/readById/{id}")
    public ResponseEntity<PatientResponseDto> readById(@PathVariable Long id) {
        return patientService.readByIdfromService(id);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return patientService.deleteByIdfromService(id);
    }
}
