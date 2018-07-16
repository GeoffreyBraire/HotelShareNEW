package com.HotelShare.controllers.User;

import com.HotelShare.entities.Hotel.HotelAdapter;
import com.HotelShare.entities.Hotel.HotelDTO;
import com.HotelShare.entities.User.User;
import com.HotelShare.entities.User.UserAdapter;
import com.HotelShare.entities.User.UserDTO;
import com.HotelShare.exceptions.NotFoundException;
import com.HotelShare.repositories.Hotel.HotelRepository;
import com.HotelShare.repositories.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    @GetMapping()
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserAdapter::toUserDTO);
    }

    @Transactional
    @GetMapping("/{userId}/hotels")
    public Page<HotelDTO> getAllHotelsByUserId(@PathVariable(value = "userId") Long userId, Pageable pageable) {
        return hotelRepository.findByUserId(userId,pageable).map(HotelAdapter::toHotelDTO);
    }

    @Transactional
    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return UserAdapter.toUserDTO(userRepository.getOne(userId));
    }

    @Transactional
    @PostMapping()
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        return UserAdapter.toUserDTO(userRepository.save(UserAdapter.toUser(userDTO)));
    }

    @Transactional
    @PutMapping("/{userId}")
    public UserDTO updateUser(@PathVariable (value = "userId") Long userId, @Valid @RequestBody User userRequest) {
        return userRepository.findById(userId).map(user -> {
            user.setId(userRequest.getId());
            user.setHotels(userRequest.getHotels());
            user.setUserProfile(userRequest.getUserProfile());
            user.setLogin(userRequest.getLogin());
            user.setEmailAddress(userRequest.getEmailAddress());
            user.setPassword(userRequest.getPassword());
            user.setUpdatedDate(userRequest.getUpdatedDate());

            return UserAdapter.toUserDTO(userRepository.save(user));
        }).orElseThrow(() -> new NotFoundException("UserId " + userId + "not found"));
    }

    @Transactional
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable (value = "userId") Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("UserId " + userId + " not found"));
    }
}
