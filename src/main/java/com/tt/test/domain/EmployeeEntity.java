package com.tt.test.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A EmployeeEntity.
 */
@Entity
@Table(name = "employee_entity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "department")
    private String department;

    @Column(name = "division")
    private String division;

    @Column(name = "address")
    private String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JsonIgnore
    @JoinColumn(unique = true)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<HistoryExperienceEntity> historyExperienceEntities;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<EducationEntity> educationEntities;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AbilityEntity> abilityEntities;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AdditionalInfoEntity> additionalInfoEntities;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PermissionEntity> permissionEntities;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProjectEntity> projectEntities;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<LanguageEntity> languageEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public EmployeeEntity name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public EmployeeEntity surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public EmployeeEntity department(String department) {
        this.department = department;
        return this;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public EmployeeEntity division(String division) {
        this.division = division;
        return this;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeEntity address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public EmployeeEntity dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeEntity email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public EmployeeEntity telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public EmployeeEntity userEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Set<HistoryExperienceEntity> getHistoryExperienceEntities() {
        return historyExperienceEntities;
    }

    public EmployeeEntity historyExperienceEntities(Set<HistoryExperienceEntity> historyExperienceEntities) {
        this.historyExperienceEntities = historyExperienceEntities;
        return this;
    }

    public EmployeeEntity addHistoryExperienceEntity(HistoryExperienceEntity historyExperienceEntity) {
        this.historyExperienceEntities.add(historyExperienceEntity);
        historyExperienceEntity.setEmployeeEntity(this);
        return this;
    }

    public EmployeeEntity removeHistoryExperienceEntity(HistoryExperienceEntity historyExperienceEntity) {
        this.historyExperienceEntities.remove(historyExperienceEntity);
        historyExperienceEntity.setEmployeeEntity(null);
        return this;
    }

    public void setHistoryExperienceEntities(Set<HistoryExperienceEntity> historyExperienceEntities) {
        this.historyExperienceEntities = historyExperienceEntities;
    }

    public Set<EducationEntity> getEducationEntities() {
        return educationEntities;
    }

    public EmployeeEntity educationEntities(Set<EducationEntity> educationEntities) {
        this.educationEntities = educationEntities;
        return this;
    }

    public EmployeeEntity addEducationEntity(EducationEntity educationEntity) {
        this.educationEntities.add(educationEntity);
        educationEntity.setEmployeeEntity(this);
        return this;
    }

    public EmployeeEntity removeEducationEntity(EducationEntity educationEntity) {
        this.educationEntities.remove(educationEntity);
        educationEntity.setEmployeeEntity(null);
        return this;
    }

    public void setEducationEntities(Set<EducationEntity> educationEntities) {
        this.educationEntities = educationEntities;
    }

    public Set<AbilityEntity> getAbilityEntities() {
        return abilityEntities;
    }

    public EmployeeEntity abilityEntities(Set<AbilityEntity> abilityEntities) {
        this.abilityEntities = abilityEntities;
        return this;
    }

    public EmployeeEntity addAbilityEntity(AbilityEntity abilityEntity) {
        this.abilityEntities.add(abilityEntity);
        abilityEntity.setEmployeeEntity(this);
        return this;
    }

    public EmployeeEntity removeAbilityEntity(AbilityEntity abilityEntity) {
        this.abilityEntities.remove(abilityEntity);
        abilityEntity.setEmployeeEntity(null);
        return this;
    }

    public void setAbilityEntities(Set<AbilityEntity> abilityEntities) {
        this.abilityEntities = abilityEntities;
    }

    public Set<AdditionalInfoEntity> getAdditionalInfoEntities() {
        return additionalInfoEntities;
    }

    public EmployeeEntity additionalInfoEntities(Set<AdditionalInfoEntity> additionalInfoEntities) {
        this.additionalInfoEntities = additionalInfoEntities;
        return this;
    }

    public EmployeeEntity addAdditionalInfoEntity(AdditionalInfoEntity additionalInfoEntity) {
        this.additionalInfoEntities.add(additionalInfoEntity);
        additionalInfoEntity.setEmployeeEntity(this);
        return this;
    }

    public EmployeeEntity removeAdditionalInfoEntity(AdditionalInfoEntity additionalInfoEntity) {
        this.additionalInfoEntities.remove(additionalInfoEntity);
        additionalInfoEntity.setEmployeeEntity(null);
        return this;
    }

    public void setAdditionalInfoEntities(Set<AdditionalInfoEntity> additionalInfoEntities) {
        this.additionalInfoEntities = additionalInfoEntities;
    }

    public Set<PermissionEntity> getPermissionEntities() {
        return permissionEntities;
    }

    public EmployeeEntity permissionEntities(Set<PermissionEntity> permissionEntities) {
        this.permissionEntities = permissionEntities;
        return this;
    }

    public EmployeeEntity addPermissionEntity(PermissionEntity permissionEntity) {
        this.permissionEntities.add(permissionEntity);
        permissionEntity.setEmployeeEntity(this);
        return this;
    }

    public EmployeeEntity removePermissionEntity(PermissionEntity permissionEntity) {
        this.permissionEntities.remove(permissionEntity);
        permissionEntity.setEmployeeEntity(null);
        return this;
    }

    public void setPermissionEntities(Set<PermissionEntity> permissionEntities) {
        this.permissionEntities = permissionEntities;
    }

    public Set<ProjectEntity> getProjectEntities() {
        return projectEntities;
    }

    public EmployeeEntity projectEntities(Set<ProjectEntity> projectEntities) {
        this.projectEntities = projectEntities;
        return this;
    }

    public EmployeeEntity addProjectEntity(ProjectEntity projectEntity) {
        this.projectEntities.add(projectEntity);
        projectEntity.setEmployeeEntity(this);
        return this;
    }

    public EmployeeEntity removeProjectEntity(ProjectEntity projectEntity) {
        this.projectEntities.remove(projectEntity);
        projectEntity.setEmployeeEntity(null);
        return this;
    }

    public void setProjectEntities(Set<ProjectEntity> projectEntities) {
        this.projectEntities = projectEntities;
    }

    public Set<LanguageEntity> getLanguageEntities() {
        return languageEntities;
    }

    public EmployeeEntity languageEntities(Set<LanguageEntity> languageEntities) {
        this.languageEntities = languageEntities;
        return this;
    }

    public EmployeeEntity addLanguageEntity(LanguageEntity languageEntity) {
        this.languageEntities.add(languageEntity);
        languageEntity.setEmployeeEntity(this);
        return this;
    }

    public EmployeeEntity removeLanguageEntity(LanguageEntity languageEntity) {
        this.languageEntities.remove(languageEntity);
        languageEntity.setEmployeeEntity(null);
        return this;
    }

    public void setLanguageEntities(Set<LanguageEntity> languageEntities) {
        this.languageEntities = languageEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmployeeEntity employeeEntity = (EmployeeEntity) o;
        if (employeeEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), employeeEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", department='" + department + '\'' +
            ", division='" + division + '\'' +
            ", address='" + address + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", email='" + email + '\'' +
            ", telephone='" + telephone + '\'' +
            '}';
    }
}
