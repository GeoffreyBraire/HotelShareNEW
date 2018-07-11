package com.HotelShare.entities.Address;

import com.HotelShare.entities.Country.CountryDTO;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private long id;
    private CountryDTO countryDTO;
    private String postalCode;
    private String city;
    private String streetName;
    private String streetNumber;
}
