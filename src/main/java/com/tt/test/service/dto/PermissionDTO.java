package com.tt.test.service.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PermissionDTO {

    private String permissionsName;
    private String permissionsValue;
    private Long employeeId;
}
