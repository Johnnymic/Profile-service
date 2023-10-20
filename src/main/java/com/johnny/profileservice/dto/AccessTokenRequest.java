package com.johnny.profileservice.service;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessTokenRequest {

    private String refreshToken;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    private String authType;
    private String companyId;

}
