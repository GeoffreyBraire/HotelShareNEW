package com.HotelShare.entities.Country;


import com.HotelShare.entities.Address.Address;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "COUNTRY", uniqueConstraints= @UniqueConstraint(columnNames={"NAME_COUNTRY"}))
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_COUNTRY")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.PERSIST)
    private Set<Address> addresses;

    @NotNull
    @Column(name = "NAME_COUNTRY")
    private String nameCountry;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE", nullable = false)
    @LastModifiedDate
    private Date updatedDate;
}
