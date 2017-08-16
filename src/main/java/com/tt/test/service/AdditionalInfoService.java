package com.tt.test.service;

import com.tt.test.domain.AbilityEntity;
import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.AbilityDTO;
import com.tt.test.service.dto.AdditionalInfoDTO;

import java.util.List;

public interface AdditionalInfoService {

    void create(AdditionalInfoEntity obj);
    void create(AdditionalInfoDTO additionalInfoDTO);
    EmployeeEntity findEmployeeById(Long id);
    AdditionalInfoEntity getAdditionalInfoById(Long id);
    List<AdditionalInfoEntity> getAllAdditionalInfos();
    void updateAdditionalInfo(Long id, AdditionalInfoDTO additionalInfoDTO);
    void deleteAdditionalInfoById(Long id);

}
