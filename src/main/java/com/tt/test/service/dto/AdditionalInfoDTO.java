package com.tt.test.service.dto;

public class AdditionalInfoDTO {

    private String additionalInfoName;
    private String additionalInfoValue;
    private Long employeeId;

    public String getAdditionalInfoName() {
        return additionalInfoName;
    }

    public void setAdditionalInfoName(String additionalInfoName) {
        this.additionalInfoName = additionalInfoName;
    }

    public String getAdditionalInfoValue() {
        return additionalInfoValue;
    }

    public void setAdditionalInfoValue(String additionalInfoValue) {
        this.additionalInfoValue = additionalInfoValue;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
