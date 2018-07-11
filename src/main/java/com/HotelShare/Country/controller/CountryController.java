package com.HotelShare.Country.controller;

import com.HotelShare.Country.entity.Country;
import com.HotelShare.Country.repository.CountryRepository;
import com.HotelShare.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public Page<Country> getAllCountries(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @GetMapping("/countries/{countryId}")
    public Optional<Country> getCountryById(@PathVariable Long countryId) {
        return countryRepository.findById(countryId);
    }

    @PostMapping("/countries")
    public Country createCountry(@Valid @RequestBody Country country) {
        return countryRepository.save(country);
    }

    @PutMapping("/countries/{countryId}")
    public Country updateCountry(@PathVariable Long countryId, @Valid @RequestBody Country countryRequest) {
        return countryRepository.findById(countryId).map(country -> {
            country.setNameCountry(countryRequest.getNameCountry());
            country.setAddresses(countryRequest.getAddresses());
            return countryRepository.save(country);
        }).orElseThrow(() -> new NotFoundException("CountryId " + countryId + " not found"));
    }

    @DeleteMapping("/countries/{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long countryId) {
        return countryRepository.findById(countryId).map(country -> {
            countryRepository.delete(country);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("CountryId " + countryId + " not found"));
    }
}