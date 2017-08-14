package com.tt.test.config;

import io.github.jhipster.config.JHipsterProperties;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
@AutoConfigureAfter(value = { MetricsConfiguration.class })
@AutoConfigureBefore(value = { WebConfigurer.class, DatabaseConfiguration.class })
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(ehcache.getTimeToLiveSeconds(), TimeUnit.SECONDS)))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(com.tt.test.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.tt.test.domain.UserEntity.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.EmployeeEntity.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.EmployeeEntity.class.getName() + ".historyExperienceEntities", jcacheConfiguration);
            cm.createCache(com.tt.test.domain.EmployeeEntity.class.getName() + ".educationEntities", jcacheConfiguration);
            cm.createCache(com.tt.test.domain.EmployeeEntity.class.getName() + ".abilityEntities", jcacheConfiguration);
            cm.createCache(com.tt.test.domain.EmployeeEntity.class.getName() + ".additionalInfoEntities", jcacheConfiguration);
            cm.createCache(com.tt.test.domain.EmployeeEntity.class.getName() + ".permissionEntities", jcacheConfiguration);
            cm.createCache(com.tt.test.domain.EmployeeEntity.class.getName() + ".projectEntities", jcacheConfiguration);
            cm.createCache(com.tt.test.domain.EmployeeEntity.class.getName() + ".languageEntities", jcacheConfiguration);
            cm.createCache(com.tt.test.domain.HistoryExperienceEntity.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.EducationEntity.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.LanguageEntity.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.AbilityEntity.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.AdditionalInfoEntity.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.PermissionEntity.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.ProjectEntity.class.getName(), jcacheConfiguration);
            cm.createCache(com.tt.test.domain.DictionaryEntity.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
