package com.johnny.profileservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.johnny.profileservice.domain.enumeration.Gender;
import com.johnny.profileservice.domain.enumeration.ProfileStatus;
import com.johnny.profileservice.domain.enumeration.ProfileType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "username", nullable = false)
    private String  username;
    @Column(name = "requestId", nullable = false)
    private  String requestId;
    @NotNull
    @Email(message = "email must be provided", regexp = "")
    @Column(name = "email", nullable = false)
    private String email;
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @NotNull
    @Column(name = "phone_country_code", nullable = false)
    private String phoneCountryCode;

    @NotNull
    @Column(name = "lang", nullable = false)
    private String language;
    @NotNull
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "active")
    private boolean isActive ;

    @NotNull
    @Column(name = "profile_type")
    @Enumerated(EnumType.STRING)
    private ProfileType profileType;

    @NotNull
    @Column(name = "profile_status")
    @Enumerated(EnumType.STRING)
    private ProfileStatus profileStatus;
    @ManyToMany
     @JoinTable(
             name = "app_user_role_table",
             joinColumns = @JoinColumn(name ="app_user_id"),
             inverseJoinColumns = @JoinColumn(name = "authories_id")
     )
    @JsonIgnoreProperties(value = { "authorities",  "users", "profileTypes" }, allowSetters = true)
    private Set<Roles> authorities = new HashSet<>();
    @OneToMany(mappedBy = "appUser")
    @JsonIgnoreProperties(value = {"appUser"}, allowGetters = true)
    private Set<RefreshToken>refreshToken = new HashSet<>();
    @OneToMany(mappedBy = "appUser")
    @JsonIgnoreProperties(value = {"appUser"}, allowGetters = true)
    private Set<RevokeToken> revokeToken = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "app_user_role_table",
            joinColumns = @JoinColumn(name ="app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "authories_id")
    )
    @JsonIgnoreProperties(value = {"appUser", ""}, allowGetters = true)
    private Set<Privileges> privileges = new HashSet<>();

}
