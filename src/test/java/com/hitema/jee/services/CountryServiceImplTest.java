package com.hitema.jee.services;

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
class CountryServiceImplTest {
    private static final Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);
    @Autowired
    private CountryService service;
    private static Country country;

    @BeforeAll
    static void beforeAll() {
        log.trace("Before All Start");
        country = new Country();
        country.setCountry("Monaco");
        country.setLastUpdate(LocalDateTime.now());
        log.trace("Before All End");
    }

    @BeforeEach
    void setUp() {
        log.trace("Before Each");
        assertNotNull(service, "ERROR Service country NOT injected.");
    }

    @Test
    @Order(2)
    void create() {
        Country countryCreated = service.create(country);
        assertNotNull(countryCreated, "ERROR creating country.");
        log.trace("{}", countryCreated);
        country.setId(countryCreated.getId());
    }

    @Test
    @Order(3)
    void read() {
        Country countryReaded = service.read(country.getId());
        assertNotNull(countryReaded,"ERROR reading country");
        log.trace("{}", country);
    }

    @Test
    @Order(4)
    void update() {
    }

    @Test
    @Order(5)
    void delete() {
        service.delete(country.getId());
        assertNull(country, "ERROR deleting country");
    }

    @Test
    @Order(1)
    void readAll() {
        assertNotNull(country, "ERROR country is NOT set");
        service.readAll().forEach(c -> log.trace("{}", c));
    }
}