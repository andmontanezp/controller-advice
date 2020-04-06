package cl.anderson.errorhandling.controlleradvice.city.controller;

import cl.anderson.errorhandling.controlleradvice.city.model.City;
import cl.anderson.errorhandling.controlleradvice.city.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/cities")
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.ok(this.cityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.cityService.findById(id));
    }

    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody @Valid City city) {
        return ResponseEntity.ok(this.cityService.save(city));
    }
}
