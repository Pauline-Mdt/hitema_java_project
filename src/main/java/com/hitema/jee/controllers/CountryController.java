package com.hitema.jee.controllers;

import com.hitema.jee.entities.Country;
import com.hitema.jee.services.CountryService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
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

    @GetMapping("/countryModify")
    public ModelAndView getCountryModify() {
        log.trace("Appel getCountryModify Country");
        Country country = new Country();
        country.setLastUpdate(LocalDateTime.now());
        return new ModelAndView("countryModify","country",country);
    }

    @PostMapping ("/countryModify")
    public ModelAndView countryModify(@ModelAttribute("countryForm") Country country, ModelMap model) {
        log.trace("Appel countryModify : {} ", country);
        country.setLastUpdate(LocalDateTime.now());
        service.create(country);
        return new ModelAndView("countryModify","country",country);
    }

//    @GetMapping("/countries/new")
//    public ModelAndView newCountry() {
//        return new ModelAndView("newCountry");
//    }
//
//    @PostMapping("/countries")
//    public ModelAndView createCountry(@ModelAttribute("countryForm") Country country, BindingResult result, ModelMap model) {
//        log.trace("countryForm : {}", country);
//        log.trace("result : {}", result);
//        log.trace("model : {}", model);
//
//        country.setLastUpdate(LocalDateTime.now());
//        service.create(country);
//
//        log.trace(country);
//
//        List<Country> countries = this.service.readAll();
//        return new ModelAndView("countries", "countries", countries);
//    }
}