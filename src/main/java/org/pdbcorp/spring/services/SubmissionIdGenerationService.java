package org.pdbcorp.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@CacheConfig(cacheNames = { "submissionIds", "generatedIds" })
@Service
@Slf4j
public class SubmissionIdGenerationService {

    private static final int BATCH_SIZE = 10;

    @Cacheable
    protected List<String> generate() {
        List<String> ids = new ArrayList<>();

        for (int i = 0; i < BATCH_SIZE; i++) {
            ids.add(UUID.randomUUID().toString());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        ids.forEach((id) -> sb.append(id));
        sb.append(" }");
        log.info("Generated ids: {}", sb.toString());
        return ids;
    }

    protected List<String> removeFirstEntry(List<String> ids) {
        ids.remove(0);
        return ids;
    }
}
