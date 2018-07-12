package com.HotelShare.controllers.Hotel;

import com.HotelShare.entities.Address.AddressAdapter;
import com.HotelShare.entities.Hotel.HotelAdapter;
import com.HotelShare.entities.Hotel.HotelDTO;
import com.HotelShare.exceptions.NotFoundException;
import com.HotelShare.repositories.Hotel.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    @GetMapping("/hotels")
    public Page<HotelDTO> getAllHotels(Pageable pageable) {
        return hotelRepository.findAll(pageable).map(HotelAdapter::toHotelDTO);
    }

    @Transactional
    @GetMapping("/hotels/{hotelId}")
    public HotelDTO getHotelById(@PathVariable Long hotelId) {
        return HotelAdapter.toHotelDTO(hotelRepository.getOne(hotelId));
    }

    @Transactional
    @PostMapping("/hotels")
    public HotelDTO createHotel(@Valid @RequestBody HotelDTO hotelDTO) {
        return HotelAdapter.toHotelDTO(hotelRepository.save(HotelAdapter.toHotel(hotelDTO)));
    }

    @Transactional
    @PutMapping("/hotels/{hotelId}")
    public HotelDTO updateHotel(@PathVariable (value = "hotelId") Long hotelId, @Valid @RequestBody HotelDTO hotelDTORequest) {
        return hotelRepository.findById(hotelId).map(hotel -> {
            hotel.setId(hotelDTORequest.getId());
            hotel.setAddress(AddressAdapter.toAddress(hotelDTORequest.getAddressDTO()));
            hotel.setNameHotel(hotelDTORequest.getNameHotel());
            hotel.setNumberRooms(hotelDTORequest.getNumberRooms());
            hotel.setNumberStars(hotelDTORequest.getNumberStars());
            hotel.setNameContact(hotelDTORequest.getNameContact());
            hotel.setPhoneNumber(hotelDTORequest.getPhoneNumber());
            hotel.setWebURL(hotelDTORequest.getWebURL());
            hotel.setArrivalTime(hotelDTORequest.getArrivalTime());
            hotel.setDepartureTime(hotelDTORequest.getDepartureTime());
            hotel.setInternetAvailability(hotelDTORequest.getInternetAvailability());
            hotel.setInternetCost(hotelDTORequest.getInternetCost());
            hotel.setParkingAvailability(hotelDTORequest.getParkingAvailability());
            hotel.setParkingCost(hotelDTORequest.getParkingCost());
            hotel.setBreakfastAvailability(hotelDTORequest.getBreakfastAvailability());
            hotel.setBreakfastCost(hotelDTORequest.getBreakfastCost());
            hotel.setChildrenAllowed(hotelDTORequest.getChildrenAllowed());
            hotel.setAnimalAllowed(hotelDTORequest.getAnimalAllowed());
            hotel.setCreatedDate(hotelDTORequest.getCreatedDate());
            hotel.setUpdatedDate(hotelDTORequest.getUpdatedDate());

            return HotelAdapter.toHotelDTO(hotelRepository.save(hotel));
        }).orElseThrow(() -> new NotFoundException("HotelId " + hotelId + "not found"));
    }

    @Transactional
    @DeleteMapping("/hotels/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable (value = "hotelId") Long hotelId) {
        return hotelRepository.findById(hotelId).map(hotel -> {
            hotelRepository.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("HotelId " + hotelId + " not found"));
    }
}
