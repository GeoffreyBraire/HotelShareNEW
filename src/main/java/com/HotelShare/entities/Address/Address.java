package com.HotelShare.entities.Address;

import com.HotelShare.entities.Country.Country;
import com.HotelShare.entities.Hotel.Hotel;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ADDRESS")
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ADDRESS")
    private Long id;

    /*@OneToOne()
    @JoinColumn(name = "ID_PROFILE", nullable = false)
    private UserProfile userProfile;*/

    /*@OneToOne()
    @JoinColumn(name = "ID_HOTEL", nullable = false)
    private Hotel hotel;*/

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_COUNTRY", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Country country;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "STREET_NUMBER")
    private String streetNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE", nullable = false)
    @LastModifiedDate
    private Date updatedDate;
}
