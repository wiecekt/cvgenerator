package com.tt.test.service;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.LanguageEntity;
import com.tt.test.service.dto.LanguageDTO;

import java.util.List;

public interface LanguageService {

    void create(LanguageEntity obj);
    void create(LanguageDTO languageDTO);
    EmployeeEntity findEmployeeById(Long id);
    LanguageEntity getLanguageById(Long id);
    List<LanguageEntity> getAllLanguages();
    void updateLanguage(Long id, LanguageDTO languageDTO);
    void deleteLanguageById(Long id);

}
