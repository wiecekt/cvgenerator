package com.tt.test.service.impl;

import com.tt.test.domain.*;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.repository.UserEntityRepository;
import com.tt.test.service.EmployeeService;
import com.tt.test.service.dto.EmployeeDTO;
import com.tt.test.service.dto.SmallEmployeeDTO;
import com.tt.test.service.mapper.EmployeeMapper;
import fr.xebia.extras.selma.Selma;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeEntityRepository employeeEntityRepository;
    private UserEntityRepository userEntityRepository;
    private EmployeeMapper employeeMapper;

    @PersistenceContext
    EntityManager em;

    @Autowired
    public EmployeeServiceImpl(EmployeeEntityRepository employeeEntityRepository, UserEntityRepository userEntityRepository) {
        this.employeeEntityRepository = employeeEntityRepository;
        this.userEntityRepository = userEntityRepository;
        this.employeeMapper = Selma.builder(EmployeeMapper.class).build();
    }

    @Override
    public void create(EmployeeEntity obj) {
        employeeEntityRepository.save(obj);
    }

    @Override
    public void create(SmallEmployeeDTO smallEmployeeDTO) {
        //sprawdz czy istnieje
        UserEntity userById = findUserById(smallEmployeeDTO.getUserId());
        EmployeeEntity employeeEntity = employeeMapper.asEmployeeEntity(smallEmployeeDTO);
        employeeEntity.setUserEntity(userById);

        employeeEntityRepository.save(employeeEntity);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userEntityRepository.findOne(id);
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeEntityRepository.findOne(id);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeEntityRepository.findAll();
    }

    @Override
    public List<EmployeeEntity> searchEmployees(EmployeeDTO employeeDTO) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> query = builder.createQuery(EmployeeEntity.class);

        Root<EmployeeEntity> employees = query.from(EmployeeEntity.class);

        Join<EmployeeEntity, HistoryExperienceEntity> historyExperienceEntities = employees.join(EmployeeEntity_.historyExperienceEntities);
        Join<EmployeeEntity, EducationEntity> educationEntities = employees.join(EmployeeEntity_.educationEntities);
        Join<EmployeeEntity, AbilityEntity> abilityEntities = employees.join(EmployeeEntity_.abilityEntities);
        Join<EmployeeEntity, AdditionalInfoEntity> additionalInfoEntities = employees.join(EmployeeEntity_.additionalInfoEntities);
        Join<EmployeeEntity, PermissionEntity> permissionEntities = employees.join(EmployeeEntity_.permissionEntities);
        Join<EmployeeEntity, ProjectEntity> projectEntities = employees.join(EmployeeEntity_.projectEntities);
        //Join<EmployeeEntity, LanguageEntity> languageEntities = employees.join(EmployeeEntity_.languageEntities);

        List<Predicate> conditions = new ArrayList<>();

        //employee
        if(employeeDTO.getName() != null && StringUtils.isNotEmpty(employeeDTO.getName()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.name), employeeDTO.getName()));
        if (employeeDTO.getSurname() != null && StringUtils.isNotEmpty(employeeDTO.getSurname()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.surname), employeeDTO.getSurname()));
        if(employeeDTO.getDepartment() != null && StringUtils.isNotEmpty(employeeDTO.getDepartment()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.department), employeeDTO.getDepartment()));
        if(employeeDTO.getDivision() != null && StringUtils.isNotEmpty(employeeDTO.getDivision()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.division), employeeDTO.getDivision()));
        if(employeeDTO.getAddress() != null && StringUtils.isNotEmpty(employeeDTO.getAddress()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.address), employeeDTO.getAddress()));
        if(employeeDTO.getDateOfBirth() != null)
            conditions.add(builder.equal(employees.get(EmployeeEntity_.dateOfBirth), employeeDTO.getDateOfBirth()));
        if(employeeDTO.getEmail() != null && StringUtils.isNotEmpty(employeeDTO.getEmail()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.email), employeeDTO.getEmail()));
        if(employeeDTO.getTelephone() != null && StringUtils.isNotEmpty(employeeDTO.getTelephone()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.telephone), employeeDTO.getTelephone()));

        //historyExperience
        if(employeeDTO.getHistoryStartDate() != null)
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.historyStartDate), employeeDTO.getHistoryStartDate()));
        if(employeeDTO.getHistoryEndDate() != null)
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.historyEndDate), employeeDTO.getHistoryEndDate()));
        if(employeeDTO.getIsWorking() != null)
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.isWorking), employeeDTO.getIsWorking()));
        if(employeeDTO.getCompanyName() != null && StringUtils.isNotEmpty(employeeDTO.getCompanyName()))
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.companyName), employeeDTO.getCompanyName()));
        if(employeeDTO.getPosition() != null && StringUtils.isNotEmpty(employeeDTO.getPosition()))
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.position), employeeDTO.getPosition()));
        if(employeeDTO.getHistoryDescription() != null && StringUtils.isNotEmpty(employeeDTO.getHistoryDescription()))
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.historyDescription), employeeDTO.getHistoryDescription()));

        //education
        if(employeeDTO.getEducationStartDate() != null)
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.educationStartDate), employeeDTO.getEducationStartDate()));
        if(employeeDTO.getEducationEndDate() != null)
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.educationEndDate), employeeDTO.getEducationEndDate()));
        if(employeeDTO.getIsLearning() != null)
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.isLearning), employeeDTO.getIsLearning()));
        if(employeeDTO.getSchoolName() != null && StringUtils.isNotEmpty(employeeDTO.getSchoolName()))
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.schoolName), employeeDTO.getSchoolName()));
        if(employeeDTO.getSubject() != null && StringUtils.isNotEmpty(employeeDTO.getSubject()))
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.subject), employeeDTO.getSubject()));
        if(employeeDTO.getEducationDescription() != null && StringUtils.isNotEmpty(employeeDTO.getEducationDescription()))
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.educationDescription), employeeDTO.getEducationDescription()));

        //ability
        if(employeeDTO.getAbilityType() != null && StringUtils.isNotEmpty(employeeDTO.getAbilityType()))
            conditions.add(builder.equal(abilityEntities.get(AbilityEntity_.abilityType), employeeDTO.getAbilityType()));
        if(employeeDTO.getAbilityLevel() != null && StringUtils.isNotEmpty(employeeDTO.getAbilityLevel()))
            conditions.add(builder.equal(abilityEntities.get(AbilityEntity_.abilityLevel), employeeDTO.getAbilityLevel()));
        if(employeeDTO.getExperience() != null && StringUtils.isNotEmpty(employeeDTO.getExperience()))
            conditions.add(builder.equal(abilityEntities.get(AbilityEntity_.experience), employeeDTO.getExperience()));
        if(employeeDTO.getAbilityDescription() != null && StringUtils.isNotEmpty(employeeDTO.getAbilityDescription()))
            conditions.add(builder.equal(abilityEntities.get(AbilityEntity_.abilityDescription), employeeDTO.getAbilityDescription()));

        //additionalInfo
        if(employeeDTO.getAdditionalInfoName() != null && StringUtils.isNotEmpty(employeeDTO.getAdditionalInfoName()))
            conditions.add(builder.equal(additionalInfoEntities.get(AdditionalInfoEntity_.additionalInfoName), employeeDTO.getAdditionalInfoName()));
        if(employeeDTO.getAdditionalInfoValue() != null && StringUtils.isNotEmpty(employeeDTO.getAdditionalInfoValue()))
            conditions.add(builder.equal(additionalInfoEntities.get(AdditionalInfoEntity_.additionalInfoValue), employeeDTO.getAdditionalInfoValue()));

        //permission
        if(employeeDTO.getPermissionsName() != null && StringUtils.isNotEmpty(employeeDTO.getPermissionsName()))
            conditions.add(builder.equal(permissionEntities.get(PermissionEntity_.permissionsName), employeeDTO.getPermissionsName()));
        if(employeeDTO.getPermissionsValue() != null && StringUtils.isNotEmpty(employeeDTO.getPermissionsValue()))
            conditions.add(builder.equal(permissionEntities.get(PermissionEntity_.permissionsValue), employeeDTO.getPermissionsValue()));

        //project
        if(employeeDTO.getProject() != null && StringUtils.isNotEmpty(employeeDTO.getProject()))
            conditions.add(builder.equal(projectEntities.get(ProjectEntity_.project), employeeDTO.getProject()));
        if(employeeDTO.getClient() != null && StringUtils.isNotEmpty(employeeDTO.getClient()))
            conditions.add(builder.equal(projectEntities.get(ProjectEntity_.client), employeeDTO.getClient()));
        if(employeeDTO.getTechnology() != null && StringUtils.isNotEmpty(employeeDTO.getTechnology()))
            conditions.add(builder.equal(projectEntities.get(ProjectEntity_.technology), employeeDTO.getTechnology()));
        if(employeeDTO.getDuties() != null && StringUtils.isNotEmpty(employeeDTO.getDuties()))
            conditions.add(builder.equal(projectEntities.get(ProjectEntity_.duties), employeeDTO.getDuties()));


        TypedQuery<EmployeeEntity> typedQuery = em.createQuery(query
            .select(employees)
            .where(conditions.toArray(new Predicate[] {}))
            .distinct(true)
        );

        return typedQuery.getResultList();
    }

    @Override
    public void updateEmployee(Long id, SmallEmployeeDTO smallEmployeeDTO) {
        EmployeeEntity employeeById = getEmployeeById(id);
        EmployeeEntity employeeEntity = employeeMapper.asEmployeeEntity(smallEmployeeDTO);
        employeeEntity.setId(employeeById.getId());

        UserEntity userById = findUserById(smallEmployeeDTO.getUserId());
        employeeEntity.setUserEntity(userById);

        employeeEntityRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeEntityRepository.delete(id);
    }
}
