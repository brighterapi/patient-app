package com.trootech.milind.mehta.dto;

import com.trootech.milind.mehta.validator.DateTimeFormatValidation;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.trootech.milind.mehta.util.Constants.INVALID_AVAILABILITY_FROM_TIME;
import static com.trootech.milind.mehta.util.Constants.INVALID_AVAILABILITY_TO_TIME;
import static com.trootech.milind.mehta.util.Constants.INVALID_DOCTOR_NAME;
import static com.trootech.milind.mehta.util.Constants.INVALID_SPECIFICATION;
import static com.trootech.milind.mehta.util.Constants.LOCAL_TIME;

@Data
@Builder
public class DoctorDto {

    private Long id;

    @NotBlank(message = INVALID_DOCTOR_NAME)
    @Size(min = 3, max = 50, message = INVALID_DOCTOR_NAME)
    private String name;

    @NotBlank(message = INVALID_SPECIFICATION)
    @Size(min = 3, max = 100, message = INVALID_SPECIFICATION)
    private String specification;

    @NotNull(message = INVALID_AVAILABILITY_TO_TIME)
    @DateTimeFormatValidation(convertTo = LOCAL_TIME, message = INVALID_AVAILABILITY_TO_TIME)
    private String availableTo;

    @NotNull(message = INVALID_AVAILABILITY_FROM_TIME)
    @DateTimeFormatValidation(convertTo = LOCAL_TIME, message = INVALID_AVAILABILITY_FROM_TIME)
    private String availableFrom;
}
