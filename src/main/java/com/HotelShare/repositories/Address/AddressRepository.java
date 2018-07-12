package com.HotelShare.repositories.Address;

import com.HotelShare.entities.Address.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Page<Address> findByCountryId(Long addressId, Pageable pageable);
}