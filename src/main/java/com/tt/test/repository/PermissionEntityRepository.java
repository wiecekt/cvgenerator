package com.tt.test.repository;

import com.tt.test.domain.PermissionEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the PermissionEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PermissionEntityRepository extends JpaRepository<PermissionEntity,Long> {
    
}
