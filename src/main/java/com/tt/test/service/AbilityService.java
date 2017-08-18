package com.tt.test.service;

import com.tt.test.domain.AbilityEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.AbilityDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AbilityService {
    AbilityEntity create(AbilityEntity obj);
    AbilityEntity create(AbilityDTO abilityDTO);
    EmployeeEntity findEmployeeById(Long id);
    AbilityEntity getAbilityById(Long id);
    List<AbilityEntity> getAllAbilities();
    AbilityEntity updateAbility(Long id, AbilityDTO abilityDTO);
    void deleteAbilityById(Long id);
}
