package com.tt.test.service.impl;

import com.tt.test.domain.EducationEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.EducationEntityRepository;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.EducationService;
import com.tt.test.service.dto.EducationDTO;
import com.tt.test.service.mapper.EducationMapper;
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
    public void create(EducationDTO educationDTO) {
        //sprawdz czy istnieje taki o podanym id
        EmployeeEntity employeeById = findEmployeeById(educationDTO.getEmployeeId());
        EducationEntity educationEntity = educationMapper.asEducationEntity(educationDTO);
        educationEntity.setEmployeeEntity(employeeById);

        educationEntityRepository.save(educationEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return employeeEntityRepository.findOne(id);
    }

    @Override
    public EducationEntity getEducationById(Long id) {
        return educationEntityRepository.findOne(id);
    }

    @Override
    public List<EducationEntity> getAllEducations() {
        return educationEntityRepository.findAll();
    }

    @Override
    public void updateEducation(Long id, EducationDTO educationDTO) {
        //sprawdz czy istnieje
        EducationEntity educationById = getEducationById(id);
        EducationEntity educationEntity = educationMapper.asEducationEntity(educationDTO);
        educationEntity.setId(educationById.getId());

        EmployeeEntity employeeById = findEmployeeById(educationDTO.getEmployeeId());
        educationEntity.setEmployeeEntity(employeeById);

        educationEntityRepository.save(educationEntity);
    }

    @Override
    public void deleteEducationById(Long id) {
        educationEntityRepository.delete(id);
    }
}
