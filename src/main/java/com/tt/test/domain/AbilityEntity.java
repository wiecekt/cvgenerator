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
 * A AbilityEntity.
 */
@Entity
@Table(name = "ability_entity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbilityEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ability_type")
    private String abilityType;

    @Column(name = "ability_level")
    private String abilityLevel;

    @Column(name = "experience")
    private String experience;

    @Column(name = "ability_description")
    private String abilityDescription;

    @ManyToOne
    @JsonIgnore
    private EmployeeEntity employeeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbilityType() {
        return abilityType;
    }

    public AbilityEntity abilityType(String abilityType) {
        this.abilityType = abilityType;
        return this;
    }

    public void setAbilityType(String abilityType) {
        this.abilityType = abilityType;
    }

    public String getAbilityLevel() {
        return abilityLevel;
    }

    public AbilityEntity abilityLevel(String abilityLevel) {
        this.abilityLevel = abilityLevel;
        return this;
    }

    public void setAbilityLevel(String abilityLevel) {
        this.abilityLevel = abilityLevel;
    }

    public String getExperience() {
        return experience;
    }

    public AbilityEntity experience(String experience) {
        this.experience = experience;
        return this;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAbilityDescription() {
        return abilityDescription;
    }

    public AbilityEntity abilityDescription(String abilityDescription) {
        this.abilityDescription = abilityDescription;
        return this;
    }

    public void setAbilityDescription(String abilityDescription) {
        this.abilityDescription = abilityDescription;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public AbilityEntity employeeEntity(EmployeeEntity employeeEntity) {
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
        AbilityEntity abilityEntity = (AbilityEntity) o;
        if (abilityEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), abilityEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AbilityEntity{" +
            "id=" + getId() +
            ", abilityType='" + getAbilityType() + "'" +
            ", abilityLevel='" + getAbilityLevel() + "'" +
            ", experience='" + getExperience() + "'" +
            ", abilityDescription='" + getAbilityDescription() + "'" +
            "}";
    }
}
