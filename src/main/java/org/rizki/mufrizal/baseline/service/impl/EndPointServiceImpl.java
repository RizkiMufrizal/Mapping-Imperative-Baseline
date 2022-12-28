package org.rizki.mufrizal.baseline.service.impl;

import lombok.extern.log4j.Log4j2;
import org.rizki.mufrizal.baseline.domain.EndPoint;
import org.rizki.mufrizal.baseline.repository.EndPointRepository;
import org.rizki.mufrizal.baseline.service.EndPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CacheConfig(cacheManager = "cacheManagerEndPoint", cacheNames = "ch_end_point")
@Log4j2
public class EndPointServiceImpl implements EndPointService {
    @Autowired
    private EndPointRepository endPointRepository;

    @Cacheable(key = "#backend + '-' + #backendFunction")
    @Override
    public Optional<EndPoint> findByBackendAndBackendFunction(String backend, String backendFunction) {
        return endPointRepository.findByBackendAndBackendFunction(backend, backendFunction);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void reload() {
        log.info("Success Delete All Cache End Point");
    }
}
