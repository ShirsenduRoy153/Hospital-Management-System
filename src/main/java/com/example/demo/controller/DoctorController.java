package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DoctorRequestDto;
import com.example.demo.dto.DoctorResponseDto;
import com.example.demo.service.DoctorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    // create
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody DoctorRequestDto doctorDto) {
        return doctorService.createfromService(doctorDto);
    }

    // update
    @PutMapping("update/{id}")
    public ResponseEntity<DoctorRequestDto> update(@RequestBody DoctorRequestDto doctorDto, @PathVariable Long id) {
        return doctorService.updatefromService(doctorDto, id);
    }

    // read
    @GetMapping("/readAll")
    public ResponseEntity<List<DoctorResponseDto>> readAll() {
        return doctorService.readAllfromService();
    }

    @GetMapping("/readById/{id}")
    public ResponseEntity<DoctorResponseDto> readById(@PathVariable long id) {
        return doctorService.readByIdfromService(id);
    }

    // delete
    @DeleteMapping("/delete/{id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return doctorService.deletefromService(id);
    }

}
