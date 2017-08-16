package com.tt.test.service.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.joda.time.LocalDate;

//import java.sql.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate historyStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate historyEndDate;
    private Boolean isWorking;
    private String companyName;
    private String position;
    private String historyDescription;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate educationStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate educationEndDate;
    private Boolean isLearning;
    private String schoolName;
    private String subject;
    private String educationDescription;
    //-- ability entity
    private String abilityType;
    private String abilityLevel;
    private String experience;
    private String abilityDescription;
    // ---
    private String additionalInfoName;
    private String additionalInfoValue;
    private String permissionsName;
    private String permissionsValue;
    private String project;
    private String client;
    private String technology;
    private String duties;

}

