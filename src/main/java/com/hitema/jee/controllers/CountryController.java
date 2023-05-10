package com.hitema.jee.controllers;

import com.hitema.jee.entities.Country;
import com.hitema.jee.services.CountryService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CountryController {

    private static final Logger log = LogManager.getLogger(CountryController.class);

    private CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @PostConstruct
    private void check() {
        log.info("Check postconstruct called service Up : "+(service!=null?"Yes":"No"));
    }

    @GetMapping("/countries")
    public ModelAndView getCountries() {
        List<Country> countries = service.readAll();
        return new ModelAndView("countries", "countries", countries);
    }
}