package com.HotelShare.repositories.Hotel;

import com.HotelShare.entities.Hotel.Hotel;
import com.HotelShare.entities.User.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("SELECT h FROM Hotel h INNER JOIN Address a ON h.address = a.id WHERE a.city LIKE '%' || :city || '%'")
    Page<Hotel> findByCity(@Param("city") String city, Pageable pageable);

    @Query("SELECT h FROM Hotel h INNER JOIN Address a ON h.address = a.id WHERE a.postalCode LIKE '%' || :postalCode || '%'")
    Page<Hotel> findByPostalCode(@Param("postalCode") String postalCode, Pageable pageable);

    Page<Hotel> findByUserId( Long userId, Pageable pageable);
}
