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
 * A AdditionalInfoEntity.
 */
@Entity
@Table(name = "additional_info_entity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "additional_info_name")
    private String additionalInfoName;

    @Column(name = "additional_info_value")
    private String additionalInfoValue;

    @ManyToOne
    @JsonIgnore
    private EmployeeEntity employeeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdditionalInfoName() {
        return additionalInfoName;
    }

    public AdditionalInfoEntity additionalInfoName(String additionalInfoName) {
        this.additionalInfoName = additionalInfoName;
        return this;
    }

    public void setAdditionalInfoName(String additionalInfoName) {
        this.additionalInfoName = additionalInfoName;
    }

    public String getAdditionalInfoValue() {
        return additionalInfoValue;
    }

    public AdditionalInfoEntity additionalInfoValue(String additionalInfoValue) {
        this.additionalInfoValue = additionalInfoValue;
        return this;
    }

    public void setAdditionalInfoValue(String additionalInfoValue) {
        this.additionalInfoValue = additionalInfoValue;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public AdditionalInfoEntity employeeEntity(EmployeeEntity employeeEntity) {
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
        AdditionalInfoEntity additionalInfoEntity = (AdditionalInfoEntity) o;
        if (additionalInfoEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), additionalInfoEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AdditionalInfoEntity{" +
            "id=" + getId() +
            ", additionalInfoName='" + getAdditionalInfoName() + "'" +
            ", additionalInfoValue='" + getAdditionalInfoValue() + "'" +
            "}";
    }
}
