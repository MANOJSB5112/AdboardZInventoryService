package com.adboardz.adboardz_inventoryservice.dtos;

import com.adboardz.adboardz_inventoryservice.models.Location;
import com.adboardz.adboardz_inventoryservice.models.MediaType;
import com.adboardz.adboardz_inventoryservice.models.ScreenType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDto {
    private String name;
    @OneToOne
    private MediaType mediaType;
    private ScreenType screenType;
    @OneToOne
    private Location location;
    private Double pricePerDay;
    private Boolean isAvailable;
    private Long ownerId;
}
