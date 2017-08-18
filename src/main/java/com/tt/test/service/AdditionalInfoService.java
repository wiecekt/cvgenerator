package com.tt.test.service;

import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.AdditionalInfoDTO;

import java.util.List;

public interface AdditionalInfoService {

    AdditionalInfoEntity create(AdditionalInfoEntity obj);
    AdditionalInfoEntity create(AdditionalInfoDTO additionalInfoDTO);
    EmployeeEntity findEmployeeById(Long id);
    AdditionalInfoEntity getAdditionalInfoById(Long id);
    List<AdditionalInfoEntity> getAllAdditionalInfo();
    AdditionalInfoEntity updateAdditionalInfo(Long id, AdditionalInfoDTO additionalInfoDTO);
    void deleteAdditionalInfoById(Long id);

}
