package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.LanguageEntity;
import com.tt.test.repository.LanguageEntityRepository;
import com.tt.test.service.LanguageService;
import com.tt.test.service.dto.LanguageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void create(LanguageDTO languageDTO) {

    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return null;
    }

    @Override
    public LanguageEntity getLangugageById(Long id) {
        return null;
    }

    @Override
    public List<LanguageEntity> getAllLangugages() {
        return null;
    }

    @Override
    public void updateLanguagage(Long id, LanguageDTO languageDTO) {

    }

    @Override
    public void deleteLanguageById(Long id) {

    }
}
