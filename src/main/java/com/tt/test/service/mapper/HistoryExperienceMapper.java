package com.tt.test.service.mapper;

import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.service.dto.EmployeeDTO;
import com.tt.test.service.dto.HistoryExperienceDTO;
import fr.xebia.extras.selma.Mapper;
import org.joda.time.LocalDate;

@Mapper(withImmutables = {LocalDate.class},
    withIgnoreFields = {
        "id",
        "employeeEntity",
        "employeeId"
    })

public interface HistoryExperienceMapper {

    HistoryExperienceEntity asHistoryExperienceEntity(HistoryExperienceDTO in);
}
