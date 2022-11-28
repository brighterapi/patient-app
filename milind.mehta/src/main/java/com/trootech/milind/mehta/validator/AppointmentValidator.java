package com.trootech.milind.mehta.validator;


import com.trootech.milind.mehta.dto.AppointmentDto;
import com.trootech.milind.mehta.dto.DoctorDto;
import com.trootech.milind.mehta.exception.InvalidCaseException;
import com.trootech.milind.mehta.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.trootech.milind.mehta.util.Constants.DOCTOR_IS_UNAVAILABLE_ON_GIVEN_SPECIFIC_TIME;
import static com.trootech.milind.mehta.util.Constants.INVALID_APPOINTMENT_DATE;
import static com.trootech.milind.mehta.util.Constants.INVALID_APPOINTMENT_ID;
import static java.time.LocalDateTime.parse;

@Component
public class AppointmentValidator {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void validateAppointment(DoctorDto doctor, AppointmentDto appointmentDto) {
        LocalDateTime appointmentDateTime = parse(appointmentDto.getAppointment());
        validateAvailabilityOfDr(doctor, appointmentDateTime);
        validateBookingDate(appointmentDateTime);
    }

    public void validateAppointmentId(Long appointmentId) {
        if (appointmentId == null || appointmentRepository.findById(appointmentId).isEmpty()) {
            throw new InvalidCaseException(INVALID_APPOINTMENT_ID);
        }
    }

    private void validateAvailabilityOfDr(DoctorDto doctor, LocalDateTime appointmentDate) {
        if (!(LocalTime.parse(doctor.getAvailableFrom()).getHour() < appointmentDate.getHour()
                && LocalTime.parse(doctor.getAvailableTo()).getHour() > appointmentDate.getHour())) {
            throw new InvalidCaseException(DOCTOR_IS_UNAVAILABLE_ON_GIVEN_SPECIFIC_TIME);
        }
    }

    private void validateBookingDate(LocalDateTime appointmentDateTime) {
        if (appointmentDateTime.isBefore(LocalDateTime.now())) {
            throw new InvalidCaseException(INVALID_APPOINTMENT_DATE);
        }
    }
}
