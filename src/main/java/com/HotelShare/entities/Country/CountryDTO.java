package com.HotelShare.entities.Country;

import com.HotelShare.entities.Address.AddressDTO;
import com.HotelShare.entities.AuditModel;
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
public class CountryDTO extends AuditModel {
    private Long id;
    @NotNull private String nameCountry;
}
