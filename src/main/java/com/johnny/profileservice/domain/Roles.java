package com.johnny.profileservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "user_defined", nullable = false)
    private Boolean userDefined;

    @NotNull
    @Column(name = "default_role", nullable = false)
    private Boolean defaultRole;

    @Column(name = "role_group")
    private String roleGroup;

    @Column(name = "module_id")
    private String moduleId;

    @ManyToMany(mappedBy = "authorities")
    @JoinTable(
            name = "rel_app_role__authorities",
            joinColumns = @JoinColumn(name = "app_role_id"),
            inverseJoinColumns = @JoinColumn(name = "authorities_id")
    )
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "roles" }, allowSetters = true)
    private Set<Privileges> authorities = new HashSet<>();


    @ManyToMany(mappedBy = "authorities")
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "assignedOrgs", "authorities", "refreshTokens", "revokedTokens" }, allowSetters = true)
    private Set<AppUser> users = new HashSet<>();



}
