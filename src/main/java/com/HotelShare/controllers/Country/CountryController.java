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
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    AddressRepository addressRepository;

    @Transactional
    @GetMapping()
    public Page<CountryDTO> getAllCountries(@PageableDefault(value = 250) Pageable pageable) {
        return countryRepository.findAll(pageable).map(CountryAdapter::toCountryDTO);
    }

    @Transactional
    @GetMapping("/{countryId}/addresses")
    public Page<AddressDTO> getAllAddressessByCountryId(@PathVariable(value = "countryId") Long countryId,
                                                        Pageable pageable) {
        return addressRepository.findByCountryId(countryId, pageable).map(AddressAdapter::toAddressDTO);
    }

    @Transactional
    @GetMapping("/{countryId}")
    public CountryDTO getCountryById(@PathVariable Long countryId) {
        return CountryAdapter.toCountryDTO(countryRepository.getOne(countryId));
    }

    @Transactional
    @PostMapping()
    public CountryDTO createCountry(@Valid @RequestBody CountryDTO countryDTO) {
        return CountryAdapter.toCountryDTO(countryRepository.save(CountryAdapter.toCountry(countryDTO)));
    }

    @Transactional
    @PutMapping("/{countryId}")
    public CountryDTO updateCountry(@PathVariable Long countryId, @Valid @RequestBody Country countryRequest) {
        return countryRepository.findById(countryId).map(country -> {
            country.setNameCountry(countryRequest.getNameCountry());
            country.setAddresses(countryRequest.getAddresses());
            country.setUpdatedDate(countryRequest.getUpdatedDate());
            return CountryAdapter.toCountryDTO(countryRepository.save(country));
        }).orElseThrow(() -> new NotFoundException("CountryId " + countryId + " not found"));
    }

    @Transactional
    @DeleteMapping("/{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long countryId) {
        return countryRepository.findById(countryId).map(country -> {
            countryRepository.delete(country);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("CountryId " + countryId + " not found"));
    }
}