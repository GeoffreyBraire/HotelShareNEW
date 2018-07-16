package com.HotelShare.repositories.UserProfile;

import com.HotelShare.entities.UserProfile.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Page<UserProfile> findByCurrencyId(Long userProfileId, Pageable pageable);
}
