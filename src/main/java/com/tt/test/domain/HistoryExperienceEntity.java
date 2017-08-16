package com.tt.test.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A HistoryExperienceEntity.
 */
@Entity
@Table(name = "history_experience_entity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistoryExperienceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "history_start_date")
    private LocalDate historyStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "history_end_date")
    private LocalDate historyEndDate;

    @Column(name = "is_working")
    private Boolean isWorking;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position")
    private String position;

    @Column(name = "history_description")
    private String historyDescription;

    @ManyToOne
    @JsonIgnore
    private EmployeeEntity employeeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getHistoryStartDate() {
        return historyStartDate;
    }

    public HistoryExperienceEntity historyStartDate(LocalDate historyStartDate) {
        this.historyStartDate = historyStartDate;
        return this;
    }

    public void setHistoryStartDate(LocalDate historyStartDate) {
        this.historyStartDate = historyStartDate;
    }

    public LocalDate getHistoryEndDate() {
        return historyEndDate;
    }

    public HistoryExperienceEntity historyEndDate(LocalDate historyEndDate) {
        this.historyEndDate = historyEndDate;
        return this;
    }

    public void setHistoryEndDate(LocalDate historyEndDate) {
        this.historyEndDate = historyEndDate;
    }

    public Boolean getIsWorking() {
        return isWorking;
    }

    public HistoryExperienceEntity isWorking(Boolean isWorking) {
        this.isWorking = isWorking;
        return this;
    }

    public void setIsWorking(Boolean isWorking) {
        this.isWorking = isWorking;
    }

    public String getCompanyName() {
        return companyName;
    }

    public HistoryExperienceEntity companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public HistoryExperienceEntity position(String position) {
        this.position = position;
        return this;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHistoryDescription() {
        return historyDescription;
    }

    public HistoryExperienceEntity historyDescription(String historyDescription) {
        this.historyDescription = historyDescription;
        return this;
    }

    public void setHistoryDescription(String historyDescription) {
        this.historyDescription = historyDescription;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public HistoryExperienceEntity employeeEntity(EmployeeEntity employeeEntity) {
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
        HistoryExperienceEntity historyExperienceEntity = (HistoryExperienceEntity) o;
        if (historyExperienceEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), historyExperienceEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HistoryExperienceEntity{" +
            "id=" + getId() +
            ", historyStartDate='" + getHistoryStartDate() + "'" +
            ", historyEndDate='" + getHistoryEndDate() + "'" +
            ", isWorking='" + getIsWorking() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", position='" + getPosition() + "'" +
            ", historyDescription='" + getHistoryDescription() + "'" +
            "}";
    }
}
