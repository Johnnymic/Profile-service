package com.johnny.profileservice.service.jwt;

import com.johnny.profileservice.domain.enumeration.ProfileStatus;
import com.johnny.profileservice.domain.enumeration.ProfileType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
@Getter
@Setter
public class JwtAppUserTokenDto  implements Serializable {
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String otherName;

    private String primaryOrganization;



    @NotNull
    private String email;

    private String phone;

    @NotNull
    private Boolean enabledTwoFa;

    @NotNull
    private ProfileType profileType;

    private Instant lastLogin;

    @NotNull
    private Boolean requiresPasswordChange;

    @NotNull
    private Boolean requiresTwoFaChange;

    @NotNull
    private String phoneCountryCode;

    private String imageUrl;

    private String langKey;

    @NotNull
    private Boolean activated;

    @NotNull
    private ProfileStatus status;
}
