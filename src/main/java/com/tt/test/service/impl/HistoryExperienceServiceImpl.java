package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.repository.HistoryExperienceEntityRepository;
import com.tt.test.service.HistoryExperienceService;
import com.tt.test.service.dto.HistoryExperienceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryExperienceServiceImpl implements HistoryExperienceService {

    private HistoryExperienceEntityRepository historyExperienceEntityRepository;

    @Autowired
    public HistoryExperienceServiceImpl(HistoryExperienceEntityRepository historyExperienceEntityRepository) {
        this.historyExperienceEntityRepository = historyExperienceEntityRepository;
    }

    @Override
    public void create(HistoryExperienceEntity obj) {
        historyExperienceEntityRepository.save(obj);
    }

    @Override
    public void create(HistoryExperienceDTO historyExperienceDTO) {

    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return null;
    }

    @Override
    public HistoryExperienceEntity getHistoryExperienceById(Long id) {
        return null;
    }

    @Override
    public List<HistoryExperienceEntity> getAllHistoryExperiences() {
        return null;
    }

    @Override
    public void updateHistoryExperience(Long id, HistoryExperienceDTO historyExperienceDTO) {

    }

    @Override
    public void deleteHistoryExperienceById(Long id) {

    }
}
