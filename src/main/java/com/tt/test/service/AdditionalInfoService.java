package com.tt.test.service;

import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.AdditionalInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdditionalInfoService {

    void create(AdditionalInfoEntity obj);
    AdditionalInfoEntity create(AdditionalInfoDTO additionalInfoDTO);
    EmployeeEntity findEmployeeById(Long id);
    AdditionalInfoEntity getAdditionalInfoById(Long id);
    List<AdditionalInfoEntity> getAllAdditionalInfo();
    AdditionalInfoEntity updateAdditionalInfo(Long id, AdditionalInfoDTO additionalInfoDTO);
    void deleteAdditionalInfoById(Long id);
    boolean checkIfExists(Long id);
}
