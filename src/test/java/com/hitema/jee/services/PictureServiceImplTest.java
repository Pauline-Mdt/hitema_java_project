package com.hitema.jee.services;

import com.hitema.jee.entities.Picture;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PictureServiceImplTest {
    private static final Logger log = LoggerFactory.getLogger(PictureServiceImplTest.class);
    @Autowired
    private PictureService pictureService;

    @BeforeEach
    void setUp() {
        log.trace("<<<<<Before Each>>>>>");
        assertNotNull(pictureService, "ERROR Service picture NOT injected.");
    }

    @Test
    void create() {
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
        log.trace("<<<<<<<<<<Start Read All>>>>>>>>>>");
        List<Picture> pictures = pictureService.readAll();
        log.trace("Nombre de photos trouvées : {}", pictures.size());
        pictures.forEach(picture -> log.trace("{}", picture));
        log.trace("<<<<<<<<<<End Read All>>>>>>>>>>");
    }
}