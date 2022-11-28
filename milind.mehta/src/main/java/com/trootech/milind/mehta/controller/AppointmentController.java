package com.trootech.milind.mehta.controller;

import com.trootech.milind.mehta.dto.AppointmentDto;
import com.trootech.milind.mehta.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.trootech.milind.mehta.util.Constants.REQUEST_PATH_APPOINTMENT;
import static com.trootech.milind.mehta.util.Constants.VERSION_V1;

@Slf4j
@RestController
@RequestMapping(VERSION_V1+ REQUEST_PATH_APPOINTMENT)
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDto> saveAppointment(@Valid @RequestBody AppointmentDto appointmentDto) {
        log.debug("saveAppointment stated");
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.saveAppointment(appointmentDto));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> listAppointment() {
        log.debug("listAppointment stated");
        return ResponseEntity.ok(appointmentService.findAll());

    }

    @PutMapping
    public ResponseEntity<AppointmentDto> updateAppointment(
            @Valid @RequestBody AppointmentDto appointmentDto) {
        log.debug("listAppointment stated");
        return ResponseEntity.ok(appointmentService.update(appointmentDto));

    }


}
