package com.tt.test.service.mapper;

import com.tt.test.domain.LanguageEntity;
import com.tt.test.service.dto.LanguageDTO;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreFields = {
    "id",
    "employeeEntity",
    "employeeId"
})
public interface LanguageMapper {
    LanguageEntity asLanguageEntity(LanguageDTO in);
}
