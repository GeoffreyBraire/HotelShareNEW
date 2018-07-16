package com.HotelShare.entities.Currency;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDTO {
    private long id;
    private String nameCurrency;
    private Date createdDate;
    private Date updatedDate;
}
