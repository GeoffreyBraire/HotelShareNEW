package com.HotelShare.entities.Address;

import com.HotelShare.entities.Country.CountryAdapter;
import com.HotelShare.entities.Hotel.HotelAdapter;

public class AddressAdapter {
    public static AddressDTO toAddressDTO(Address address) {
        return address != null ? AddressDTO.builder()
            .id(address.getId())
            .idHotel(address.getIdHotel())
            .postalCode(address.getPostalCode())
            .city(address.getCity())
            .streetName(address.getStreetName())
            .streetNumber(address.getStreetNumber())
            .countryDTO(CountryAdapter.toCountryDTO(address.getCountry()))
            .createdDate(address.getCreatedDate())
            .updatedDate(address.getUpdatedDate())
        .build() : null;
    }

    public static Address toAddress(AddressDTO addressDTO) {
        return addressDTO != null ? Address.builder()
            .id(addressDTO.getId())
            .idHotel(addressDTO.getIdHotel())
            .city(addressDTO.getCity())
            .postalCode(addressDTO.getPostalCode())
            .streetName(addressDTO.getStreetName())
            .streetNumber(addressDTO.getStreetNumber())
            .country(CountryAdapter.toCountry(addressDTO.getCountryDTO()))
            .createdDate(addressDTO.getCreatedDate())
            .updatedDate(addressDTO.getUpdatedDate())
        .build() : null;
    }
}
