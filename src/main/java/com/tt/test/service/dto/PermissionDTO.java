package com.tt.test.service.dto;

public class PermissionDTO {

    private String permissionsName;
    private String permissionsValue;
    private Long employeeId;

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    public String getPermissionsValue() {
        return permissionsValue;
    }

    public void setPermissionsValue(String permissionsValue) {
        this.permissionsValue = permissionsValue;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
