package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.LanguageEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.repository.LanguageEntityRepository;
import com.tt.test.service.LanguageService;
import com.tt.test.service.dto.LanguageDTO;
import com.tt.test.service.mapper.LanguageMapper;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private LanguageEntityRepository languageEntityRepository;
    private EmployeeEntityRepository employeeEntityRepository;
    private LanguageMapper languageMapper;

    @Autowired
    public LanguageServiceImpl(LanguageEntityRepository languageEntityRepository, EmployeeEntityRepository employeeEntityRepository) {
        this.languageEntityRepository = languageEntityRepository;
        this.employeeEntityRepository = employeeEntityRepository;
        this.languageMapper = Selma.builder(LanguageMapper.class).build();
    }

    @Override
    public void create(LanguageEntity obj) {
        languageEntityRepository.save(obj);
    }

    @Override
    public LanguageEntity create(LanguageDTO languageDTO) {
        EmployeeEntity employeeById = findEmployeeById(languageDTO.getEmployeeId());
        LanguageEntity languageEntity = languageMapper.asLanguageEntity(languageDTO);
        languageEntity.setEmployeeEntity(employeeById);

        return languageEntityRepository.save(languageEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findOne(id);
        if (employeeEntity == null)
            throw new ResourceNotFoundException("Employee with id = " + id + " was not found.");
        return employeeEntity;
    }

    @Override
    public LanguageEntity getLanguageById(Long id) {
        LanguageEntity languageEntity = languageEntityRepository.findOne(id);
        if (languageEntity == null)
            throw new ResourceNotFoundException("Language with id = " + id + " was not found.");
        return languageEntity;
    }

    @Override
    public List<LanguageEntity> getAllLanguages() {
        return languageEntityRepository.findAll();
    }

    @Override
    public LanguageEntity updateLanguage(Long id, LanguageDTO languageDTO) {
        LanguageEntity languageEntity = languageMapper.asLanguageEntity(languageDTO);
        if (checkIfExists(id))
            languageEntity.setId(id);

        EmployeeEntity employeeById = findEmployeeById(languageDTO.getEmployeeId());
        languageEntity.setEmployeeEntity(employeeById);

        return languageEntityRepository.save(languageEntity);
    }

    @Override
    public void deleteLanguageById(Long id) {
        if (checkIfExists(id))
            languageEntityRepository.delete(id);
    }

    @Override
    public boolean checkIfExists(Long id) {
        if (!languageEntityRepository.exists(id))
            throw new ResourceNotFoundException("Language with id = " + id + " was not found.");
        return true;
    }
}
