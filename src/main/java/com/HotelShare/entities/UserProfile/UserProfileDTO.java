package com.HotelShare.entities.UserProfile;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {
    private long id;
    /*private CurrencyDTO currencyDTO;*/
    private boolean isAdmin;
    private String fisrtname;
    private String lastname;
    private String gender;
    private Date birthDate;
    private String description;
    private String phoneNumber;
    private String school;
    private String actualJob;
    private Date createdDate;
    private Date updatedDate;
}
