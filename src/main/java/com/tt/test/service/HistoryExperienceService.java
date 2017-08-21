package com.tt.test.service;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.service.dto.HistoryExperienceDTO;

import java.util.List;

public interface HistoryExperienceService {

    void create(HistoryExperienceEntity obj);
    HistoryExperienceEntity create(HistoryExperienceDTO historyExperienceDTO);
    EmployeeEntity findEmployeeById(Long id);
    HistoryExperienceEntity getHistoryExperienceById(Long id);
    List<HistoryExperienceEntity> getAllHistoryExperiences();
    HistoryExperienceEntity updateHistoryExperience(Long id, HistoryExperienceDTO historyExperienceDTO);
    void deleteHistoryExperienceById(Long id);
    boolean checkIfExists(Long id);
}
