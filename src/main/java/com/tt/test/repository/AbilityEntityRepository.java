package com.tt.test.repository;

import com.tt.test.domain.AbilityEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AbilityEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AbilityEntityRepository extends JpaRepository<AbilityEntity,Long> {
    
}
