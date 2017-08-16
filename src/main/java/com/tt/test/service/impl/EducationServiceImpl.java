package com.tt.test.service.impl;

import com.tt.test.domain.EducationEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.EducationEntityRepository;
import com.tt.test.service.EducationService;
import com.tt.test.service.dto.EducationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    private EducationEntityRepository educationEntityRepository;

    @Autowired
    public EducationServiceImpl(EducationEntityRepository educationEntityRepository) {
        this.educationEntityRepository = educationEntityRepository;
    }

    @Override
    public void create(EducationEntity obj) {
        educationEntityRepository.save(obj);
    }

    @Override
    public void create(EducationDTO educationDTO) {

    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return null;
    }

    @Override
    public EducationEntity getEducationById(Long id) {
        return null;
    }

    @Override
    public List<EducationEntity> getAllEducations() {
        return null;
    }

    @Override
    public void updateEducation(Long id, EducationDTO educationDTO) {

    }

    @Override
    public void deleteEducationById(Long id) {

    }
}
