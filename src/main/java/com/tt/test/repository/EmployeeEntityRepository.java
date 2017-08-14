package com.tt.test.repository;

import com.tt.test.domain.EmployeeEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the EmployeeEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity,Long> {
    
}
