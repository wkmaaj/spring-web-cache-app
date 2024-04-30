package org.pdbcorp.spring.controllers;

import java.util.Optional;

import org.pdbcorp.spring.models.Student;
import org.pdbcorp.spring.services.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest/students")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String get(@PathVariable Long id) {
        Optional<Student> student = studentService.find(id);

        if (student.isPresent()) {
            return student.get().toString();
        }

        return "";
    }

    @PostMapping(path = "/create", produces = MediaType.TEXT_PLAIN_VALUE)
    public String create(@RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String courseOfStudies) {
        log.info("Received the following request parameters, firstName: {}, lastName: {}, courseOfStudies: {}",
                firstName, lastName, courseOfStudies);
        return studentService.create(firstName, lastName, courseOfStudies).toString();
    }
}
