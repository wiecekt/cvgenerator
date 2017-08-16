package com.tt.test.service;

import com.tt.test.domain.DictionaryEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.LanguageEntity;
import com.tt.test.service.dto.DictionaryDTO;
import com.tt.test.service.dto.LanguageDTO;

import java.util.List;

public interface DictionaryService {

    void create(DictionaryEntity obj);
    void create(DictionaryDTO dictionaryDTO);
    DictionaryEntity getDictionaryById(Long id);
    List<DictionaryEntity> getAllDictionaries();
    void updateDictionary(Long id, DictionaryDTO dictionaryDTO);
    void deleteDictionaryById(Long id);
}
