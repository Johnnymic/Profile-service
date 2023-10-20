package com.johnny.profileservice.service;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

public class AppUserCriteria {

    private String  username;

    private  String requestId;

    private String email;

    private String firstName;

    private String lastName;


    private String password;


    private String phoneNumber;

    private Date dateOfBirth;

    private String phoneCountryCode;


    private String language;

    private String gender;

    private String  profileType;

}
