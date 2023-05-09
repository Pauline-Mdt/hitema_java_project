package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CityServiceImplTest {
    private static final Logger log = LoggerFactory.getLogger(CityServiceImplTest.class);
    @Autowired
    private CityService service;
    private static City city;

    @BeforeAll
    static void beforeAll() {
        log.trace("Before All Start");
        city = new City();
        city.setCity("Paris");
        city.setLastUpdate(LocalDateTime.now());
        log.trace("Before All End");
    }

    @BeforeEach
    void setUp() {
        log.trace("Before Each");
        assertNotNull(service, "ERROR Service city NOT injected.");
    }

    @Test
    void create() {
        City cityCreated = service.create(city);
        assertNotNull(cityCreated, "ERROR creting city");
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        service.delete(city.getId());
        assertNull(city, "ERROR deleting city");
    }

    @Test
    void readAll() {
        assertNotNull(city, "ERROR city is NOT set");
        service.readAll().forEach(c -> log.trace("{}", c));
    }
}