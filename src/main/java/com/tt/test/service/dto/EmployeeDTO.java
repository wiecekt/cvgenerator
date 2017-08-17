package com.tt.test.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tt.test.domain.*;
import org.joda.time.LocalDate;

import java.util.Set;

public class EmployeeDTO {

    private String name;
    private String surname;
    private String department;
    private String division;
    private String address;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
    private String email;
    private String telephone;

    private UserEntityDTO userEntityDTO;

    private Set<HistoryExperienceEntity> historyExperienceEntities;

    private Set<EducationEntity> educationEntities;

    private Set<AbilityEntity> abilityEntities;

    private Set<AdditionalInfoEntity> additionalInfoEntities;

    private Set<PermissionEntity> permissionEntities;

    private Set<ProjectEntity> projectEntities;

    private Set<LanguageEntity> languageEntities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public UserEntityDTO getUserEntityDTO() {
        return userEntityDTO;
    }

    public void setUserEntityDTO(UserEntityDTO userEntityDTO) {
        this.userEntityDTO = userEntityDTO;
    }

    public Set<HistoryExperienceEntity> getHistoryExperienceEntities() {
        return historyExperienceEntities;
    }

    public void setHistoryExperienceEntities(Set<HistoryExperienceEntity> historyExperienceEntities) {
        this.historyExperienceEntities = historyExperienceEntities;
    }

    public Set<EducationEntity> getEducationEntities() {
        return educationEntities;
    }

    public void setEducationEntities(Set<EducationEntity> educationEntities) {
        this.educationEntities = educationEntities;
    }

    public Set<AbilityEntity> getAbilityEntities() {
        return abilityEntities;
    }

    public void setAbilityEntities(Set<AbilityEntity> abilityEntities) {
        this.abilityEntities = abilityEntities;
    }

    public Set<AdditionalInfoEntity> getAdditionalInfoEntities() {
        return additionalInfoEntities;
    }

    public void setAdditionalInfoEntities(Set<AdditionalInfoEntity> additionalInfoEntities) {
        this.additionalInfoEntities = additionalInfoEntities;
    }

    public Set<PermissionEntity> getPermissionEntities() {
        return permissionEntities;
    }

    public void setPermissionEntities(Set<PermissionEntity> permissionEntities) {
        this.permissionEntities = permissionEntities;
    }

    public Set<ProjectEntity> getProjectEntities() {
        return projectEntities;
    }

    public void setProjectEntities(Set<ProjectEntity> projectEntities) {
        this.projectEntities = projectEntities;
    }

    public Set<LanguageEntity> getLanguageEntities() {
        return languageEntities;
    }

    public void setLanguageEntities(Set<LanguageEntity> languageEntities) {
        this.languageEntities = languageEntities;
    }
}
