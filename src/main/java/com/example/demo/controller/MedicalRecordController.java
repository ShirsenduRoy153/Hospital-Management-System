package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MedicalRecordRequestDto;
import com.example.demo.dto.MedicalRecordResponseDto;
import com.example.demo.service.MedicalRecordService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/medicalrecord")
@RequiredArgsConstructor
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    // create
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody MedicalRecordRequestDto medicalRecordRequestDto) {
        return medicalRecordService.createfromService(medicalRecordRequestDto);
    }

    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@RequestBody MedicalRecordRequestDto medicalRecordRequestDto,
            @PathVariable Long id) {
        return medicalRecordService.updatefromService(medicalRecordRequestDto, id);
    }

    // read
    @GetMapping("/readAll")
    public ResponseEntity<List<MedicalRecordResponseDto>> readAll() {
        return medicalRecordService.readAllfromService();
    }

    @GetMapping("/readById/{id}")
    public ResponseEntity<MedicalRecordResponseDto> readById(@PathVariable Long id) {
        return medicalRecordService.readByIdfromService(id);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return medicalRecordService.deletefromService(id);
    }
}