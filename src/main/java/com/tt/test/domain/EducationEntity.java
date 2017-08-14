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
 * A EducationEntity.
 */
@Entity
@Table(name = "education_entity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EducationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "education_start_date")
    private LocalDate educationStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "education_end_date")
    private LocalDate educationEndDate;

    @Column(name = "is_learning")
    private Boolean isLearning;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "subject")
    private String subject;

    @Column(name = "education_description")
    private String educationDescription;

    @ManyToOne
    @JsonIgnore
    private EmployeeEntity employeeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEducationStartDate() {
        return educationStartDate;
    }

    public EducationEntity educationStartDate(LocalDate educationStartDate) {
        this.educationStartDate = educationStartDate;
        return this;
    }

    public void setEducationStartDate(LocalDate educationStartDate) {
        this.educationStartDate = educationStartDate;
    }

    public LocalDate getEducationEndDate() {
        return educationEndDate;
    }

    public EducationEntity educationEndDate(LocalDate educationEndDate) {
        this.educationEndDate = educationEndDate;
        return this;
    }

    public void setEducationEndDate(LocalDate educationEndDate) {
        this.educationEndDate = educationEndDate;
    }

    public Boolean getIsLearning() {
        return isLearning;
    }

    public EducationEntity isLearning(Boolean isLearning) {
        this.isLearning = isLearning;
        return this;
    }

    public void setIsLearning(Boolean isLearning) {
        this.isLearning = isLearning;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public EducationEntity schoolName(String schoolName) {
        this.schoolName = schoolName;
        return this;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSubject() {
        return subject;
    }

    public EducationEntity subject(String subject) {
        this.subject = subject;
        return this;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEducationDescription() {
        return educationDescription;
    }

    public EducationEntity educationDescription(String educationDescription) {
        this.educationDescription = educationDescription;
        return this;
    }

    public void setEducationDescription(String educationDescription) {
        this.educationDescription = educationDescription;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public EducationEntity employeeEntity(EmployeeEntity employeeEntity) {
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
        EducationEntity educationEntity = (EducationEntity) o;
        if (educationEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), educationEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EducationEntity{" +
            "id=" + getId() +
            ", educationStartDate='" + getEducationStartDate() + "'" +
            ", educationEndDate='" + getEducationEndDate() + "'" +
            ", isLearning='" + getIsLearning() + "'" +
            ", schoolName='" + getSchoolName() + "'" +
            ", subject='" + getSubject() + "'" +
            ", educationDescription='" + getEducationDescription() + "'" +
            "}";
    }
}
