package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PatientDto;
import com.example.demo.service.PatientService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/showAll")
    public List<PatientDto> getShowAll() {
        return patientService.getShowAllfromService();
    }

    @GetMapping("/showById")
    public PatientDto getShowById(@PathVariable Long id) {
        return patientService.getShowByIdfromService(id);
    }

    @PostMapping("/create")
    public ResponseEntity<PatientDto> postCreate(PatientDto patientDto) {
        return patientService.postCreatefromService(patientDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteId(@PathVariable Long id) {
        return patientService.deleteIdfromService(id);
    }
}
