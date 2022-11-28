package com.trootech.milind.mehta.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import static com.trootech.milind.mehta.util.Constants.LOCAL_DATE;
import static com.trootech.milind.mehta.util.Constants.LOCAL_DATE_TIME;
import static com.trootech.milind.mehta.util.Constants.LOCAL_TIME;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateTimeFormatValidation.DateTimeFormatValidator.class)
public @interface DateTimeFormatValidation {

    String convertTo();

    String message() default "Invalid local date time format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class DateTimeFormatValidator implements ConstraintValidator<DateTimeFormatValidation, String> {

        private String convertTo;

        @Override
        public void initialize(DateTimeFormatValidation constraintAnnotation) {
            this.convertTo = constraintAnnotation.convertTo();
        }

        public boolean isValid(String localDateTime, ConstraintValidatorContext cxt) {
            if(localDateTime == null){
                return false;
            }
            try {
                if (convertTo.equals(LOCAL_TIME)) {
                    LocalTime.parse(localDateTime, ISO_LOCAL_TIME);
                } else if (convertTo.equals(LOCAL_DATE)) {
                    LocalDate.parse(localDateTime, ISO_DATE);
                } else if (convertTo.equals(LOCAL_DATE_TIME)) {
                    LocalDateTime.parse(localDateTime, ISO_DATE_TIME);
                }
            } catch (DateTimeParseException dateTimeParseException) {
                return false;
            }
            return true;
        }
    }
}