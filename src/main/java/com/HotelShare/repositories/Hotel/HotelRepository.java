package com.HotelShare.repositories.Hotel;

import com.HotelShare.entities.Hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
