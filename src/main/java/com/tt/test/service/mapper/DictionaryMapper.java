package com.tt.test.service.mapper;

import com.tt.test.domain.DictionaryEntity;
import com.tt.test.service.dto.DictionaryDTO;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreFields = {
    "id"
})
public interface DictionaryMapper {

    DictionaryEntity asDictionaryEntity(DictionaryDTO in);
}
