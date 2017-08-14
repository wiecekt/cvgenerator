package com.tt.test.repository;

import com.tt.test.domain.EducationEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the EducationEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EducationEntityRepository extends JpaRepository<EducationEntity,Long> {
    
}
