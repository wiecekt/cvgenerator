package com.tt.test.service.mapper;

import com.tt.test.domain.ProjectEntity;
import com.tt.test.service.dto.ProjectDTO;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreFields = {
    "id",
    "employeeEntity",
    "employeeId"
})

public interface ProjectMapper {

    ProjectEntity asProjectEntity(ProjectDTO in);
}
