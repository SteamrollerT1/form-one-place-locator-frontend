package com.dsw.formoneplaceallocator.models;


import lombok.Data;

@Data
public class School {
    private String name;
    private String city;
    private String suburb;
    private String street;
    private String number;
    private int maxUnitsAllowed;
    private int applicantCapacity;


}
