package com.tt.test.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.joda.time.LocalDate;

import javax.persistence.Column;

@Data
public class HistoryExperienceDTO {
    private LocalDate historyStartDate;
    private LocalDate historyEndDate;
    private Boolean isWorking;
    private String companyName;
    private String position;
    private String historyDescription;
    private Long employeeId;
}
