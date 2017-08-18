package com.tt.test.service;

import com.tt.test.domain.EducationEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.EducationDTO;

import java.util.List;

public interface EducationService {

    EducationEntity create(EducationEntity obj);
    EducationEntity create(EducationDTO educationDTO);
    EmployeeEntity findEmployeeById(Long id);
    EducationEntity getEducationById(Long id);
    List<EducationEntity> getAllEducation();
    EducationEntity updateEducation(Long id, EducationDTO educationDTO);
    void deleteEducationById(Long id);
}
