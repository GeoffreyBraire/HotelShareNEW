package com.HotelShare.controllers.Address;

import com.HotelShare.entities.Address.Address;
import com.HotelShare.entities.Address.AddressAdapter;
import com.HotelShare.entities.Address.AddressDTO;
import com.HotelShare.entities.Country.CountryAdapter;
import com.HotelShare.entities.Country.CountryDTO;
import com.HotelShare.entities.Hotel.HotelAdapter;
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

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    @GetMapping("/addresses")
    public Page<AddressDTO> getAllAddressess(Pageable pageable) {
        return addressRepository.findAll(pageable).map(AddressAdapter::toAddressDTO);
    }

    @Transactional
    @GetMapping("/addresses/{addressId}")
    public AddressDTO getAddressById(@PathVariable Long addressId) {
        return AddressAdapter.toAddressDTO(addressRepository.getOne(addressId));
    }

    @Transactional
    @PostMapping("/addresses")
    public AddressDTO createAddress(@Valid @RequestBody AddressDTO addressDTO) {
        return AddressAdapter.toAddressDTO(addressRepository.save(AddressAdapter.toAddress(addressDTO)));
    }

    @Transactional
    @PutMapping("/addresses/{addressId}")
    public AddressDTO updateAddress(@PathVariable (value = "addressId") Long addressId, @Valid @RequestBody AddressDTO addressDTORequest) {
        return addressRepository.findById(addressId).map(address -> {
            address.setCountry(CountryAdapter.toCountry(addressDTORequest.getCountryDTO()));
            address.setCity(addressDTORequest.getCity());
            address.setPostalCode(addressDTORequest.getPostalCode());
            address.setStreetName(addressDTORequest.getStreetName());
            address.setStreetNumber(address.getStreetNumber());
            return AddressAdapter.toAddressDTO(addressRepository.save(address));
        }).orElseThrow(() -> new NotFoundException("AddressId " + addressId + "not found"));
    }

    @Transactional
    @DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<?> deleteAddress(@PathVariable (value = "addressId") Long addressId) {
        return addressRepository.findById(addressId).map(address -> {
            addressRepository.delete(address);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("AddressId " + addressId + " not found"));
    }
}
