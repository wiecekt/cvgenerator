package com.tt.test.service.impl;

import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.AdditionalInfoEntityRepository;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.AdditionalInfoService;
import com.tt.test.service.dto.AdditionalInfoDTO;
import com.tt.test.service.mapper.AdditionalInfoMapper;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalInfoServiceImpl implements AdditionalInfoService {

    private AdditionalInfoEntityRepository additionalInfoEntityRepository;
    private EmployeeEntityRepository employeeEntityRepository;
    private AdditionalInfoMapper additionalInfoMapper;

    @Autowired
    public AdditionalInfoServiceImpl(AdditionalInfoEntityRepository additionalInfoEntityRepository, EmployeeEntityRepository employeeEntityRepository) {
        this.additionalInfoEntityRepository = additionalInfoEntityRepository;
        this.employeeEntityRepository = employeeEntityRepository;
        this.additionalInfoMapper = Selma.builder(AdditionalInfoMapper.class).build();
    }

    @Override
    public void create(AdditionalInfoEntity obj) {
        additionalInfoEntityRepository.save(obj);
    }

    @Override
    public AdditionalInfoEntity create(AdditionalInfoDTO additionalInfoDTO) {
        EmployeeEntity employeeById = findEmployeeById(additionalInfoDTO.getEmployeeId());
        AdditionalInfoEntity additionalInfoEntity = additionalInfoMapper.asAdditionalInfoEntity(additionalInfoDTO);
        additionalInfoEntity.setEmployeeEntity(employeeById);

        return additionalInfoEntityRepository.save(additionalInfoEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findOne(id);
        if (employeeEntity == null)
            throw new ResourceNotFoundException("Employee with id = " + id + " was not found.");
        return employeeEntity;
    }

    @Override
    public AdditionalInfoEntity getAdditionalInfoById(Long id) {
        AdditionalInfoEntity additionalInfoEntity = additionalInfoEntityRepository.findOne(id);
        if (additionalInfoEntity == null)
            throw new ResourceNotFoundException("AdditionalInfo with id = " + id + " was not found.");
        return additionalInfoEntity;
    }

    @Override
    public List<AdditionalInfoEntity> getAllAdditionalInfo() {
        return additionalInfoEntityRepository.findAll();
    }

    @Override
    public AdditionalInfoEntity updateAdditionalInfo(Long id, AdditionalInfoDTO additionalInfoDTO) {
        AdditionalInfoEntity additionalInfoEntity = additionalInfoMapper.asAdditionalInfoEntity(additionalInfoDTO);
        if (checkIfExists(id))
            additionalInfoEntity.setId(id);

        EmployeeEntity employeeById = findEmployeeById(additionalInfoDTO.getEmployeeId());
        additionalInfoEntity.setEmployeeEntity(employeeById);

        return additionalInfoEntityRepository.save(additionalInfoEntity);
    }

    @Override
    public void deleteAdditionalInfoById(Long id) {
        if (checkIfExists(id))
            additionalInfoEntityRepository.delete(id);
    }

    @Override
    public boolean checkIfExists(Long id) {
        if (!additionalInfoEntityRepository.exists(id))
            throw new ResourceNotFoundException("AdditionalInfo with id = " + id + " was not found.");
        return true;
    }
}
