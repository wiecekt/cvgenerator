package com.tt.test.service.impl;

import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.AdditionalInfoEntityRepository;
import com.tt.test.service.AdditionalInfoService;
import com.tt.test.service.dto.AdditionalInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalInfoServiceImpl implements AdditionalInfoService {

    private AdditionalInfoEntityRepository additionalInfoEntityRepository;

    @Autowired
    public AdditionalInfoServiceImpl(AdditionalInfoEntityRepository additionalInfoEntityRepository) {
        this.additionalInfoEntityRepository = additionalInfoEntityRepository;
    }

    @Override
    public void create(AdditionalInfoEntity obj) {
        additionalInfoEntityRepository.save(obj);
    }

    @Override
    public void create(AdditionalInfoDTO additionalInfoDTO) {

    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return null;
    }

    @Override
    public AdditionalInfoEntity getAdditionalInfoById(Long id) {
        return null;
    }

    @Override
    public List<AdditionalInfoEntity> getAllAdditionalInfos() {
        return null;
    }

    @Override
    public void updateAdditionalInfo(Long id, AdditionalInfoDTO additionalInfoDTO) {

    }

    @Override
    public void deleteAdditionalInfoById(Long id) {

    }
}
