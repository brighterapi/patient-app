package com.trootech.milind.mehta.dto;

import com.trootech.milind.mehta.validator.DateTimeFormatValidation;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.trootech.milind.mehta.util.Constants.EMAIL_REGEX_PATTERN;
import static com.trootech.milind.mehta.util.Constants.INVALID_APPOINTMENT_DATE_AND_TIME;
import static com.trootech.milind.mehta.util.Constants.INVALID_DOB;
import static com.trootech.milind.mehta.util.Constants.INVALID_DOCTOR_ID;
import static com.trootech.milind.mehta.util.Constants.INVALID_EMAIL;
import static com.trootech.milind.mehta.util.Constants.INVALID_MOBILE_NUMBER;
import static com.trootech.milind.mehta.util.Constants.INVALID_PATIENT_NAME;
import static com.trootech.milind.mehta.util.Constants.LOCAL_DATE;
import static com.trootech.milind.mehta.util.Constants.LOCAL_DATE_TIME;
import static com.trootech.milind.mehta.util.Constants.PHONE_REGEX_PATTERN;

@Data
@Builder
public class AppointmentDto {

    private Long appointmentId;

    @NotNull(message = INVALID_DOCTOR_ID)
    private Long doctorId;

    @NotBlank(message = INVALID_PATIENT_NAME)
    @Size(min = 3, max = 50, message = INVALID_PATIENT_NAME)
    private String patientName;

    @Email(regexp = EMAIL_REGEX_PATTERN, message = INVALID_EMAIL)
    private String emailId;

    @Pattern(regexp = PHONE_REGEX_PATTERN, message = INVALID_MOBILE_NUMBER)
    private String mobileNo;

    @NotNull(message = INVALID_DOB)
    @DateTimeFormatValidation(convertTo = LOCAL_DATE, message = INVALID_DOB)
    private String dob;

    @NotNull(message = INVALID_APPOINTMENT_DATE_AND_TIME)
    @DateTimeFormatValidation(convertTo = LOCAL_DATE_TIME, message = INVALID_APPOINTMENT_DATE_AND_TIME)
    private String appointment;

}
