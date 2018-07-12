package com.HotelShare.entities.Country;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO implements Serializable {
    private Long id;
    @NotNull private String nameCountry;
    @Temporal(TemporalType.TIMESTAMP) @CreatedDate private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP) @LastModifiedDate private Date updatedDate;
}
