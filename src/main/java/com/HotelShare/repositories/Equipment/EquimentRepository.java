package com.HotelShare.repositories.Equipment;

import com.HotelShare.entities.Equipment.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquimentRepository extends JpaRepository<Equipment, Long> {
}
