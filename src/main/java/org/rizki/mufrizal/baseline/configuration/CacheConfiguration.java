package org.rizki.mufrizal.baseline.configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager cacheManagerSystemParameter() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("system_parameter");
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(500)
                .maximumSize(1000));
        return caffeineCacheManager;
    }

    @Bean
    public CacheManager cacheManagerHarmonized() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("harmonized");
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(500)
                .maximumSize(1000));
        return caffeineCacheManager;
    }

    @Bean
    public CacheManager cacheManagerEndPoint() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("end_point");
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(500)
                .maximumSize(1000));
        return caffeineCacheManager;
    }

}