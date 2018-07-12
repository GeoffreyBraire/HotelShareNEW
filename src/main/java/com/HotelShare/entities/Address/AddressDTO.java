package com.HotelShare.entities.Address;

import com.HotelShare.entities.Country.CountryDTO;
import com.HotelShare.entities.Hotel.HotelDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private long id;
    private HotelDTO hotelDTO;
    private CountryDTO countryDTO;
    private String postalCode;
    private String city;
    private String streetName;
    private String streetNumber;
    @Temporal(TemporalType.TIMESTAMP) @CreatedDate private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP) @LastModifiedDate private Date updatedDate;
}
