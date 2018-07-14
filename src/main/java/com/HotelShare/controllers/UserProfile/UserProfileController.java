package com.HotelShare.controllers.UserProfile;

import com.HotelShare.entities.User.UserAdapter;
import com.HotelShare.entities.User.UserDTO;
import com.HotelShare.entities.UserProfile.UserProfileAdapter;
import com.HotelShare.entities.UserProfile.UserProfileDTO;
import com.HotelShare.exceptions.NotFoundException;
import com.HotelShare.repositories.User.UserRepository;
import com.HotelShare.repositories.UserProfile.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Transactional
    @GetMapping("/{userId}/profile")
    public UserProfileDTO getUserProfileByIdUser(@PathVariable Long userId) {
        return UserProfileAdapter.toUserProfileDTO(userRepository.getOne(userId).getUserProfile());
    }

    @Transactional
    @PostMapping("/{userId}/profile")
    public UserProfileDTO createUserProfile(@PathVariable Long userId, @Valid @RequestBody UserProfileDTO userProfileDTO) {
        return ;
    }

    @Transactional
    @DeleteMapping("/{userId}/profile")
    public ResponseEntity<?> deleteUserProfile(@PathVariable (value = "userId") Long userId) {
        return userRepository.findById(userId).map(user -> {
            userProfileRepository.delete(user.getUserProfile());
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("UserId " + userId + " not found"));
    }
}
