package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.LanguageEntity;
import com.tt.test.repository.LanguageEntityRepository;
import com.tt.test.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    private LanguageEntityRepository languageEntityRepository;

    @Autowired
    public LanguageServiceImpl(LanguageEntityRepository languageEntityRepository) {
        this.languageEntityRepository = languageEntityRepository;
    }

    @Override
    public void create(LanguageEntity obj) {
        languageEntityRepository.save(obj);
    }
}
