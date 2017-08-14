package com.tt.test.repository;

import com.tt.test.domain.AdditionalInfoEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AdditionalInfoEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AdditionalInfoEntityRepository extends JpaRepository<AdditionalInfoEntity,Long> {
    
}
