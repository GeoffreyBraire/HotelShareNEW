package com.HotelShare.entities.Equipment;

import lombok.*;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    private Long id;
    private String nameEquipment;
    private Date createdDate;
    private Date updatedDate;
}
