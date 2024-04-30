package org.pdbcorp.spring.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Student {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String courseOfStudies;
}
