package com.trootech.milind.mehta.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {

    public static final String VERSION_V1 = "/v1";
    public static final String REQUEST_PATH_APPOINTMENT = "/appointment";
    public static final String REQUEST_PATH_DOCTOR = "/doctor";
    public static final String PATH_PARAM_ID = "/{id}";

    public static final String PHONE_REGEX_PATTERN = "^\\d{8,14}$";
    public static final String EMAIL_REGEX_PATTERN = "^([ ]*[A-Za-z0-9]+[-A-Za-z0-9+.#_]*)@([A-Za-z0-9]+[-A-Za-z0-9#_]*)\\.([A-Za-z0-9\\-]+[.]?[A-Za-z0-9]+[ ]*)$";

    public static final String LOCAL_TIME = "localTime";
    public static final String LOCAL_DATE = "localDate";
    public static final String LOCAL_DATE_TIME = "localDateTime";

    public static final String DOCTOR_NOT_FOUND = "Doctor not found";
    public static final String DOCTOR_IS_UNAVAILABLE_ON_GIVEN_SPECIFIC_TIME = "Doctor is unavailable on given specific time";
    public static final String INVALID_APPOINTMENT_DATE = "Invalid appointment date";
    public static final String INVALID_DOB = "Invalid Date of birth";
    public static final String INVALID_APPOINTMENT_ID = "Invalid appointment id ";
    public static final String INVALID_EMAIL = "Invalid Email";

    public static final String INVALID_DOCTOR_NAME = "Invalid Doctor name";
    public static final String INVALID_SPECIFICATION = "Invalid specification";
    public static final String INVALID_AVAILABILITY_TO_TIME = "Invalid availability To time";
    public static final String INVALID_AVAILABILITY_FROM_TIME = "Invalid Availability From time";

    public static final String INVALID_MOBILE_NUMBER = "Invalid mobile number";
    public static final String INVALID_PATIENT_NAME = "Invalid Patient Name";
    public static final String INVALID_DOCTOR_ID = "Invalid Doctor id";
    public static final String INVALID_APPOINTMENT_DATE_AND_TIME = "Invalid appointment Date and Time";
}
