package com.HotelShare.controllers.Country;

import com.HotelShare.entities.Country.Country;
import com.HotelShare.entities.Country.CountryAdapter;
import com.HotelShare.entities.Country.CountryDTO;
import com.HotelShare.exceptions.NotFoundException;
import com.HotelShare.repositories.Country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @Transactional
    @GetMapping("/countries")
    public List<CountryDTO> getAllCountries(Pageable pageable) {
        return countryRepository.findAll(pageable).stream().map(CountryAdapter::toCountryDTO).collect(toList());
    }

    @Transactional
    @GetMapping("/countries/{countryId}")
    public CountryDTO getCountryById(@PathVariable Long countryId) {
        return CountryAdapter.toCountryDTO(countryRepository.getOne(countryId));
    }
    @Transactional
    @PostMapping("/countries")
    public CountryDTO createCountry(@Valid @RequestBody Country country) {
        country.getAddresses().forEach(address -> address.setCountry(country));
        return CountryAdapter.toCountryDTO(countryRepository.save(country));
    }

    @Transactional
    @PutMapping("/countries/{countryId}")
    public CountryDTO updateCountry(@PathVariable Long countryId, @Valid @RequestBody Country countryRequest) {
        return countryRepository.findById(countryId).map(country -> {
            country.setNameCountry(countryRequest.getNameCountry());
            country.setAddresses(countryRequest.getAddresses());
            return CountryAdapter.toCountryDTO(countryRepository.save(country));
        }).orElseThrow(() -> new NotFoundException("CountryId " + countryId + " not found"));
    }

    @Transactional
    @DeleteMapping("/countries/{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long countryId) {
        return countryRepository.findById(countryId).map(country -> {
            countryRepository.delete(country);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("CountryId " + countryId + " not found"));
    }
}