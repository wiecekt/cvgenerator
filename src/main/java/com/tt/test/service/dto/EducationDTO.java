package com.tt.test.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.joda.time.LocalDate;

import javax.persistence.Column;

@Data
public class EducationDTO {

    private LocalDate educationStartDate;
    private LocalDate educationEndDate;
    private Boolean isLearning;
    private String schoolName;
    private String subject;
    private String educationDescription;
    private Long employeeId;
}
