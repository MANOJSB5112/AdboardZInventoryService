package com.adboardz.adboardz_inventoryservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Inventory extends BaseModel{
    private String name;
    @OneToOne
    private MediaType mediaType;
    private ScreenType screenType;
    @OneToOne
    private Location location;
    private Double pricePerDay;
    private Boolean isAvailable;
    private Long ownerId;



    public Inventory() {}


    public static InventoryBuilder builder() {
        return new InventoryBuilder();
    }

    public static class InventoryBuilder {
        private String name;
        private MediaType mediaType;
        private ScreenType screenType;
        private Location location;
        private Double pricePerDay;
        private Boolean isAvailable;
        private Long ownerId;

        public InventoryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public InventoryBuilder setMediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public InventoryBuilder setScreenType(ScreenType screenType) {
            this.screenType = screenType;
            return this;
        }

        public InventoryBuilder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public InventoryBuilder setPricePerDay(Double pricePerDay) {
            this.pricePerDay = pricePerDay;
            return this;
        }

        public InventoryBuilder setIsAvailable(Boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public InventoryBuilder setMediaAgency(Long ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Inventory build() {
            Inventory inventory = new Inventory();
            inventory.setName(this.name);
            inventory.setMediaType(this.mediaType);
            inventory.setScreenType(this.screenType);
            inventory.setLocation(this.location);
            inventory.setPricePerDay(this.pricePerDay);
            inventory.setIsAvailable(this.isAvailable);
            inventory.setOwnerId(this.ownerId);
            return inventory;
        }
      }
}
