package com.HotelShare.entities.Country;


import com.HotelShare.entities.Address.Address;
import com.HotelShare.entities.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
public class Country extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COUNTRY")
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.PERSIST)
    private Set<Address> addresses;

    @NotNull
    @Column(name = "NAME_COUNTRY")
    private String nameCountry;
}
