package com.hitema.jee.services;

import com.hitema.jee.entities.City;

import java.util.List;

public interface CityService {
    City create(City city);
    City read(Long id);
    City update(City city);
    void delete(Long id);
    List<City> readAll();
}
