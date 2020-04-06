package cl.anderson.errorhandling.controlleradvice.city.service;

import cl.anderson.errorhandling.controlleradvice.city.exception.CityNotFoundException;
import cl.anderson.errorhandling.controlleradvice.city.exception.DataNotFoundException;
import cl.anderson.errorhandling.controlleradvice.city.model.City;
import cl.anderson.errorhandling.controlleradvice.city.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleCityService implements CityService {

    private CityRepository cityRepository;

    public SimpleCityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City findById(Long id) {
        return this.cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
    }

    @Override
    public City save(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public List<City> findAll() {
        List<City> cities = (List<City>) this.cityRepository.findAll();
        if (cities.isEmpty()) {
            throw new DataNotFoundException();
        }
        return cities;
    }
}
