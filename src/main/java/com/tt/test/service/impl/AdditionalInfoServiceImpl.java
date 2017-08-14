package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.repository.AdditionalInfoEntityRepository;
import com.tt.test.service.AdditionalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
