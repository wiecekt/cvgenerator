package com.tt.test.service.mapper;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.BasicEmployeeDTO;
import com.tt.test.service.dto.EmployeeDTO;
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
        "languageEntities",
        "userId",
        "userEntityDTO"
    })

public interface BasicEmployeeMapper {

    EmployeeEntity asEmployeeEntity(BasicEmployeeDTO in);
    EmployeeEntity asEmployeeEntity(EmployeeDTO in);
}
