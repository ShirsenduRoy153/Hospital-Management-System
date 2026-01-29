package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DoctorRequestDto;
import com.example.demo.dto.DoctorResponseDto;
import com.example.demo.service.DoctorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorSer;

    @GetMapping("/getAll")
    public ResponseEntity<List<DoctorResponseDto>> showAllDoc() {
        return doctorSer.showAllfromService();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DoctorResponseDto> showById(@PathVariable long id) {
        return doctorSer.showByIdfromService(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Void> create(@RequestBody DoctorRequestDto doctorDto) {
        return doctorSer.createfromService(doctorDto);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<DoctorRequestDto> putMethodName(@PathVariable Long id,
            @RequestBody DoctorRequestDto doctorDto) {
        return doctorSer.updatefromService(id, doctorDto);
    }

}
