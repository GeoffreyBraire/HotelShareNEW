package com.HotelShare.entities.Hotel;

import com.HotelShare.entities.Address.AddressAdapter;
import com.HotelShare.entities.User.UserAdapter;

public class HotelAdapter {
    public static HotelDTO toHotelDTO(Hotel hotel) {
        return hotel != null ? HotelDTO.builder()
                .id(hotel.getId())
                .userDTO(UserAdapter.toUserDTO(hotel.getUser()))
                .addressDTO(AddressAdapter.toAddressDTO(hotel.getAddress()))
                .nameHotel(hotel.getNameHotel())
                .numberRooms(hotel.getNumberRooms())
                .numberStars(hotel.getNumberStars())
                .nameContact(hotel.getNameContact())
                .phoneNumber(hotel.getPhoneNumber())
                .webURL(hotel.getWebURL())
                .arrivalTime(hotel.getArrivalTime())
                .departureTime(hotel.getDepartureTime())
                .internetAvailability(hotel.getInternetAvailability())
                .internetCost(hotel.getInternetCost())
                .parkingAvailability(hotel.getParkingAvailability())
                .parkingCost(hotel.getParkingCost())
                .breakfastAvailability(hotel.getBreakfastAvailability())
                .breakfastCost(hotel.getBreakfastCost())
                .childrenAllowed(hotel.getChildrenAllowed())
                .animalAllowed(hotel.getAnimalAllowed())
                .createdDate(hotel.getCreatedDate())
                .updatedDate(hotel.getUpdatedDate())
        .build() : null;
    }

    public static Hotel toHotel(HotelDTO hotelDTO) {
        return hotelDTO != null ? Hotel.builder()
                .id(hotelDTO.getId())
                .user(UserAdapter.toUser(hotelDTO.getUserDTO()))
                .address(AddressAdapter.toAddress(hotelDTO.getAddressDTO()))
                .nameHotel(hotelDTO.getNameHotel())
                .numberRooms(hotelDTO.getNumberRooms())
                .numberStars(hotelDTO.getNumberStars())
                .nameContact(hotelDTO.getNameContact())
                .phoneNumber(hotelDTO.getPhoneNumber())
                .webURL(hotelDTO.getWebURL())
                .arrivalTime(hotelDTO.getArrivalTime())
                .departureTime(hotelDTO.getDepartureTime())
                .internetAvailability(hotelDTO.getInternetAvailability())
                .internetCost(hotelDTO.getInternetCost())
                .parkingAvailability(hotelDTO.getParkingAvailability())
                .parkingCost(hotelDTO.getParkingCost())
                .breakfastAvailability(hotelDTO.getBreakfastAvailability())
                .breakfastCost(hotelDTO.getBreakfastCost())
                .childrenAllowed(hotelDTO.getChildrenAllowed())
                .animalAllowed(hotelDTO.getAnimalAllowed())
                .createdDate(hotelDTO.getCreatedDate())
                .updatedDate(hotelDTO.getUpdatedDate())
        .build() : null;
    }
}
