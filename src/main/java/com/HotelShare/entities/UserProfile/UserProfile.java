package com.HotelShare.entities.UserProfile;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USER_PROFILE")
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PROFILE")
    private long id;

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_CURRENCY", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Currency currency;*/

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "userProfile")
    private Address address;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name = "USERPROFILE_LANGUAGE",
            joinColumns = { @JoinColumn(name = "ID_PROFILE") },
            inverseJoinColumns = { @JoinColumn(name = "ID_LANGUAGE") })
    private Set<Language> languages;*/

    @Column(name = "IS_ADMIN")
    private boolean isAdmin;

    @Column(name = "FIRSTNAME")
    private String fisrtname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTHDATE")
    private Date birthDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "SCHOOL")
    private String school;

    @Column(name = "ACTUAL_JOB")
    private String actualJob;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE", nullable = false)
    @LastModifiedDate
    private Date updatedDate;
}