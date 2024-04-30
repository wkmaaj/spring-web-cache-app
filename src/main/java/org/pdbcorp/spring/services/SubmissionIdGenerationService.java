package org.pdbcorp.spring.services;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@CacheConfig(cacheNames = { "submissionIds", "generatedIds" })
@Service
@Slf4j
public class SubmissionIdGenerationService {

    private static final int BATCH_SIZE = 10;

    public List<String> generate() {
        List<String> ids = List.of();

        for (int i = 0; i < BATCH_SIZE; i++) {
            ids.add(UUID.randomUUID().toString());
        }

        return ids;
    }
}
