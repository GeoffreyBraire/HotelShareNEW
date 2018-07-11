package com.HotelShare.controllers.Address;

import com.HotelShare.entities.Address.Address;
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

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    @GetMapping("/countries/{countryId}/addresses")
    public Page<Address> getAllAddressessByCountryId(@PathVariable(value = "countryId") Long countryId,
                                                     Pageable pageable) {
        return addressRepository.findByCountryId(countryId, pageable);
    }

    @Transactional
    @PostMapping("/countries/{countryId}/addresses")
    public Address createAddress(@PathVariable (value = "countryId") Long countryId,
                                 @Valid @RequestBody Address address) {
        return countryRepository.findById(countryId).map(country -> {
            address.setCountry(country);
            return addressRepository.save(address);
        }).orElseThrow(() -> new NotFoundException("CountryId " + countryId + " not found"));
    }

    @Transactional
    @PutMapping("/countries/{countryId}/addresses/{addressId}")
    public Address updateAddress(@PathVariable (value = "countryId") Long countryId,
                                 @PathVariable (value = "addressId") Long addressId,
                                 @Valid @RequestBody Address addressRequest) {
        if(!countryRepository.existsById(countryId)) {
            throw new NotFoundException("CountryId " + countryId + " not found");
        }

        return addressRepository.findById(addressId).map(address -> {
            address.setCountry(addressRequest.getCountry());
            address.setCity(addressRequest.getCity());
            address.setPostalCode(addressRequest.getPostalCode());
            address.setStreetName(addressRequest.getStreetName());
            address.setStreetNumber(address.getStreetNumber());

            return addressRepository.save(address);
        }).orElseThrow(() -> new NotFoundException("AddressId " + addressId + "not found"));
    }

    @Transactional
    @DeleteMapping("/countries/{countryId}/addresses/{addressId}")
    public ResponseEntity<?> deleteAddress(@PathVariable (value = "countryId") Long countryId,
                                           @PathVariable (value = "addressId") Long addressId) {
        if(!countryRepository.existsById(countryId)) {
            throw new NotFoundException("CountryId " + countryId + " not found");
        }

        return addressRepository.findById(addressId).map(address -> {
            addressRepository.delete(address);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("AddressId " + addressId + " not found"));
    }
}
