package com.tt.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A PermissionEntity.
 */
@Entity
@Table(name = "permission_entity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permissions_name")
    private String permissionsName;

    @Column(name = "permissions_value")
    private String permissionsValue;

    @ManyToOne
    @JsonIgnore
    private EmployeeEntity employeeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public PermissionEntity permissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
        return this;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    public String getPermissionsValue() {
        return permissionsValue;
    }

    public PermissionEntity permissionsValue(String permissionsValue) {
        this.permissionsValue = permissionsValue;
        return this;
    }

    public void setPermissionsValue(String permissionsValue) {
        this.permissionsValue = permissionsValue;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public PermissionEntity employeeEntity(EmployeeEntity employeeEntity) {
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
        PermissionEntity permissionEntity = (PermissionEntity) o;
        if (permissionEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), permissionEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PermissionEntity{" +
            "id=" + getId() +
            ", permissionsName='" + getPermissionsName() + "'" +
            ", permissionsValue='" + getPermissionsValue() + "'" +
            "}";
    }
}
