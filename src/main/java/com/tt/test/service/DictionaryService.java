package com.tt.test.service;

import com.tt.test.domain.DictionaryEntity;
import com.tt.test.service.dto.DictionaryDTO;

import java.util.List;

public interface DictionaryService {

    void create(DictionaryEntity obj);
    DictionaryEntity create(DictionaryDTO dictionaryDTO);
    DictionaryEntity getDictionaryById(Long id);
    List<DictionaryEntity> getDictionariesBySection(String section);
    List<DictionaryEntity> getAllDictionaries();
    DictionaryEntity updateDictionary(Long id, DictionaryDTO dictionaryDTO);
    void deleteDictionaryById(Long id);
}
