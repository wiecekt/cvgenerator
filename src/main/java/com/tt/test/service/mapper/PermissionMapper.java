package com.tt.test.service.mapper;

import com.tt.test.domain.PermissionEntity;
import com.tt.test.service.dto.EmployeeDTO;
import com.tt.test.service.dto.PermissionDTO;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreFields = {
    "id",
    "employeeEntity",
    "employeeId"
})

public interface PermissionMapper {

    PermissionEntity asPermissionEntity(PermissionDTO in);
}
