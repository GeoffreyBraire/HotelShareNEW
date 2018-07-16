/*
package com.HotelShare.entities.Currency;

import com.HotelShare.entities.UserProfile.UserProfile;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "CURRENCY")
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Currency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CURRENCY")
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "currency", cascade = CascadeType.PERSIST)
    private Set<UserProfile> userProfiles;

    @Column(name = "NAME_CURRENCY")
    private String nameCurrency;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE", nullable = false)
    @LastModifiedDate
    private Date updatedDate;
}
*/
