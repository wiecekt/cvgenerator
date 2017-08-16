package com.tt.test.service.mapper;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.EmployeeDTO;
import com.tt.test.service.dto.SmallEmployeeDTO;
import fr.xebia.extras.selma.Mapper;
import org.joda.time.LocalDate;

@Mapper(withImmutables = {LocalDate.class},
    withIgnoreFields = {
        "id",
        "userEntity",
        "historyExperienceEntities",
        "educationEntities",
        "abilityEntities",
        "additionalInfoEntities",
        "permissionEntities",
        "projectEntities",
        "languageEntities"
    })

public interface EmployeeMapper {

    EmployeeEntity asEmployeeEntity(SmallEmployeeDTO in);
}
