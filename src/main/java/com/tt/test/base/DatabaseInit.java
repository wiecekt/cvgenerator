package com.tt.test.base;

import com.tt.test.domain.*;
import com.tt.test.domain.enumeration.AccountType;
import com.tt.test.domain.enumeration.SectionType;
import com.tt.test.service.*;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
public class DatabaseInit {

    @Autowired
    private AbilityService abilityService;
    @Autowired
    private AdditionalInfoService additionalInfoService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private HistoryExperienceService historyExperienceService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserEntityService userEntityService;

    @PostConstruct
    private void init() {

        List<DictionaryEntity> dictionaryEntities = Arrays.asList(

            new DictionaryEntity(null, SectionType.LANGUAGE, "languageName", "Polski"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageName", "Angielski"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageName", "Niemiecki"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageName", "Rosyjski"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageName", "Włoski"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageName", "Hiszpański"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageLevel", "A1"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageLevel", "A2"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageLevel", "B1"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageLevel", "B2"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageLevel", "C1"),
            new DictionaryEntity(null, SectionType.LANGUAGE, "languageLevel", "C2")

        );
        dictionaryEntities.forEach(dictionaryService::create);

        List<EmployeeEntity> employeeEntities = Arrays.asList(
            new EmployeeEntity(
                null,
                "Jan",
                "Kowalski",
                "IT",
                "Koszalin",
                "Fiołkowa 3/12",
                new LocalDate(2007, 10, 3),
                "jan.kowalski@gmail.com",
                "123456789",
                null,
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>()
            )
        );
        employeeEntities.forEach(employeeService::create);

        List<UserEntity> userEntities = Arrays.asList(
            new UserEntity(null, "jan", "pass", AccountType.EMPLOYEE, employeeEntities.get(0))
        );
        userEntities.forEach(userEntityService::create);

        List<AbilityEntity> abilityEntities = Arrays.asList(
            new AbilityEntity(null,
                "Obsługa komputera",
                "Zaawansowany",
                "5 lat",
                "Znajomość pakietu Office",
                employeeEntities.get(0)
            )
        );
        abilityEntities.forEach(abilityService::create);

        List<AdditionalInfoEntity> additionalInfoEntities = Arrays.asList(
            new AdditionalInfoEntity(null,
                "Dodatkowa ciekawa informacja",
                "Jej opis",
                employeeEntities.get(0)
            )
        );
        additionalInfoEntities.forEach(additionalInfoService::create);

        List<EducationEntity> educationEntities = Arrays.asList(
            new EducationEntity(null,
                new LocalDate(2000, 10, 15),
                new LocalDate(2004, 10, 15),
                true,
                "Fajna szkoła",
                "Fajny kierunek",
                "Fajny opis",
                employeeEntities.get(0)
            )
        );
        educationEntities.forEach(educationService::create);

        List<HistoryExperienceEntity> historyExperienceEntities = Arrays.asList(
            new HistoryExperienceEntity(
                null,
                new LocalDate(2015, 10, 10),
                new LocalDate(2016, 10, 10),
                false,
                "Fajna firma",
                "Fajna posada",
                "Fajnie było",
                employeeEntities.get(0)
            )
        );
        historyExperienceEntities.forEach(historyExperienceService::create);

        List<LanguageEntity> languageEntities = Arrays.asList(
            new LanguageEntity(
                null,
                "Angielski",
                "C2",
                "Cool certificate",
                employeeEntities.get(0)
            ),
            new LanguageEntity(
                null,
                "Niemiecki",
                "B1",
                "kühl Zertifikat",
                employeeEntities.get(0)
            )
        );
        languageEntities.forEach(languageService::create);

        List<PermissionEntity> permissionEntities = Arrays.asList(
            new PermissionEntity(
                null,
                "Nazwa uprawnienia",
                "Jakaś wartość nie wiem o co kaman",
                employeeEntities.get(0)
            )
        );
        permissionEntities.forEach(permissionService::create);

        List<ProjectEntity> projectEntities = Arrays.asList(
            new ProjectEntity(
                null,
                "Fajny projekt",
                "Fajny klient",
                "Fajna technologia",
                "Fajne obowiazki, i jeszcze inne ciekawe obowiazki",
                employeeEntities.get(0)
            )
        );
        projectEntities.forEach(projectService::create);

        employeeEntities.get(0).setUserEntity(userEntities.get(0));
        employeeEntities.get(0).setHistoryExperienceEntities(new HashSet<>(historyExperienceEntities));
        employeeEntities.get(0).setEducationEntities(new HashSet<>(educationEntities));
        employeeEntities.get(0).setAbilityEntities(new HashSet<>(abilityEntities));
        employeeEntities.get(0).setAdditionalInfoEntities(new HashSet<>(additionalInfoEntities));
        employeeEntities.get(0).setPermissionEntities(new HashSet<>(permissionEntities));
        employeeEntities.get(0).setProjectEntities(new HashSet<>(projectEntities));
        employeeEntities.get(0).setLanguageEntities(new HashSet<>(languageEntities));
        employeeEntities.forEach(employeeService::create);
    }

}
