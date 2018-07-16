package com.HotelShare.entities.User;

import com.HotelShare.PasswordHash;
import com.HotelShare.entities.Address.Address;
import com.HotelShare.entities.Hotel.Hotel;
import com.HotelShare.entities.UserProfile.UserProfile;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "USERS")
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER")
    private long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private UserProfile userProfile;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.PERSIST)
    private Set<Hotel> hotels;

    /*@OneToMany(mappedBy = "user")
    private Set<Room> rooms;*/

    /*@OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;*/

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "users")
    private Set<Review> reviews;*/

    @NotNull
    @Column(name = "LOGIN")
    private String login;

    @NotNull
    @Email
    @Column(name = "EMAIL_ADDRESS", unique = true)
    private String emailAddress;

    @NotNull
    @Column(name = "PASSWORD")
    @Getter
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE", nullable = false)
    @LastModifiedDate
    private Date updatedDate;

    public User() {}

    public User(long id, UserProfile userProfile, Set<Hotel> hotels, @NotNull String login, @NotNull @Email String emailAddress, @NotNull String password, Date createdDate, Date updatedDate) {
        this.id = id;
        this.userProfile = userProfile;
        this.hotels = hotels;
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