package com.base.api.rest.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @NoArgsConstructor
public class Employee {
    private @Id
    @GeneratedValue Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Role> roles;

    public Employee(String name, List<Role> listaRoles) {
        this.name = name;
        this.roles = listaRoles;
    }
}