package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.repository.HistoryExperienceEntityRepository;
import com.tt.test.service.HistoryExperienceService;
import com.tt.test.service.dto.HistoryExperienceDTO;
import com.tt.test.service.mapper.HistoryExperienceMapper;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryExperienceServiceImpl implements HistoryExperienceService {

    private HistoryExperienceEntityRepository historyExperienceEntityRepository;
    private EmployeeEntityRepository employeeEntityRepository;
    private HistoryExperienceMapper historyExperienceMapper;

    @Autowired
    public HistoryExperienceServiceImpl(HistoryExperienceEntityRepository historyExperienceEntityRepository, EmployeeEntityRepository employeeEntityRepository) {
        this.historyExperienceEntityRepository = historyExperienceEntityRepository;
        this.employeeEntityRepository = employeeEntityRepository;
        this.historyExperienceMapper = Selma.builder(HistoryExperienceMapper.class).build();
    }

    @Override
    public void create(HistoryExperienceEntity obj) {
        historyExperienceEntityRepository.save(obj);
    }

    @Override
    public HistoryExperienceEntity create(HistoryExperienceDTO historyExperienceDTO) {
        //sprawdz czy istnieje taki o podanym id
        EmployeeEntity employeeById = findEmployeeById(historyExperienceDTO.getEmployeeId());
        HistoryExperienceEntity historyExperienceEntity = historyExperienceMapper.asHistoryExperienceEntity(historyExperienceDTO);
        historyExperienceEntity.setEmployeeEntity(employeeById);

        return historyExperienceEntityRepository.save(historyExperienceEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return employeeEntityRepository.findOne(id);
    }

    @Override
    public HistoryExperienceEntity getHistoryExperienceById(Long id) {
        return historyExperienceEntityRepository.findOne(id);
    }

    @Override
    public List<HistoryExperienceEntity> getAllHistoryExperiences() {
        return historyExperienceEntityRepository.findAll();
    }

    @Override
    public HistoryExperienceEntity updateHistoryExperience(Long id, HistoryExperienceDTO historyExperienceDTO) {
        HistoryExperienceEntity historyExperienceById = getHistoryExperienceById(id);
        HistoryExperienceEntity historyExperienceEntity = historyExperienceMapper.asHistoryExperienceEntity(historyExperienceDTO);
        historyExperienceEntity.setId(historyExperienceById.getId());

        EmployeeEntity employeeById = findEmployeeById(historyExperienceDTO.getEmployeeId());
        historyExperienceEntity.setEmployeeEntity(employeeById);

        return historyExperienceEntityRepository.save(historyExperienceEntity);
    }

    @Override
    public void deleteHistoryExperienceById(Long id) {
        historyExperienceEntityRepository.delete(id);
    }
}
