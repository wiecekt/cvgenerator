package com.tt.test.service;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.domain.LanguageEntity;
import com.tt.test.service.dto.HistoryExperienceDTO;
import com.tt.test.service.dto.LanguageDTO;

import java.util.List;

public interface LanguageService {

    void create(LanguageEntity obj);
    void create(LanguageDTO languageDTO);
    EmployeeEntity findEmployeeById(Long id);
    LanguageEntity getLangugageById(Long id);
    List<LanguageEntity> getAllLangugages();
    void updateLanguagage(Long id, LanguageDTO languageDTO);
    void deleteLanguageById(Long id);

}
