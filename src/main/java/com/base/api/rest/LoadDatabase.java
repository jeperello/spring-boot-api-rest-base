package com.base.api.rest;

import com.base.api.rest.model.Employee;
import com.base.api.rest.model.Role;
import com.base.api.rest.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        Role roleAdmin = new Role("Administrador", "Encargdo de estas y muchas cosas mas.");
        List<Role> listaRoles = new ArrayList<>();
        listaRoles.add(roleAdmin);
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", listaRoles)));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", new ArrayList<>())));
        };
    }
}