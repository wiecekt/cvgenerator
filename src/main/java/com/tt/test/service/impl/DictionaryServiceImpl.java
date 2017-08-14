package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.DictionaryEntity;
import com.tt.test.repository.DictionaryEntityRepository;
import com.tt.test.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
