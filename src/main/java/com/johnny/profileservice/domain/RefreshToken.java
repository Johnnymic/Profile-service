package com.johnny.profileservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
@Entity
@Table(name = "refresh_token")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RefreshToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @NotNull
    @Column(name = "expiry_date", nullable = false)
    private Instant expiryDate;
    @ManyToOne
    @JsonIgnoreProperties(value = { "assignedOrgs", "authorities", "refreshTokens", "revokedTokens" }, allowSetters = true)
    private AppUser appUser;

}
