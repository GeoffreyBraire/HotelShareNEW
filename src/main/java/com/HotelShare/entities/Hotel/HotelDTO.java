package com.HotelShare.entities.Hotel;

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
public class HotelDTO {
    private Long id;
    private String nameHotel;
    private Integer numberRooms;
    private Integer numberStars;
    private String nameContact;
    private String phoneNumber;
    private String webURL;
    private String arrivalTime;
    private String departureTime;
    private Boolean internetAvailability;
    private Long internetCost;
    private Boolean parkingAvailability;
    private Long parkingCost;
    private Boolean breakfastAvailability;
    private Long breakfastCost;
    private Boolean childrenAllowed;
    private Boolean animalAllowed;
    @Temporal(TemporalType.TIMESTAMP) @CreatedDate private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP) @LastModifiedDate private Date updatedDate;

}