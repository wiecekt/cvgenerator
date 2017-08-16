package com.tt.test.service.dto;

import com.tt.test.domain.enumeration.AccountType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserEntityDTO {

    private String username;
    private String password;
    private AccountType accountType;
    private Long employeeId;
}
