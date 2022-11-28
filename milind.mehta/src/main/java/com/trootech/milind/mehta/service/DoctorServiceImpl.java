package com.trootech.milind.mehta.service;

import com.trootech.milind.mehta.dto.DoctorDto;
import com.trootech.milind.mehta.entity.Doctor;
import com.trootech.milind.mehta.exception.DoctorNotFoundException;
import com.trootech.milind.mehta.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.trootech.milind.mehta.mapper.PatientMapper.MAPPER;
import static com.trootech.milind.mehta.util.Constants.DOCTOR_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public DoctorDto saveDoctor(DoctorDto doctorDto) {
        return MAPPER.mapToDoctorDto(doctorRepository.save(MAPPER.mapToDoctor(doctorDto)));
    }

    @Override
    public List<DoctorDto> findDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(MAPPER::mapToDoctorDto).collect(Collectors.toList());
    }

    @Override
    public DoctorDto findDoctorById(Long doctorId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if (!optionalDoctor.isPresent()) {
            throw new DoctorNotFoundException(DOCTOR_NOT_FOUND);
        }
        return MAPPER.mapToDoctorDto(optionalDoctor.get());
    }


}
