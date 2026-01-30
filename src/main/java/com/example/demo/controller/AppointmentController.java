package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AppointmentRequestDto;
import com.example.demo.dto.AppointmentResponseDto;
import com.example.demo.service.AppointmentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    // create
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody AppointmentRequestDto appointmentRequestDto) {
        return appointmentService.createfromService(appointmentRequestDto);
    }

    // update
    @PutMapping("update/{id}")
    public ResponseEntity<AppointmentRequestDto> update(@RequestBody AppointmentRequestDto appointmentRequestDto,
            @PathVariable Long id) {
        return appointmentService.updatefromService(appointmentRequestDto, id);
    }

    // read
    @GetMapping("read")
    public ResponseEntity<List<AppointmentResponseDto>> read() {
        return appointmentService.readfromService();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<AppointmentResponseDto> readById(@PathVariable Long id) {
        return appointmentService.readByIdfromService(id);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return appointmentService.deletefromService(id);
    }
}
