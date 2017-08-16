package com.tt.test.service.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AdditionalInfoDTO {

    private String additionalInfoName;
    private String additionalInfoValue;
    private Long employeeId;
}
