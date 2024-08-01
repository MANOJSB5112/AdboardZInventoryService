package com.adboardz.adboardz_inventoryservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MediaType extends BaseModel{
  private String name;
}
