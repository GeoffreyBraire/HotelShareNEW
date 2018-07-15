package com.HotelShare.entities.User;

import com.HotelShare.PasswordHash;
import com.HotelShare.entities.UserProfile.UserProfile;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDTO {
    private long id;
    private UserProfile userProfile;
    private String login;
    private String emailAddress;
    @Getter private String password;
    private Date createdDate;
    private Date updatedDate;

    public UserDTO() {}

    public UserDTO(long id, UserProfile userProfile, String login, String emailAddress, String password, Date createdDate, Date updatedDate) {
        this.id = id;
        this.userProfile = userProfile;
        this.login = login;
        this.emailAddress = emailAddress;
        this.password = PasswordHash.getSHA256Hash(password);
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void setPassword(String password) {
        this.password = PasswordHash.getSHA256Hash(password);
    }
}


