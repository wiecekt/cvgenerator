package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.EducationEntity;
import com.tt.test.repository.EducationEntityRepository;
import com.tt.test.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
