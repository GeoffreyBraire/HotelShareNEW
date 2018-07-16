package com.HotelShare.controllers.UserProfile;

import com.HotelShare.entities.Currency.CurrencyAdapter;
import com.HotelShare.entities.User.UserAdapter;
import com.HotelShare.entities.User.UserDTO;
import com.HotelShare.entities.UserProfile.UserProfile;
import com.HotelShare.entities.UserProfile.UserProfileAdapter;
import com.HotelShare.entities.UserProfile.UserProfileDTO;
import com.HotelShare.exceptions.NotFoundException;
import com.HotelShare.repositories.User.UserRepository;
import com.HotelShare.repositories.UserProfile.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/userprofiles")
public class UserProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Transactional
    @GetMapping()
    public Page<UserProfileDTO> getAllUserProfiles(Pageable pageable) {
        return userProfileRepository.findAll(pageable).map(UserProfileAdapter::toUserProfileDTO);
    }

    @Transactional
    @GetMapping("/{userProfileId}")
    public UserProfileDTO getUserProfileById(@PathVariable Long userProfileId) {
        return UserProfileAdapter.toUserProfileDTO(userProfileRepository.getOne(userProfileId));
    }

    @Transactional
    @PostMapping()
    public UserProfileDTO createUserProfile(@Valid @RequestBody UserProfileDTO userProfileDTO) {
        return UserProfileAdapter.toUserProfileDTO(userProfileRepository.save(UserProfileAdapter.toUserProfile(userProfileDTO)));
    }

    @Transactional
    @PutMapping("/{userProfileId}")
    public UserProfileDTO updateUserProfile(@PathVariable (value = "userProfileId") Long userProfileId, @Valid @RequestBody UserProfileDTO userProfileDTORequest) {
        return userProfileRepository.findById(userProfileId).map(userProfile -> {
            userProfile.setCurrency(CurrencyAdapter.toCurrency(userProfileDTORequest.getCurrencyDTO()));
            userProfile.setAdmin(false);
            userProfile.setFisrtname(userProfileDTORequest.getFisrtname());
            userProfile.setLastname(userProfileDTORequest.getLastname());
            userProfile.setGender(userProfileDTORequest.getGender());
            userProfile.setBirthDate(userProfileDTORequest.getBirthDate());
            userProfile.setDescription(userProfileDTORequest.getDescription());
            userProfile.setPhoneNumber(userProfileDTORequest.getPhoneNumber());
            userProfile.setSchool(userProfileDTORequest.getSchool());
            userProfile.setActualJob(userProfileDTORequest.getActualJob());
            userProfile.setUpdatedDate(userProfileDTORequest.getUpdatedDate());

            return UserProfileAdapter.toUserProfileDTO(userProfileRepository.save(userProfile));
        }).orElseThrow(() -> new NotFoundException("UserProfileId " + userProfileId + "not found"));
    }

    @Transactional
    @DeleteMapping("/{userProfileId}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable (value = "userProfileId") Long userProfileId) {
        return userProfileRepository.findById(userProfileId).map(userProfile -> {
            userProfileRepository.delete(userProfile);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("UserProfileId " + userProfileId + " not found"));
    }
}
