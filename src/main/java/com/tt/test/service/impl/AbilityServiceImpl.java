package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.AbilityEntity;
import com.tt.test.repository.AbilityEntityRepository;
import com.tt.test.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilityServiceImpl implements AbilityService {

    private AbilityEntityRepository abilityEntityRepository;

    @Autowired
    public AbilityServiceImpl(AbilityEntityRepository abilityEntityRepository) {
        this.abilityEntityRepository = abilityEntityRepository;
    }

    @Override
    public void create(AbilityEntity obj) {
        abilityEntityRepository.save(obj);
    }
}
