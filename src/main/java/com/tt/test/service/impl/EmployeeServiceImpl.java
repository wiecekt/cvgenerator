package com.tt.test.service.impl;

import com.tt.test.domain.*;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.*;
import com.tt.test.service.dto.BasicEmployeeDTO;
import com.tt.test.service.dto.EmployeeDTO;
import com.tt.test.service.dto.SearchEmployeeDTO;
import com.tt.test.service.mapper.BasicEmployeeMapper;
import com.tt.test.service.mapper.UserEntityMapper;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
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
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeEntityRepository employeeEntityRepository;

    private UserEntityService userEntityService;
    private HistoryExperienceService historyExperienceService;
    private EducationService educationService;
    private AbilityService abilityService;
    private AdditionalInfoService additionalInfoService;
    private PermissionService permissionService;
    private ProjectService projectService;
    private LanguageService languageService;

    private BasicEmployeeMapper basicEmployeeMapper;
    private UserEntityMapper userEntityMapper;

    @PersistenceContext
    EntityManager em;

    @Autowired
    public EmployeeServiceImpl(EmployeeEntityRepository employeeEntityRepository, UserEntityService userEntityService,
                               HistoryExperienceService historyExperienceService, EducationService educationService,
                               AbilityService abilityService, AdditionalInfoService additionalInfoService,
                               PermissionService permissionService, ProjectService projectService,
                               LanguageService languageService) {
        this.employeeEntityRepository = employeeEntityRepository;
        this.userEntityService = userEntityService;
        this.historyExperienceService = historyExperienceService;
        this.educationService = educationService;
        this.abilityService = abilityService;
        this.additionalInfoService = additionalInfoService;
        this.permissionService = permissionService;
        this.projectService = projectService;
        this.languageService = languageService;
        this.basicEmployeeMapper = Selma.builder(BasicEmployeeMapper.class).build();
        this.userEntityMapper = Selma.builder(UserEntityMapper.class).build();
    }

    @Override
    public EmployeeEntity create(EmployeeEntity obj) {
        return employeeEntityRepository.save(obj);
    }

    @Override
    public EmployeeEntity create(BasicEmployeeDTO basicEmployeeDTO) {
        UserEntity userById = userEntityService.getUserById(basicEmployeeDTO.getUserId());
        EmployeeEntity employeeEntity = basicEmployeeMapper.asEmployeeEntity(basicEmployeeDTO);
        employeeEntity.setUserEntity(userById);

        return employeeEntityRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findOne(id);
        if (employeeEntity == null)
            throw new ResourceNotFoundException("Employee with id = " + id + " was not found.");
        return employeeEntity;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeEntityRepository.findAll();
    }

    @Override
    public List<EmployeeEntity> searchEmployees(SearchEmployeeDTO searchEmployeeDTO) {
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
        if(searchEmployeeDTO.getName() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getName()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.name), searchEmployeeDTO.getName()));
        if (searchEmployeeDTO.getSurname() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getSurname()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.surname), searchEmployeeDTO.getSurname()));
        if(searchEmployeeDTO.getDepartment() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getDepartment()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.department), searchEmployeeDTO.getDepartment()));
        if(searchEmployeeDTO.getDivision() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getDivision()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.division), searchEmployeeDTO.getDivision()));
        if(searchEmployeeDTO.getAddress() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getAddress()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.address), searchEmployeeDTO.getAddress()));
        if(searchEmployeeDTO.getDateOfBirth() != null)
            conditions.add(builder.equal(employees.get(EmployeeEntity_.dateOfBirth), searchEmployeeDTO.getDateOfBirth()));
        if(searchEmployeeDTO.getEmail() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getEmail()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.email), searchEmployeeDTO.getEmail()));
        if(searchEmployeeDTO.getTelephone() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getTelephone()))
            conditions.add(builder.equal(employees.get(EmployeeEntity_.telephone), searchEmployeeDTO.getTelephone()));

        //historyExperience
        if(searchEmployeeDTO.getHistoryStartDate() != null)
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.historyStartDate), searchEmployeeDTO.getHistoryStartDate()));
        if(searchEmployeeDTO.getHistoryEndDate() != null)
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.historyEndDate), searchEmployeeDTO.getHistoryEndDate()));
        if(searchEmployeeDTO.getIsWorking() != null)
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.isWorking), searchEmployeeDTO.getIsWorking()));
        if(searchEmployeeDTO.getCompanyName() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getCompanyName()))
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.companyName), searchEmployeeDTO.getCompanyName()));
        if(searchEmployeeDTO.getPosition() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getPosition()))
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.position), searchEmployeeDTO.getPosition()));
        if(searchEmployeeDTO.getHistoryDescription() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getHistoryDescription()))
            conditions.add(builder.equal(historyExperienceEntities.get(HistoryExperienceEntity_.historyDescription), searchEmployeeDTO.getHistoryDescription()));

        //education
        if(searchEmployeeDTO.getEducationStartDate() != null)
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.educationStartDate), searchEmployeeDTO.getEducationStartDate()));
        if(searchEmployeeDTO.getEducationEndDate() != null)
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.educationEndDate), searchEmployeeDTO.getEducationEndDate()));
        if(searchEmployeeDTO.getIsLearning() != null)
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.isLearning), searchEmployeeDTO.getIsLearning()));
        if(searchEmployeeDTO.getSchoolName() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getSchoolName()))
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.schoolName), searchEmployeeDTO.getSchoolName()));
        if(searchEmployeeDTO.getSubject() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getSubject()))
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.subject), searchEmployeeDTO.getSubject()));
        if(searchEmployeeDTO.getEducationDescription() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getEducationDescription()))
            conditions.add(builder.equal(educationEntities.get(EducationEntity_.educationDescription), searchEmployeeDTO.getEducationDescription()));

        //ability
        if(searchEmployeeDTO.getAbilityType() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getAbilityType()))
            conditions.add(builder.equal(abilityEntities.get(AbilityEntity_.abilityType), searchEmployeeDTO.getAbilityType()));
        if(searchEmployeeDTO.getAbilityLevel() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getAbilityLevel()))
            conditions.add(builder.equal(abilityEntities.get(AbilityEntity_.abilityLevel), searchEmployeeDTO.getAbilityLevel()));
        if(searchEmployeeDTO.getExperience() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getExperience()))
            conditions.add(builder.equal(abilityEntities.get(AbilityEntity_.experience), searchEmployeeDTO.getExperience()));
        if(searchEmployeeDTO.getAbilityDescription() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getAbilityDescription()))
            conditions.add(builder.equal(abilityEntities.get(AbilityEntity_.abilityDescription), searchEmployeeDTO.getAbilityDescription()));

        //additionalInfo
        if(searchEmployeeDTO.getAdditionalInfoName() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getAdditionalInfoName()))
            conditions.add(builder.equal(additionalInfoEntities.get(AdditionalInfoEntity_.additionalInfoName), searchEmployeeDTO.getAdditionalInfoName()));
        if(searchEmployeeDTO.getAdditionalInfoValue() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getAdditionalInfoValue()))
            conditions.add(builder.equal(additionalInfoEntities.get(AdditionalInfoEntity_.additionalInfoValue), searchEmployeeDTO.getAdditionalInfoValue()));

        //permission
        if(searchEmployeeDTO.getPermissionsName() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getPermissionsName()))
            conditions.add(builder.equal(permissionEntities.get(PermissionEntity_.permissionsName), searchEmployeeDTO.getPermissionsName()));
        if(searchEmployeeDTO.getPermissionsValue() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getPermissionsValue()))
            conditions.add(builder.equal(permissionEntities.get(PermissionEntity_.permissionsValue), searchEmployeeDTO.getPermissionsValue()));

        //project
        if(searchEmployeeDTO.getProject() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getProject()))
            conditions.add(builder.equal(projectEntities.get(ProjectEntity_.project), searchEmployeeDTO.getProject()));
        if(searchEmployeeDTO.getClient() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getClient()))
            conditions.add(builder.equal(projectEntities.get(ProjectEntity_.client), searchEmployeeDTO.getClient()));
        if(searchEmployeeDTO.getTechnology() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getTechnology()))
            conditions.add(builder.equal(projectEntities.get(ProjectEntity_.technology), searchEmployeeDTO.getTechnology()));
        if(searchEmployeeDTO.getDuties() != null && StringUtils.isNotEmpty(searchEmployeeDTO.getDuties()))
            conditions.add(builder.equal(projectEntities.get(ProjectEntity_.duties), searchEmployeeDTO.getDuties()));


        TypedQuery<EmployeeEntity> typedQuery = em.createQuery(query
            .select(employees)
            .where(conditions.toArray(new Predicate[] {}))
            .distinct(true)
        );

        return typedQuery.getResultList();
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, BasicEmployeeDTO basicEmployeeDTO) {
        EmployeeEntity employeeEntity = basicEmployeeMapper.asEmployeeEntity(basicEmployeeDTO);
        if(checkIfExists(id))
            employeeEntity.setId(id);

        UserEntity userById = userEntityService.getUserById(basicEmployeeDTO.getUserId());
        employeeEntity.setUserEntity(userById);

        return employeeEntityRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (checkIfExists(id))
            employeeEntityRepository.delete(id);
    }

