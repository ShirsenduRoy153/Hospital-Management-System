package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DoctorDto;
import com.example.demo.service.DoctorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorSer;

    @GetMapping("/getAll")
    public ResponseEntity<List<DoctorDto>> getAll() {
        return doctorSer.getAllfromService();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DoctorDto> getById(@PathVariable long id) {
        return doctorSer.getByIdfromService(id);
    }

    @PostMapping("/post")
    public void postMethodName(@RequestBody DoctorDto doctorDto) {
        doctorSer.postfromService(doctorDto);
    }

}
