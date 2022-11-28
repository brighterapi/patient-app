package com.trootech.milind.mehta.service;

import com.trootech.milind.mehta.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto saveAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> findAll();

    AppointmentDto update(AppointmentDto appointmentDto);
}
