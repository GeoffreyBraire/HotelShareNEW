package com.HotelShare.entities.User;

public class UserAdapter {
    public static UserDTO toUserDTO(User user) {
        return user != null ? UserDTO.builder()
                .id(user.getId())
                .userProfile(user.getUserProfile())
                .login(user.getLogin())
                .emailAddress(user.getEmailAddress())
                .password(user.getPassword())
                .createdDate(user.getCreatedDate())
                .updatedDate(user.getUpdatedDate())
        .build() : null;
    }

    public static User toUser(UserDTO userDTO) {
        return userDTO != null ? User.builder()
                .id(userDTO.getId())
                .userProfile(userDTO.getUserProfile())
                .login(userDTO.getLogin())
                .emailAddress(userDTO.getEmailAddress())
                .password(userDTO.getPassword())
                .createdDate(userDTO.getCreatedDate())
                .updatedDate(userDTO.getUpdatedDate())
        .build() : null;
    }
}
