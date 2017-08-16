package com.tt.test.service;

import com.tt.test.domain.EducationEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.EducationDTO;

import java.util.List;

public interface EducationService {

    void create(EducationEntity obj);
    void create(EducationDTO educationDTO);
    EmployeeEntity findEmployeeById(Long id);
    EducationEntity getEducationById(Long id);
    List<EducationEntity> getAllEducation();
    void updateEducation(Long id, EducationDTO educationDTO);
    void deleteEducationById(Long id);
}
