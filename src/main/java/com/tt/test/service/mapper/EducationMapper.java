package com.tt.test.service.mapper;

import com.tt.test.domain.EducationEntity;
import com.tt.test.service.dto.EducationDTO;
import fr.xebia.extras.selma.Mapper;
import org.joda.time.LocalDate;

@Mapper(withImmutables = {LocalDate.class},
    withIgnoreFields = {
        "id",
        "employeeEntity",
        "employeeId"
})
public interface EducationMapper {

    EducationEntity asEducationEntity(EducationDTO in);
}
