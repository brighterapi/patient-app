package com.trootech.milind.mehta.mapper;

import com.trootech.milind.mehta.dto.AppointmentDto;
import com.trootech.milind.mehta.dto.DoctorDto;
import com.trootech.milind.mehta.entity.Appointment;
import com.trootech.milind.mehta.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class PatientMapper {

    public static final PatientMapper MAPPER = Mappers.getMapper(PatientMapper.class);

    @Mapping(target = "dob", expression = "java(java.sql.Date.valueOf(appointmentDto.getDob()))")
    public abstract Appointment mapToAppointment(AppointmentDto appointmentDto, Doctor doctor);

    @Mapping(source = "doctor.id", target = "doctorId")
    public abstract AppointmentDto mapToAppointmentDto(Appointment appointment);

    public abstract DoctorDto mapToDoctorDto(Doctor doctor);

    public abstract Doctor mapToDoctor(DoctorDto doctor);

}
