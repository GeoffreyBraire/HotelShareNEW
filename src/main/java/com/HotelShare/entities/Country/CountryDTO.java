package com.HotelShare.entities.Country;

import com.HotelShare.entities.Address.AddressDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    private Long id;
    @NotNull private String nameCountry;
}
