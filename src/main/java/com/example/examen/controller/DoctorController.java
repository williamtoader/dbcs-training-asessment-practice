package com.example.examen.controller;

import com.example.examen.dto.PatientDto;
import com.example.examen.exceptions.DoctorNotFoundException;
import com.example.examen.exceptions.EmptySpecialtyFilterException;
import com.example.examen.model.Doctor;
import com.example.examen.model.Patient;
import com.example.examen.service.DoctorService;
import com.example.examen.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    private final PatientService patientService;

    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }

    @GetMapping
    public List<Doctor> getAllBySpecialty(@RequestParam String specialty) throws EmptySpecialtyFilterException {
        return doctorService.getAllBySpecialty(specialty);
    }

    @PostMapping
    public Doctor addPatient(@RequestBody PatientDto dto) throws DoctorNotFoundException {
        return doctorService.addPatient(dto.getDoctorsName(), patientService.createPatient(dto));
    }
}
