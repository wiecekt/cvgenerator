package com.tt.test.service.mapper;

import com.tt.test.domain.UserEntity;
import com.tt.test.service.dto.UserEntityDTO;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreFields = {
    "id",
    "employeeEntity",
    "employeeId"
})

public interface UserEntityMapper {
    UserEntity asUserEntity(UserEntityDTO in);
}
