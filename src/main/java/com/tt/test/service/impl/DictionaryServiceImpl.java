package com.tt.test.service.impl;

import com.tt.test.domain.DictionaryEntity;
import com.tt.test.repository.DictionaryEntityRepository;
import com.tt.test.service.DictionaryService;
import com.tt.test.service.dto.DictionaryDTO;
import com.tt.test.service.mapper.DictionaryMapper;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    private DictionaryEntityRepository dictionaryEntityRepository;
    private DictionaryMapper dictionaryMapper;

    @Autowired
    public DictionaryServiceImpl(DictionaryEntityRepository dictionaryEntityRepository) {
        this.dictionaryEntityRepository = dictionaryEntityRepository;
        this.dictionaryMapper = Selma.builder(DictionaryMapper.class).build();
    }

    @Override
    public void create(DictionaryEntity obj) {
        dictionaryEntityRepository.save(obj);
    }

    @Override
    public void create(DictionaryDTO dictionaryDTO) {
        DictionaryEntity dictionaryEntity = dictionaryMapper.asDictionaryEntity(dictionaryDTO);
        dictionaryEntityRepository.save(dictionaryEntity);
    }

    @Override
    public DictionaryEntity getDictionaryById(Long id) {
        return dictionaryEntityRepository.findOne(id);
    }

    @Override
    public List<DictionaryEntity> getDictionariesBySection(String section) {
        return dictionaryEntityRepository.findDictionariesBySection(section);
    }

    @Override
    public List<DictionaryEntity> getAllDictionaries() {
        return dictionaryEntityRepository.findAll();
    }

    @Override
    public void updateDictionary(Long id, DictionaryDTO dictionaryDTO) {
        DictionaryEntity dictionaryById = getDictionaryById(id);
        DictionaryEntity dictionaryEntity = dictionaryMapper.asDictionaryEntity(dictionaryDTO);
        dictionaryEntity.setId(dictionaryById.getId());

        dictionaryEntityRepository.save(dictionaryEntity);
    }

    @Override
    public void deleteDictionaryById(Long id) {
        dictionaryEntityRepository.delete(id);
    }
}
