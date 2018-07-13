package com.HotelShare.entities.Equipment;

public class EquipmentAdapter {
    public static EquipmentDTO toEquipmentDTO(Equipment equipment) {
        return equipment != null ? EquipmentDTO.builder()
                .id(equipment.getId())
                .nameEquipment(equipment.getNameEquipment())
                .createdDate(equipment.getCreatedDate())
                .updatedDate(equipment.getUpdatedDate())
        .build() : null;
    }

    public static Equipment toEquipment(EquipmentDTO equipmentDTO) {
        return equipmentDTO != null ? Equipment.builder()
                .id(equipmentDTO.getId())
                .nameEquipment(equipmentDTO.getNameEquipment())
                .createdDate(equipmentDTO.getCreatedDate())
                .updatedDate(equipmentDTO.getUpdatedDate())
        .build() : null;
    }
}
