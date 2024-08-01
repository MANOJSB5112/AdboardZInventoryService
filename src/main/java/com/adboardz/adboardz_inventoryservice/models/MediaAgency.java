package com.adboardz.adboardz_inventoryservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MediaAgency extends BaseModel{
    private String companyName;
    private String email;
    private String phoneNumber;
    private String city;
    private Long ownerId;
}
