package com.dsw.formoneplaceallocator.models;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String name;
    private String surname;
    private int units;
    private long birthCertificate;
    private long resultsStatement;

    private List<School> schools;


}
