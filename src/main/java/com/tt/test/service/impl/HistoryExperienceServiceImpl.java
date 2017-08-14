package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.repository.HistoryExperienceEntityRepository;
import com.tt.test.service.HistoryExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
