package com.galvanize.springdemo;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class SpringDemoController {

    private final CountryRepository countryRepo;

    public SpringDemoController(CountryRepository c) {
        this.countryRepo = c;
    }

    @GetMapping("/")
    public String helloWorld() { return "Hello from Spring!"; }


    // Reads all
    @GetMapping("/countries")
    public Iterable<Country> getCountries() {
        return this.countryRepo.findAll();
    }

    // Reads one
    @GetMapping("/countries/{id}")
    public Optional<Country> getCountry(@PathVariable("id") Long id) {
        return this.countryRepo.findById(id);
    }

    // Create one
    @PostMapping("/countries")
    public Country postCountry(@RequestBody Country c) {
        return this.countryRepo.save(c);
    }
}