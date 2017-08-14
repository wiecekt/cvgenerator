package com.tt.test.repository;

import com.tt.test.domain.HistoryExperienceEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the HistoryExperienceEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HistoryExperienceEntityRepository extends JpaRepository<HistoryExperienceEntity,Long> {
    
}
