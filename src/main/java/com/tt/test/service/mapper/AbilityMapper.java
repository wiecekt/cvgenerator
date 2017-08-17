package com.tt.test.service.mapper;

import com.tt.test.domain.AbilityEntity;
import com.tt.test.service.dto.AbilityDTO;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreFields = {
    "id",
    "employeeEntity",
    "employeeId"
})

public interface AbilityMapper {

    AbilityEntity asAbilityEntity(AbilityDTO in);

}
