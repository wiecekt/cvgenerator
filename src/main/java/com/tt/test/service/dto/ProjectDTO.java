package com.tt.test.service.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ProjectDTO {

    private String project;
    private String client;
    private String technology;
    private String duties;
    private Long employeeId;
}
