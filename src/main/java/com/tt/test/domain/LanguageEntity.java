package com.tt.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A LanguageEntity.
 */
@Entity
@Table(name = "language_entity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LanguageEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_level")
    private String languageLevel;

    @Column(name = "certificate")
    private String certificate;

    @ManyToOne
    @JsonIgnore
    private EmployeeEntity employeeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public LanguageEntity languageName(String languageName) {
        this.languageName = languageName;
        return this;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageLevel() {
        return languageLevel;
    }

    public LanguageEntity languageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
        return this;
    }

    public void setLanguageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
    }

    public String getCertificate() {
        return certificate;
    }

    public LanguageEntity certificate(String certificate) {
        this.certificate = certificate;
        return this;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public LanguageEntity employeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
        return this;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LanguageEntity languageEntity = (LanguageEntity) o;
        if (languageEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), languageEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "LanguageEntity{" +
            "id=" + getId() +
            ", languageName='" + getLanguageName() + "'" +
            ", languageLevel='" + getLanguageLevel() + "'" +
            ", certificate='" + getCertificate() + "'" +
            "}";
    }
}
