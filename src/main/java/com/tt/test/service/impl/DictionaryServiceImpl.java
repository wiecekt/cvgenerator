package com.tt.test.service.impl;

import com.tt.test.domain.DictionaryEntity;
import com.tt.test.repository.DictionaryEntityRepository;
import com.tt.test.service.DictionaryService;
import com.tt.test.service.dto.DictionaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    private DictionaryEntityRepository dictionaryEntityRepository;

    @Autowired
    public DictionaryServiceImpl(DictionaryEntityRepository dictionaryEntityRepository) {
        this.dictionaryEntityRepository = dictionaryEntityRepository;
    }

    @Override
    public void create(DictionaryEntity obj) {
        dictionaryEntityRepository.save(obj);
    }

    @Override
    public void create(DictionaryDTO dictionaryDTO) {

    }

    @Override
    public DictionaryEntity getDictionaryById(Long id) {
        return null;
    }

    @Override
    public List<DictionaryEntity> getAllDictionaries() {
        return null;
    }

    @Override
    public void updateDictionary(Long id, DictionaryDTO dictionaryDTO) {

    }

    @Override
    public void deleteDictionaryById(Long id) {

    }
}
