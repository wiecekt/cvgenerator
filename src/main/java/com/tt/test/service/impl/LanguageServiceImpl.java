package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.LanguageEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.repository.LanguageEntityRepository;
import com.tt.test.service.LanguageService;
import com.tt.test.service.dto.LanguageDTO;
import com.tt.test.service.mapper.LanguageMapper;
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
    public LanguageEntity create(LanguageEntity obj) {
        return languageEntityRepository.save(obj);
    }

    @Override
    public void create(LanguageDTO languageDTO) {
        //sprawdz czy istnieje
        EmployeeEntity employeeById = findEmployeeById(languageDTO.getEmployeeId());
        LanguageEntity languageEntity = languageMapper.asLanguageEntity(languageDTO);
        languageEntity.setEmployeeEntity(employeeById);

        languageEntityRepository.save(languageEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return employeeEntityRepository.findOne(id);
    }

    @Override
    public LanguageEntity getLanguageById(Long id) {
        return languageEntityRepository.findOne(id);
    }

    @Override
    public List<LanguageEntity> getAllLanguages() {
        return languageEntityRepository.findAll();
    }

    @Override
    public void updateLanguage(Long id, LanguageDTO languageDTO) {
        //sprawdz czy istnieje
        LanguageEntity languageById = getLanguageById(id);
        LanguageEntity languageEntity = languageMapper.asLanguageEntity(languageDTO);
        languageEntity.setId(languageById.getId());

        EmployeeEntity employeeById = findEmployeeById(languageDTO.getEmployeeId());
        languageEntity.setEmployeeEntity(employeeById);

        languageEntityRepository.save(languageEntity);
    }

    @Override
    public void deleteLanguageById(Long id) {
        languageEntityRepository.delete(id);
    }
}
