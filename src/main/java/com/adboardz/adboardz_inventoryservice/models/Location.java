package com.adboardz.adboardz_inventoryservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Location extends BaseModel{
    private String name;
    private Double latitude;
    private Double longitude;
    private String address;
    private String city;
}
