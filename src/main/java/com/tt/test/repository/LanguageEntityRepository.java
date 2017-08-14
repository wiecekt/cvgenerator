package com.tt.test.repository;

import com.tt.test.domain.LanguageEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the LanguageEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LanguageEntityRepository extends JpaRepository<LanguageEntity,Long> {
    
}
