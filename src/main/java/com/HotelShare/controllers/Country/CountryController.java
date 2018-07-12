package com.HotelShare.controllers.Country;

import com.HotelShare.entities.Address.AddressAdapter;
import com.HotelShare.entities.Address.AddressDTO;
import com.HotelShare.entities.Country.Country;
import com.HotelShare.entities.Country.CountryAdapter;
import com.HotelShare.entities.Country.CountryDTO;
import com.HotelShare.exceptions.NotFoundException;
import com.HotelShare.repositories.Address.AddressRepository;
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

    @Autowired
    AddressRepository addressRepository;

    @Transactional
    @GetMapping("/countries")
    public Page<CountryDTO> getAllCountries(Pageable pageable) {
        return countryRepository.findAll(pageable).map(CountryAdapter::toCountryDTO);
    }

    @Transactional
    @GetMapping("/countries/{countryId}/addresses")
    public Page<AddressDTO> getAllAddressessByCountryId(@PathVariable(value = "countryId") Long countryId,
                                                        Pageable pageable) {
        return addressRepository.findByCountryId(countryId, pageable).map(AddressAdapter::toAddressDTO);
    }

    @Transactional
    @GetMapping("/countries/{countryId}")
    public CountryDTO getCountryById(@PathVariable Long countryId) {
        return CountryAdapter.toCountryDTO(countryRepository.getOne(countryId));
    }
    @Transactional
    @PostMapping("/countries")
    public CountryDTO createCountry(@Valid @RequestBody CountryDTO countryDTO) {
        return CountryAdapter.toCountryDTO(countryRepository.save(CountryAdapter.toCountry(countryDTO)));
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