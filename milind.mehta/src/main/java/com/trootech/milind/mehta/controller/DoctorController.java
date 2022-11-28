package com.trootech.milind.mehta.controller;

import com.trootech.milind.mehta.dto.DoctorDto;
import com.trootech.milind.mehta.service.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.trootech.milind.mehta.util.Constants.PATH_PARAM_ID;
import static com.trootech.milind.mehta.util.Constants.REQUEST_PATH_DOCTOR;
import static com.trootech.milind.mehta.util.Constants.VERSION_V1;

@Slf4j
@RestController
@RequestMapping(VERSION_V1 + REQUEST_PATH_DOCTOR)
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDto> saveDoctor(@Valid @RequestBody DoctorDto doctor) {
        log.debug("saveDoctor started");
        DoctorDto doctorDto = doctorService.saveDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDto);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctors() {
        log.debug("getDoctors started");
        return ResponseEntity.ok(doctorService.findDoctors());
    }

    @GetMapping(PATH_PARAM_ID)
    public ResponseEntity<DoctorDto> findDoctorById(@PathVariable("id") Long doctorId) {
        log.debug("findDoctorById started");
        return ResponseEntity.ok(doctorService.findDoctorById(doctorId));
    }
}
