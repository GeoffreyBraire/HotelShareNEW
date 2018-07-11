package com.HotelShare.entities.Country;

import com.HotelShare.entities.Address.AddressAdapter;

import static java.util.stream.Collectors.toList;

public class CountryAdapter {
    public static CountryDTO toCountryDTO(Country country) {
        return country != null ? CountryDTO.builder()
                .id(country.getId())
                .nameCountry(country.getNameCountry())
                .addresses(country.getAddresses().stream().map(AddressAdapter::toAddressDTO).collect(toList()))
                .build() : null;

    }

    public static Country toCountry(CountryDTO countryDTO) {
        return countryDTO != null ? Country.builder()
                .id(countryDTO.getId())
                .nameCountry(countryDTO.getNameCountry())
                .addresses(countryDTO.getAddresses().stream().map(AddressAdapter::toAddress).collect(toList()))
                .build() : null;
    }
}
