package org.pdbcorp.spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SubmissionIdGenerationServiceTest {

    SubmissionIdGenerationService service = new SubmissionIdGenerationService();

    @Test
    void whenGenerateInvoked_thenReturnsIds() {
        assertEquals(10, service.generate().size());
    }

    @Test
    void whenGenerateAndRemoveFirstEntryInvoked_thenReturnsLessEntries() {
        assertEquals(9, service.removeFirstEntry(service.generate()).size());
        assertEquals(8, service.removeFirstEntry(service.removeFirstEntry(service.generate())).size());
        assertEquals(7, service.removeFirstEntry(service.removeFirstEntry(service.removeFirstEntry(service.generate())))
                .size());
    }
}
