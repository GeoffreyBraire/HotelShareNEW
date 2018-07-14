package com.HotelShare.entities.Hotel;

import com.HotelShare.entities.Address.Address;
import com.HotelShare.entities.Equipment.Equipment;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "HOTEL")
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_HOTEL")
    private Long id;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOTELTYPE", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private HotelType hotelType;*/

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Address address;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "HOTEL_EQUIPMENT",
            joinColumns = { @JoinColumn(name = "ID_HOTEL") },
            inverseJoinColumns = { @JoinColumn(name = "ID_EQUIPMENT") })
    private Set<Equipment> equipments;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "HOTEL_LANGUAGE",
            joinColumns = { @JoinColumn(name = "ID_HOTEL") },
            inverseJoinColumns = { @JoinColumn(name = "ID_LANGUAGE") })
    private Set<Language> languages;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "HOTEL_CREDITCARD",
            joinColumns = { @JoinColumn(name = "ID_HOTEL") },
            inverseJoinColumns = { @JoinColumn(name = "ID_CREDITCARD") })
    private Set<CreditCard> creditCards;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "hotels")
    private Set<Review> reviews;*/

    @Column(name = "NAME_HOTEL")
    private String nameHotel;

    @Column(name = "NUMBER_ROOMS")
    private Integer numberRooms;

    @Column(name = "NUMBER_STARS")
    private Integer numberStars;

    @Column(name = "NAME_CONTACT")
    private String nameContact;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "WEB_URL")
    private String webURL;

    @Column(name = "ARRIVAL_TIME")
    private String arrivalTime;

    @Column(name = "DEPARTURE_TIME")
    private String departureTime;

    @Column(name = "INTERNET_AVAILABILITY")
    private Boolean internetAvailability;

    @Column(name = "INTERNET_COST")
    private Long internetCost;

    @Column(name = "PARKING_AVAILABILITY")
    private Boolean parkingAvailability;

    @Column(name = "PARKING_COST")
    private Long parkingCost;

    @Column(name = "BREAKFAST_AVAILABILITY")
    private Boolean breakfastAvailability;

    @Column(name = "BREAKFAST_COST")
    private Long breakfastCost;

    @Column(name = "CHILDREN_ALLOWED")
    private Boolean childrenAllowed;

    @Column(name = "ANIMALS_ALLOWED")
    private Boolean animalAllowed;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE", nullable = false)
    @LastModifiedDate
    private Date updatedDate;
}
