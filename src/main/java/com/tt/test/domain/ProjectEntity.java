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
 * A ProjectEntity.
 */
@Entity
@Table(name = "project_entity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project")
    private String project;

    @Column(name = "client")
    private String client;

    @Column(name = "technology")
    private String technology;

    @Column(name = "duties")
    private String duties;

    @ManyToOne
    @JsonIgnore
    private EmployeeEntity employeeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public ProjectEntity project(String project) {
        this.project = project;
        return this;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getClient() {
        return client;
    }

    public ProjectEntity client(String client) {
        this.client = client;
        return this;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTechnology() {
        return technology;
    }

    public ProjectEntity technology(String technology) {
        this.technology = technology;
        return this;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getDuties() {
        return duties;
    }

    public ProjectEntity duties(String duties) {
        this.duties = duties;
        return this;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public ProjectEntity employeeEntity(EmployeeEntity employeeEntity) {
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
        ProjectEntity projectEntity = (ProjectEntity) o;
        if (projectEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
            "id=" + getId() +
            ", project='" + getProject() + "'" +
            ", client='" + getClient() + "'" +
            ", technology='" + getTechnology() + "'" +
            ", duties='" + getDuties() + "'" +
            "}";
    }
}
