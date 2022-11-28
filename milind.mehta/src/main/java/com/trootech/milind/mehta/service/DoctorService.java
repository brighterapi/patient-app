package com.trootech.milind.mehta.service;

import com.trootech.milind.mehta.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto saveDoctor(DoctorDto doctor);

    List<DoctorDto> findDoctors();

    DoctorDto findDoctorById(Long doctorId);
}
