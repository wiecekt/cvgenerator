package com.tt.test.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDate;

public class HistoryExperienceDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate historyStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate historyEndDate;
    private Boolean isWorking;
    private String companyName;
    private String position;
    private String historyDescription;
    private Long employeeId;

    public LocalDate getHistoryStartDate() {
        return historyStartDate;
    }

    public void setHistoryStartDate(LocalDate historyStartDate) {
        this.historyStartDate = historyStartDate;
    }

    public LocalDate getHistoryEndDate() {
        return historyEndDate;
    }

    public void setHistoryEndDate(LocalDate historyEndDate) {
        this.historyEndDate = historyEndDate;
    }

    public Boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(Boolean working) {
        isWorking = working;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHistoryDescription() {
        return historyDescription;
    }

    public void setHistoryDescription(String historyDescription) {
        this.historyDescription = historyDescription;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
