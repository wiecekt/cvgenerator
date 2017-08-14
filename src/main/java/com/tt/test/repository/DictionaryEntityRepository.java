package com.tt.test.repository;

import com.tt.test.domain.DictionaryEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import java.util.List;


/**
 * Spring Data JPA repository for the DictionaryEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DictionaryEntityRepository extends JpaRepository<DictionaryEntity,Long> {

    List<DictionaryEntity> findDictionariesBySection(String section);

}
