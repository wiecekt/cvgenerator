package com.tt.test.service.impl;

import com.tt.test.domain.AbilityEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.AbilityEntityRepository;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.AbilityService;
import com.tt.test.service.dto.AbilityDTO;
import com.tt.test.service.mapper.AbilityMapper;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityServiceImpl implements AbilityService {

    private AbilityEntityRepository abilityEntityRepository;
    private EmployeeEntityRepository employeeEntityRepository;
    private AbilityMapper abilityMapper;

    @Autowired
    public AbilityServiceImpl(AbilityEntityRepository abilityEntityRepository, EmployeeEntityRepository employeeEntityRepository) {
        this.abilityEntityRepository = abilityEntityRepository;
        this.employeeEntityRepository = employeeEntityRepository;
    }

    @Override
    // na razie zostaw bo potrzebne do tworzenia w database init. Potem sie wywali
    public void create(AbilityEntity obj) {
        abilityEntityRepository.save(obj);
    }

    @Override
    public void create(AbilityDTO abilityDTO) {

        //sprawdz czy istnieje taki o podanym id
        EmployeeEntity employeeById = findEmployeeById(abilityDTO.getEmployeeId());
        abilityMapper = Selma.builder(AbilityMapper.class).build();
        AbilityEntity abilityEntity = abilityMapper.asAbilityEntity(abilityDTO);
        abilityEntity.setEmployeeEntity(employeeById);

        abilityEntityRepository.save(abilityEntity);

    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return employeeEntityRepository.findOne(id);
    }

    @Override
    public AbilityEntity getAbilityById(Long id) {
        return abilityEntityRepository.findOne(id);
    }

    @Override
    public List<AbilityEntity> getAllAbilities() {
        return abilityEntityRepository.findAll();
    }

    @Override
    public void updateAbility(Long id, AbilityDTO abilityDTO) {
        //sprawdz czy istnieje
        AbilityEntity abilityById = getAbilityById(id);
        abilityMapper = Selma.builder(AbilityMapper.class).build();
        AbilityEntity abilityEntity = abilityMapper.asAbilityEntity(abilityDTO);
        abilityEntity.setId(abilityById.getId());

        EmployeeEntity employeeById = findEmployeeById(abilityDTO.getEmployeeId());
        abilityEntity.setEmployeeEntity(employeeById);

        abilityEntityRepository.save(abilityEntity);
    }

    @Override
    public void deleteAbilityById(Long id) {
        abilityEntityRepository.delete(id);
    }
}