/*    public <T> Set<T> updateCollection(Set<T> collection) {
        collection.getClass().cast
        collection
            .stream()
            .
        return new HashSet<>();
    }*/

    @Override
    public EmployeeEntity createCompleteEmployee(EmployeeDTO employeeDTO) {
        UserEntity userEntity = userEntityMapper.asUserEntity(employeeDTO.getUserEntityDTO());
        userEntity = userEntityService.create(userEntity);
        EmployeeEntity employeeEntity = basicEmployeeMapper.asEmployeeEntity(employeeDTO);
        employeeEntity.setUserEntity(userEntity);
        employeeEntity = create(employeeEntity);

       EmployeeEntity finalEmployeeEntity = employeeEntity;

        Set<HistoryExperienceEntity> historyExperienceEntities = employeeDTO.getHistoryExperienceEntities()
            .stream()
            .peek(e -> e.setEmployeeEntity(finalEmployeeEntity))
            .collect(Collectors.toSet());
        historyExperienceEntities.forEach(historyExperienceService::create);
        employeeEntity.setHistoryExperienceEntities(historyExperienceEntities);

        Set<EducationEntity> educationEntities = employeeDTO.getEducationEntities()
            .stream()
            .peek(e -> e.setEmployeeEntity(finalEmployeeEntity))
            .collect(Collectors.toSet());
        educationEntities.forEach(educationService::create);
        employeeEntity.setEducationEntities(educationEntities);

        Set<AbilityEntity> abilityEntities = employeeDTO.getAbilityEntities()
            .stream()
            .peek(e -> e.setEmployeeEntity(finalEmployeeEntity))
            .collect(Collectors.toSet());
        abilityEntities.forEach(abilityService::create);
        employeeEntity.setAbilityEntities(abilityEntities);

        Set<AdditionalInfoEntity> additionalInfoEntities = employeeDTO.getAdditionalInfoEntities()
            .stream()
            .peek(e -> e.setEmployeeEntity(finalEmployeeEntity))
            .collect(Collectors.toSet());
        additionalInfoEntities.forEach(additionalInfoService::create);
        employeeEntity.setAdditionalInfoEntities(additionalInfoEntities);

        Set<PermissionEntity> permissionEntities = employeeDTO.getPermissionEntities()
            .stream()
            .peek(e -> e.setEmployeeEntity(finalEmployeeEntity))
            .collect(Collectors.toSet());
        permissionEntities.forEach(permissionService::create);
        employeeEntity.setPermissionEntities(permissionEntities);

        Set<ProjectEntity> projectEntities = employeeDTO.getProjectEntities()
            .stream()
            .peek(e -> e.setEmployeeEntity(finalEmployeeEntity))
            .collect(Collectors.toSet());
        projectEntities.forEach(projectService::create);
        employeeEntity.setProjectEntities(projectEntities);

        Set<LanguageEntity> languageEntities = employeeDTO.getLanguageEntities()
            .stream()
            .peek(e -> e.setEmployeeEntity(finalEmployeeEntity))
            .collect(Collectors.toSet());
        languageEntities.forEach(languageService::create);
        employeeEntity.setLanguageEntities(languageEntities);

        return create(employeeEntity);
    }

    @Override
    public boolean checkIfExists(Long id) {
        if (!employeeEntityRepository.exists(id))
            throw new ResourceNotFoundException("Employee with id = " + id + " was not found.");
        return true;
    }
}
