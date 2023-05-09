package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CityServiceImplTest {
    private static final Logger log = LoggerFactory.getLogger(CityServiceImplTest.class);
    @Autowired
    private CityService service;

    @Test
    void create() {
        log.trace("<<<<<<<<<<Create City Start>>>>>>>>>>");
        City city = new City();
        city.setCity("Vienne");
        city.setLastUpdate(LocalDateTime.now());
        Country country = new Country();
        country.setId(9L);
        city.setCountry(country);
        service.create(city);
        assertNotNull(city.getId(), "ERROR inserting city.");
        log.info("City Created : {}", city);
        log.trace("<<<<<<<<<<Create City End>>>>>>>>>>");
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void readAll() {
    }

    @Test
    void readAllByName() {
        log.trace("<<<<<<<<<<Read All By Name Start>>>>>>>>>>");
        String str = "az";
        List<City> cities = service.readAllByName(str);
        log.trace("Nombre de villes trouvées : {}", cities.size());
        cities.forEach(c -> log.trace("{}", c));
        log.trace("<<<<<<<<<<Read All By Name End>>>>>>>>>>");
    }

    @Test
    void readAllCapital() {
        log.trace("<<<<<<<<<<Read All Capital Start>>>>>>>>>>");
        List<City> cities = service.readAllCapital();
        log.trace("Nombre de villes trouvées : {}", cities.size());
        cities.forEach(c -> log.trace("{}", c));
        log.trace("<<<<<<<<<<Read All Capital End>>>>>>>>>>");
    }
}