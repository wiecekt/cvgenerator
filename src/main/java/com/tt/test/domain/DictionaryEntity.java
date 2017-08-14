package com.tt.test.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tt.test.domain.enumeration.SectionType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DictionaryEntity.
 */
@Entity
@Table(name = "dictionary_entity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DictionaryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "section")
    private SectionType section;

    @Column(name = "field")
    private String field;

    @Column(name = "jhi_value")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SectionType getSection() {
        return section;
    }

    public DictionaryEntity section(SectionType section) {
        this.section = section;
        return this;
    }

    public void setSection(SectionType section) {
        this.section = section;
    }

    public String getField() {
        return field;
    }

    public DictionaryEntity field(String field) {
        this.field = field;
        return this;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public DictionaryEntity value(String value) {
        this.value = value;
        return this;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DictionaryEntity dictionaryEntity = (DictionaryEntity) o;
        if (dictionaryEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dictionaryEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DictionaryEntity{" +
            "id=" + getId() +
            ", section='" + getSection() + "'" +
            ", field='" + getField() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
}
