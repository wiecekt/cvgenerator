package com.tt.test.service.impl;

import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.AdditionalInfoEntityRepository;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.AdditionalInfoService;
import com.tt.test.service.dto.AdditionalInfoDTO;
import com.tt.test.service.mapper.AdditionalInfoMapper;
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
    public AdditionalInfoEntity create(AdditionalInfoEntity obj) {
        return additionalInfoEntityRepository.save(obj);
    }

    @Override
    public AdditionalInfoEntity create(AdditionalInfoDTO additionalInfoDTO) {
        //sprawdz czy istnieje
        EmployeeEntity employeeById = findEmployeeById(additionalInfoDTO.getEmployeeId());
        AdditionalInfoEntity additionalInfoEntity = additionalInfoMapper.asAdditionalInfoEntity(additionalInfoDTO);
        additionalInfoEntity.setEmployeeEntity(employeeById);

        return additionalInfoEntityRepository.save(additionalInfoEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return employeeEntityRepository.findOne(id);
    }

    @Override
    public AdditionalInfoEntity getAdditionalInfoById(Long id) {
        return additionalInfoEntityRepository.findOne(id);
    }

    @Override
    public List<AdditionalInfoEntity> getAllAdditionalInfo() {
        return additionalInfoEntityRepository.findAll();
    }

    @Override
    public AdditionalInfoEntity updateAdditionalInfo(Long id, AdditionalInfoDTO additionalInfoDTO) {
        AdditionalInfoEntity additionalInfoById = getAdditionalInfoById(id);
        AdditionalInfoEntity additionalInfoEntity = additionalInfoMapper.asAdditionalInfoEntity(additionalInfoDTO);
        additionalInfoEntity.setId(additionalInfoById.getId());

        EmployeeEntity employeeById = findEmployeeById(additionalInfoDTO.getEmployeeId());
        additionalInfoEntity.setEmployeeEntity(employeeById);

        return additionalInfoEntityRepository.save(additionalInfoEntity);
    }

    @Override
    public void deleteAdditionalInfoById(Long id) {
        additionalInfoEntityRepository.delete(id);
    }
}
