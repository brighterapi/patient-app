package com.trootech.milind.mehta.service;

import com.trootech.milind.mehta.dto.AppointmentDto;
import com.trootech.milind.mehta.dto.DoctorDto;
import com.trootech.milind.mehta.entity.Appointment;
import com.trootech.milind.mehta.repository.AppointmentRepository;
import com.trootech.milind.mehta.validator.AppointmentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.trootech.milind.mehta.mapper.PatientMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final AppointmentValidator appointmentValidator;

    @Override
    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
        DoctorDto doctor = doctorService.findDoctorById(appointmentDto.getDoctorId());
        appointmentValidator.validateAppointment(doctor, appointmentDto);
        Appointment appointment = appointmentRepository.save(MAPPER.mapToAppointment(appointmentDto, MAPPER.mapToDoctor(doctor)));
        return MAPPER.mapToAppointmentDto(appointment);
    }

    @Override
    public List<AppointmentDto> findAll() {
        return appointmentRepository.findAll().stream().map(MAPPER::mapToAppointmentDto).collect(Collectors.toList());
    }

    @Override
    public AppointmentDto update(AppointmentDto appointmentDto) {
        appointmentValidator.validateAppointmentId(appointmentDto.getAppointmentId());
        DoctorDto doctor = doctorService.findDoctorById(appointmentDto.getDoctorId());
        appointmentValidator.validateAppointment(doctor, appointmentDto);
        Appointment appointment = appointmentRepository.save(MAPPER.mapToAppointment(appointmentDto, MAPPER.mapToDoctor(doctor)));
        return MAPPER.mapToAppointmentDto(appointment);
    }
}
