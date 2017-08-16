package com.tt.test.service;

import com.tt.test.domain.EducationEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.service.dto.EducationDTO;
import com.tt.test.service.dto.HistoryExperienceDTO;

import java.util.List;

public interface HistoryExperienceService {

    void create(HistoryExperienceEntity obj);
    void create(HistoryExperienceDTO historyExperienceDTO);
    EmployeeEntity findEmployeeById(Long id);
    HistoryExperienceEntity getHistoryExperienceById(Long id);
    List<HistoryExperienceEntity> getAllHistoryExperiences();
    void updateHistoryExperience(Long id, HistoryExperienceDTO historyExperienceDTO);
    void deleteHistoryExperienceById(Long id);
}
