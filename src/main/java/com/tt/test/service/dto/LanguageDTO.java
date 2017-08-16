package com.tt.test.service.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class LanguageDTO {

    private String languageName;
    private String languageLevel;
    private String certificate;
    private Long employeeId;
}
