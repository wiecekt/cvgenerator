package com.tt.test.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.joda.time.LocalDate;

import javax.persistence.Column;

@Data
public class SmallEmployeeDTO {
    private String name;
    private String surname;
    private String department;
    private String division;
    private String address;
    private LocalDate dateOfBirth;
    private String email;
    private String telephone;
}
