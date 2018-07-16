package com.HotelShare.controllers.Equipment;

import com.HotelShare.entities.Address.AddressAdapter;
import com.HotelShare.entities.Equipment.EquipmentAdapter;
import com.HotelShare.entities.Equipment.EquipmentDTO;
import com.HotelShare.entities.Hotel.HotelAdapter;
import com.HotelShare.entities.Hotel.HotelDTO;
import com.HotelShare.exceptions.NotFoundException;
import com.HotelShare.repositories.Equipment.EquimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {

    @Autowired
    private EquimentRepository equimentRepository;

    @Transactional
    @GetMapping()
    public Page<EquipmentDTO> getAllEquipments(@PageableDefault(value = 250) Pageable pageable) {
        return equimentRepository.findAll(pageable).map(EquipmentAdapter::toEquipmentDTO);
    }

    @Transactional
    @GetMapping("/{equipmentId}")
    public EquipmentDTO getEquipmentById(@PathVariable Long equipmentId) {
        return EquipmentAdapter.toEquipmentDTO(equimentRepository.getOne(equipmentId));
    }

    @Transactional
    @PostMapping()
    public EquipmentDTO createEquipment(@Valid @RequestBody EquipmentDTO equipmentDTO) {
        return EquipmentAdapter.toEquipmentDTO(equimentRepository.save(EquipmentAdapter.toEquipment(equipmentDTO)));
    }

    @Transactional
    @PutMapping("/{equipmentId}")
    public EquipmentDTO updateEquipment(@PathVariable (value = "equipmentId") Long equipmentId, @Valid @RequestBody EquipmentDTO equipmentDTORequest) {
        return equimentRepository.findById(equipmentId).map(equipment -> {
            equipment.setNameEquipment(equipmentDTORequest.getNameEquipment());
            equipment.setUpdatedDate(equipmentDTORequest.getUpdatedDate());

            return EquipmentAdapter.toEquipmentDTO(equimentRepository.save(equipment));
        }).orElseThrow(() -> new NotFoundException("EquipmentId " + equipmentId + "not found"));
    }

    @Transactional
    @DeleteMapping("/{equipmentId}")
    public ResponseEntity<?> deleteEquipment(@PathVariable (value = "equipmentId") Long equipmentId) {
        return equimentRepository.findById(equipmentId).map(equipment -> {
            equimentRepository.delete(equipment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("EquipmentId " + equipmentId + " not found"));
    }
}
