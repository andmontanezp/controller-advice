package cl.anderson.errorhandling.controlleradvice.city.service;

import cl.anderson.errorhandling.controlleradvice.city.model.City;

import java.util.List;

public interface CityService {
    City findById(Long id);
    City save(City city);
    List<City> findAll();
}
