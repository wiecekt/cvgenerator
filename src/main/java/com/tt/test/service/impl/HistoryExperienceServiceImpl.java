package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.repository.HistoryExperienceEntityRepository;
import com.tt.test.service.HistoryExperienceService;
import com.tt.test.service.dto.HistoryExperienceDTO;
import com.tt.test.service.mapper.HistoryExperienceMapper;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
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
        EmployeeEntity employeeById = findEmployeeById(historyExperienceDTO.getEmployeeId());
        HistoryExperienceEntity historyExperienceEntity = historyExperienceMapper.asHistoryExperienceEntity(historyExperienceDTO);
        historyExperienceEntity.setEmployeeEntity(employeeById);

        return historyExperienceEntityRepository.save(historyExperienceEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findOne(id);
        if (employeeEntity == null)
            throw new ResourceNotFoundException("Employee with id = " + id + " was not found.");
        return employeeEntity;
    }

    @Override
    public HistoryExperienceEntity getHistoryExperienceById(Long id) {
        HistoryExperienceEntity historyExperienceEntity = historyExperienceEntityRepository.findOne(id);
        if (historyExperienceEntity == null)
            throw new ResourceNotFoundException("HistoryExperience with id = " + id + " was not found.");
        return historyExperienceEntity;
    }

    @Override
    public List<HistoryExperienceEntity> getAllHistoryExperiences() {
        return historyExperienceEntityRepository.findAll();
    }

    @Override
    public HistoryExperienceEntity updateHistoryExperience(Long id, HistoryExperienceDTO historyExperienceDTO) {
        HistoryExperienceEntity historyExperienceEntity = historyExperienceMapper.asHistoryExperienceEntity(historyExperienceDTO);
        if (checkIfExists(id))
            historyExperienceEntity.setId(id);

        EmployeeEntity employeeById = findEmployeeById(historyExperienceDTO.getEmployeeId());
        historyExperienceEntity.setEmployeeEntity(employeeById);

        return historyExperienceEntityRepository.save(historyExperienceEntity);
    }

    @Override
    public void deleteHistoryExperienceById(Long id) {
        if(checkIfExists(id))
            historyExperienceEntityRepository.delete(id);
    }

    @Override
    public boolean checkIfExists(Long id) {
        if (!historyExperienceEntityRepository.exists(id))
            throw new ResourceNotFoundException("HistoryExperience with id = " + id + " was not found.");
        return true;
    }
}
