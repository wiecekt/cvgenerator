package com.tt.test.service.dto;

import com.tt.test.domain.enumeration.SectionType;

public class DictionaryDTO {
    private SectionType section;
    private String field;
    private String value;

    public SectionType getSection() {
        return section;
    }

    public void setSection(SectionType section) {
        this.section = section;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
