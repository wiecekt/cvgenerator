package com.tt.test.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDate;

public class EducationDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate educationStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate educationEndDate;
    private Boolean isLearning;
    private String schoolName;
    private String subject;
    private String educationDescription;
    private Long employeeId;

    public LocalDate getEducationStartDate() {
        return educationStartDate;
    }

    public void setEducationStartDate(LocalDate educationStartDate) {
        this.educationStartDate = educationStartDate;
    }

    public LocalDate getEducationEndDate() {
        return educationEndDate;
    }

    public void setEducationEndDate(LocalDate educationEndDate) {
        this.educationEndDate = educationEndDate;
    }

    public Boolean getIsLearning() {
        return isLearning;
    }

    public void setIsLearning(Boolean learning) {
        isLearning = learning;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEducationDescription() {
        return educationDescription;
    }

    public void setEducationDescription(String educationDescription) {
        this.educationDescription = educationDescription;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
