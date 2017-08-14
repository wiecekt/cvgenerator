package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.ProjectEntity;
import com.tt.test.repository.ProjectEntityRepository;
import com.tt.test.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectEntityRepository projectEntityRepository;

    @Autowired
    public ProjectServiceImpl(ProjectEntityRepository projectEntityRepository) {
        this.projectEntityRepository = projectEntityRepository;
    }

    @Override
    public void create(ProjectEntity obj) {
        projectEntityRepository.save(obj);
    }
}
