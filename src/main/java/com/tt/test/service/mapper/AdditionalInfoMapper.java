package com.tt.test.service.mapper;

import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.service.dto.AdditionalInfoDTO;
import com.tt.test.service.dto.EmployeeDTO;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreFields = {
    "id",
    "employeeEntity",
    "employeeId"
})

public interface AdditionalInfoMapper {

    AdditionalInfoEntity asAdditionalInfoEntity(AdditionalInfoDTO in);
}
