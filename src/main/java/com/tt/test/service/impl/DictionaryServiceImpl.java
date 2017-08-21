package com.tt.test.service.impl;

import com.tt.test.domain.DictionaryEntity;
import com.tt.test.repository.DictionaryEntityRepository;
import com.tt.test.service.DictionaryService;
import com.tt.test.service.dto.DictionaryDTO;
import com.tt.test.service.mapper.DictionaryMapper;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
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
    public DictionaryEntity create(DictionaryDTO dictionaryDTO) {
        DictionaryEntity dictionaryEntity = dictionaryMapper.asDictionaryEntity(dictionaryDTO);
        return dictionaryEntityRepository.save(dictionaryEntity);
    }

    @Override
    public DictionaryEntity getDictionaryById(Long id) {
        DictionaryEntity dictionaryEntity = dictionaryEntityRepository.findOne(id);
        if (dictionaryEntity == null)
            throw new ResourceNotFoundException("Dictionary with id = " + id + " was not found.");
        return dictionaryEntity;
    }

    @Override
    public List<DictionaryEntity> getDictionariesBySection(String section) {
        /*List<DictionaryEntity> dictionariesBySection = dictionaryEntityRepository.findDictionariesBySection(section);
        if(dictionariesBySection.isEmpty())
            throw new ResourceNotFoundException("Dictionaries for section: " + section + " were not found.");
        return dictionariesBySection;*/
        return dictionaryEntityRepository.findDictionariesBySection(section);
    }

    @Override
    public List<DictionaryEntity> getAllDictionaries() {
        return dictionaryEntityRepository.findAll();
    }

    @Override
    public DictionaryEntity updateDictionary(Long id, DictionaryDTO dictionaryDTO) {
        DictionaryEntity dictionaryEntity = dictionaryMapper.asDictionaryEntity(dictionaryDTO);
        if(checkIfExists(id))
            dictionaryEntity.setId(id);

        return dictionaryEntityRepository.save(dictionaryEntity);
    }

    @Override
    public void deleteDictionaryById(Long id) {
        if (checkIfExists(id))
            dictionaryEntityRepository.delete(id);
    }

    @Override
    public boolean checkIfExists(Long id) {
        if (!dictionaryEntityRepository.exists(id))
            throw new ResourceNotFoundException("Dictionary with id = " + id + " was not found.");
        return true;
    }
}
