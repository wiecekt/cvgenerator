package com.tt.test.service.impl;

import com.tt.test.domain.EducationEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.EducationEntityRepository;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.EducationService;
import com.tt.test.service.dto.EducationDTO;
import com.tt.test.service.mapper.EducationMapper;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    private EducationEntityRepository educationEntityRepository;
    private EmployeeEntityRepository employeeEntityRepository;
    private EducationMapper educationMapper;

    @Autowired
    public EducationServiceImpl(EducationEntityRepository educationEntityRepository, EmployeeEntityRepository employeeEntityRepository) {
        this.educationEntityRepository = educationEntityRepository;
        this.employeeEntityRepository = employeeEntityRepository;
        this.educationMapper = Selma.builder(EducationMapper.class).build();
    }

    @Override
    public void create(EducationEntity obj) {
        educationEntityRepository.save(obj);
    }

    @Override
    public EducationEntity create(EducationDTO educationDTO) {
        EmployeeEntity employeeById = findEmployeeById(educationDTO.getEmployeeId());
        EducationEntity educationEntity = educationMapper.asEducationEntity(educationDTO);
        educationEntity.setEmployeeEntity(employeeById);

        return educationEntityRepository.save(educationEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findOne(id);
        if (employeeEntity == null)
            throw new ResourceNotFoundException("Employee with id = " + id + " was not found.");
        return employeeEntity;
    }

    @Override
    public EducationEntity getEducationById(Long id) {
        EducationEntity educationEntity = educationEntityRepository.findOne(id);
        if (educationEntity == null)
            throw new ResourceNotFoundException("Education with id = " + id + " was not found.");
        return educationEntity;
    }

    @Override
    public List<EducationEntity> getAllEducation() {
        return educationEntityRepository.findAll();
    }

    @Override
    public EducationEntity updateEducation(Long id, EducationDTO educationDTO) {
        EducationEntity educationEntity = educationMapper.asEducationEntity(educationDTO);
        if (checkIfExists(id))
            educationEntity.setId(id);

        EmployeeEntity employeeById = findEmployeeById(educationDTO.getEmployeeId());
        educationEntity.setEmployeeEntity(employeeById);

        return educationEntityRepository.save(educationEntity);
    }

    @Override
    public void deleteEducationById(Long id) {
        if(checkIfExists(id))
            educationEntityRepository.delete(id);
    }

    @Override
    public boolean checkIfExists(Long id) {
        if (!educationEntityRepository.exists(id))
            throw new ResourceNotFoundException("Ability with id = " + id + " was not found.");
        return true;
    }
}
