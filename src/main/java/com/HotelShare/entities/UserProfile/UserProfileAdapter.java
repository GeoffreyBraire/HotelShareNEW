package com.HotelShare.entities.UserProfile;

import com.HotelShare.entities.Currency.Currency;
import com.HotelShare.entities.Currency.CurrencyAdapter;
import com.HotelShare.entities.User.User;

public class UserProfileAdapter {
    public static UserProfileDTO toUserProfileDTO(UserProfile userProfile) {
        return userProfile != null ? UserProfileDTO.builder()
                .id(userProfile.getId())
                .currencyDTO(CurrencyAdapter.toCurrencyDTO(userProfile.getCurrency()))
                .isAdmin(userProfile.isAdmin())
                .fisrtname(userProfile.getFisrtname())
                .lastname(userProfile.getLastname())
                .gender(userProfile.getGender())
                .birthDate(userProfile.getBirthDate())
                .description(userProfile.getDescription())
                .phoneNumber(userProfile.getPhoneNumber())
                .school(userProfile.getSchool())
                .actualJob(userProfile.getActualJob())
                .createdDate(userProfile.getCreatedDate())
                .updatedDate(userProfile.getUpdatedDate())
        .build() : null;
    }

    public static UserProfile toUserProfile(UserProfileDTO userProfileDTO) {
        return userProfileDTO != null ? UserProfile.builder()
                .id(userProfileDTO.getId())
                .currency(CurrencyAdapter.toCurrency(userProfileDTO.getCurrencyDTO()))
                .isAdmin(userProfileDTO.isAdmin())
                .fisrtname(userProfileDTO.getFisrtname())
                .lastname(userProfileDTO.getLastname())
                .gender(userProfileDTO.getGender())
                .birthDate(userProfileDTO.getBirthDate())
                .description(userProfileDTO.getDescription())
                .phoneNumber(userProfileDTO.getPhoneNumber())
                .school(userProfileDTO.getSchool())
                .actualJob(userProfileDTO.getActualJob())
                .createdDate(userProfileDTO.getCreatedDate())
                .updatedDate(userProfileDTO.getUpdatedDate())
        .build() : null;
    }
}
