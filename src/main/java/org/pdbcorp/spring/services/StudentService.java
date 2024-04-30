package org.pdbcorp.spring.services;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.pdbcorp.spring.models.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@CacheConfig(cacheNames = "studentCache")
@Service
@Slf4j
public class StudentService {

    private static final AtomicLong ID_CREATOR = new AtomicLong(0);
    private Map<Long, Student> students;

    public StudentService() {
        students = new ConcurrentHashMap<>();
        students.put(ID_CREATOR.incrementAndGet(), new Student(ID_CREATOR.get(), "John", "Doe", "Computer Science"));
        students.put(ID_CREATOR.incrementAndGet(), new Student(ID_CREATOR.get(), "Jane", "Doe", "Information Systems"));
        students.put(ID_CREATOR.incrementAndGet(), new Student(ID_CREATOR.get(), "Homer", "Griffin", "Mathematics"));
    }

    @Cacheable
    public Optional<Student> find(Long id) {
        log.info("Finding student with id={}", id);
        return Optional.ofNullable(students.get(id));
    }

    @CachePut(key = "#result.id")
    public Student create(String firstName, String lastName, String courseOfStudies) {
        log.info("Creating student with firstName={}, lastName={}, and courseOfStudies={}", firstName, lastName,
                courseOfStudies);
        Student student = new Student(ID_CREATOR.incrementAndGet(), firstName, lastName, courseOfStudies);
        students.put(ID_CREATOR.get(), student);
        return student;
    }
}
