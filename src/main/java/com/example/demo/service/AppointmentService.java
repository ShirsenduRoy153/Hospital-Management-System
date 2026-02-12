package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AppointmentRequestDto;
import com.example.demo.dto.AppointmentResponseDto;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    // create
    public ResponseEntity<Void> createfromService(AppointmentRequestDto appointmentRequestDto) {
        Appointment appointment = new Appointment();

        appointment.setAppointmentDate(appointmentRequestDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentRequestDto.getAppointmentTime());
        appointment.setDayOfWeek(appointmentRequestDto.getAppointmentDate().getDayOfWeek());

        Doctor doctor = doctorRepository.findById(appointmentRequestDto.getDoctor_id())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(appointmentRequestDto.getPatient_id())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        appointmentRepository.save(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // update
    public ResponseEntity<Void> updatefromService(AppointmentRequestDto appointmentRequestDto,
            Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointment.get().setAppointmentDate(appointmentRequestDto.getAppointmentDate());
            appointment.get().setAppointmentTime(appointmentRequestDto.getAppointmentTime());
            Optional<Patient> patient = patientRepository.findById(appointmentRequestDto.getPatient_id());
            if (patient.isPresent())
                appointment.get().setPatient(patient.get());
            else
                return ResponseEntity.notFound().build();
            Optional<Doctor> doctor = doctorRepository.findById(appointmentRequestDto.getDoctor_id());
            if (doctor.isPresent())
                appointment.get().setDoctor(doctor.get());
            else
                return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else
            return ResponseEntity.notFound().build();
    }

    // read
    public ResponseEntity<List<AppointmentResponseDto>> readAllfromService() {
        List<Appointment> appointment = appointmentRepository.findAll();
        List<AppointmentResponseDto> appointmentResponseDtos = appointment.stream()
                .map(n -> modelMapper.map(n, AppointmentResponseDto.class)).toList();
        return ResponseEntity.ok().body(appointmentResponseDtos);
    }

    public ResponseEntity<AppointmentResponseDto> readByIdfromService(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent())
            return ResponseEntity.ok().body(modelMapper.map(appointment.get(), AppointmentResponseDto.class));
        else
            return ResponseEntity.notFound().build();
    }

    // delete
    public ResponseEntity<Void> deletefromService(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointmentRepository.delete(appointment.get());
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }
}