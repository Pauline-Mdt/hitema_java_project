package com.hitema.jee.controllers;

import com.hitema.jee.entities.City;
import com.hitema.jee.services.CityService;
import com.hitema.jee.services.CountryService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CityController {
    private static final Logger log = LogManager.getLogger(CountryController.class);

    private CityService cityService;
    private CountryService countryService;

    public CityController(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @PostConstruct
    private void check() {
        log.info("Check postconstruct called service Up : "+(cityService !=null?"Yes":"No"));
    }

    @GetMapping("/cities")
    public ModelAndView getCities() {
        List<City> cities = cityService.readAll();
        return new ModelAndView("cities", "cities", cities);
    }

    @GetMapping("/cities-by-country")
    public ModelAndView getCitiesByCountry(@RequestParam Long countryId) {
        List<City> cities = countryService.read(countryId).getCities();
        return new ModelAndView("cities", "cities", cities);
    }
}
