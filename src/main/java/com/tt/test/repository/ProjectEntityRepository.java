package com.tt.test.repository;

import com.tt.test.domain.ProjectEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the ProjectEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProjectEntityRepository extends JpaRepository<ProjectEntity,Long> {
    
}
