package com.tt.test.service.dto;

import com.tt.test.domain.enumeration.SectionType;
import lombok.Data;

import javax.persistence.Column;

@Data
public class DictionaryDTO {
    private SectionType section;
    private String field;
    private String value;
}
