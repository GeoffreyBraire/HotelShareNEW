package com.HotelShare.entities.Address;

import com.HotelShare.entities.AuditModel;
import com.HotelShare.entities.Country.Country;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADDRESS")
    private long id;

    /*@OneToOne()
    @JoinColumn(name = "ID_PROFILE", nullable = false)
    private UserProfile userProfile;

    @OneToOne()
    @JoinColumn(name = "ID_HOTEL", nullable = false)
    private Hotel hotel;*/

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
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
}
