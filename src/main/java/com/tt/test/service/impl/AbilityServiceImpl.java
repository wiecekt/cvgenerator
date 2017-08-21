package com.tt.test.service.impl;

import com.tt.test.domain.AbilityEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.AbilityEntityRepository;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.AbilityService;
import com.tt.test.service.dto.AbilityDTO;
import com.tt.test.service.mapper.AbilityMapper;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
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
        this.abilityMapper = Selma.builder(AbilityMapper.class).build();
    }

    @Override
    public void create(AbilityEntity obj) {
        abilityEntityRepository.save(obj);
    }

    @Override
    public AbilityEntity create(AbilityDTO abilityDTO) {
        EmployeeEntity employeeById = findEmployeeById(abilityDTO.getEmployeeId());
        AbilityEntity abilityEntity = abilityMapper.asAbilityEntity(abilityDTO);
        abilityEntity.setEmployeeEntity(employeeById);

        return abilityEntityRepository.save(abilityEntity);

    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findOne(id);
        if (employeeEntity == null)
            throw new ResourceNotFoundException("Employee with id = " + id + " was not found.");
        return employeeEntity;
    }

    @Override
    public AbilityEntity getAbilityById(Long id) {
        AbilityEntity abilityEntity = abilityEntityRepository.findOne(id);
        if (abilityEntity == null)
            throw new ResourceNotFoundException("Ability with id = " + id + " was not found.");
        return abilityEntity;
    }

    @Override
    public List<AbilityEntity> getAllAbilities() {
        return abilityEntityRepository.findAll();
    }

    @Override
    public AbilityEntity updateAbility(Long id, AbilityDTO abilityDTO) {
        AbilityEntity abilityEntity = abilityMapper.asAbilityEntity(abilityDTO);
        if(checkIfExists(id))
            abilityEntity.setId(id);

        EmployeeEntity employeeById = findEmployeeById(abilityDTO.getEmployeeId());
        abilityEntity.setEmployeeEntity(employeeById);

        return abilityEntityRepository.save(abilityEntity);
    }

    @Override
    public void deleteAbilityById(Long id) {
        if(checkIfExists(id))
            abilityEntityRepository.delete(id);
    }

    @Override
    public boolean checkIfExists(Long id) {
        if (!abilityEntityRepository.exists(id))
            throw new ResourceNotFoundException("Ability with id = " + id + " was not found.");
        return true;
    }
}
