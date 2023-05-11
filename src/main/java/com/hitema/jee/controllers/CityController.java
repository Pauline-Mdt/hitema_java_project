package com.hitema.jee.controllers;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Picture;
import com.hitema.jee.services.CityService;
import com.hitema.jee.services.CountryService;
import com.hitema.jee.services.PictureService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class CityController {
    private static final Logger log = LogManager.getLogger(CountryController.class);

    private CityService cityService;
    private CountryService countryService;
    private PictureService pictureService;

    public CityController(CityService cityService, PictureService pictureService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.pictureService = pictureService;
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

    @GetMapping("/city")
    public ModelAndView getCities(@RequestParam Long id) {
        City city = cityService.read(id);
        log.trace("city : {}", cityService.read(id));
        return new ModelAndView("city", "city", city);
    }

    @GetMapping("/cityModify")
    public ModelAndView getcityModify() {
        log.trace("Appel getCityModify City");
        City city = new City();
        city.setLastUpdate(LocalDateTime.now());
        return new ModelAndView("cityModify","city",city);
    }

    @PostMapping("/cityModify")
    public ModelAndView cityModify(@ModelAttribute("cityForm") City city, BindingResult result, ModelMap model, @RequestParam MultipartFile picture) {
        log.trace("cityForm : {}", city);
        log.trace("result : {}", result);
        log.trace("model : {}", model);
        log.trace("picture : {}", picture);
        log.trace("getName : {}", picture.getName());
        log.trace("getOriginalFilename : {}", picture.getOriginalFilename());
        log.trace("getSize : {}", picture.getSize());
        log.trace("getContentType : {}", picture.getContentType());
        log.trace("getResource : {}", picture.getResource());
        log.trace("isEmpty : {}", picture.isEmpty());

        city.setLastUpdate(LocalDateTime.now());
        city.setCountry(countryService.read(34L));
        cityService.create(city);

        if (!picture.isEmpty()) {
            try {
                Picture newPicture = new Picture();
                newPicture.setName(picture.getOriginalFilename());
                newPicture.setType(picture.getContentType());
                newPicture.setSize(String.valueOf(picture.getSize()));
                newPicture.setFile(Arrays.toString(picture.getBytes()));
                newPicture.setCity(city);
                newPicture.setLastUpdate(LocalDateTime.now());

                pictureService.create(newPicture);
                log.trace("newPicture : {}", newPicture);
            } catch (Exception e) {
                log.error("Error : {}", e.getMessage());
            }
        }
        return new ModelAndView("cityModify","city",city);
    }
}
