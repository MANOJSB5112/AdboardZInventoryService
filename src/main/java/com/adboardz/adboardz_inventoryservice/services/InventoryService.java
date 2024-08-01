package com.adboardz.adboardz_inventoryservice.services;

import com.adboardz.adboardz_inventoryservice.dtos.InventoryDto;
import com.adboardz.adboardz_inventoryservice.models.Inventory;
import com.adboardz.adboardz_inventoryservice.models.Location;
import com.adboardz.adboardz_inventoryservice.models.MediaType;
import com.adboardz.adboardz_inventoryservice.models.ScreenType;
import com.adboardz.adboardz_inventoryservice.repos.InventoryRepository;
import com.adboardz.adboardz_inventoryservice.repos.LocationRepository;
import com.adboardz.adboardz_inventoryservice.repos.MediaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final MediaTypeRepository mediaTypeRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, MediaTypeRepository mediaTypeRepository, LocationRepository locationRepository) {
        this.inventoryRepository = inventoryRepository;
        this.mediaTypeRepository = mediaTypeRepository;
        this.locationRepository = locationRepository;
    }


    public void createInventory(InventoryDto inventoryDto) {
        if (inventoryDto.getMediaType() == null) {
            throw new IllegalArgumentException("MediaType cannot be null");
        }
        if (inventoryDto.getMediaType().getName() == null) {
            throw new IllegalArgumentException("MediaType name cannot be null");
        }
        if (inventoryDto.getLocation() == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        if (inventoryDto.getLocation().getLatitude() == null || inventoryDto.getLocation().getLongitude() == null) {
            throw new IllegalArgumentException("Location latitude and longitude cannot be null");
        }

        MediaType mediaType = mediaTypeRepository.findByName(inventoryDto.getMediaType().getName())
                .orElseGet(() -> mediaTypeRepository.save(inventoryDto.getMediaType()));


        Location location = locationRepository.findByLatitudeAndLongitude(
                        inventoryDto.getLocation().getLatitude(), inventoryDto.getLocation().getLongitude())
                .orElseGet(() -> locationRepository.save(inventoryDto.getLocation()));


        ScreenType screenType = inventoryDto.getScreenType();

        Inventory inventory = Inventory.builder()
                .setName(inventoryDto.getName())
                .setMediaType(mediaType)
                .setScreenType(screenType)
                .setIsAvailable(inventoryDto.getIsAvailable())
                .setLocation(location)
                .setPricePerDay(inventoryDto.getPricePerDay())
                .setOwnerId(inventoryDto.getOwnerId())
                .build();

        inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        List<Inventory> inventories=inventoryRepository.findAllByIsDeletedIsFalse();
        if(inventories.isEmpty())
        {
            throw new RuntimeException("No Inventories to display");
        }
        return inventories;
    }

    public Inventory getInventoryById(Long id) {
        Optional<Inventory> savedInventory= inventoryRepository.findByIdAndIsDeletedIsFalse(id);
        if (savedInventory.isPresent())
        {
            Inventory inventory=savedInventory.get();
            return inventory;
        }else
        {
            throw new RuntimeException("Inventory with that Id not found");
        }
    }

    public String deleteInventory(Long id) {
        Optional<Inventory> inventory=inventoryRepository.findById(id);
        if(inventory.isPresent())
        {
            Inventory savedInventory=inventory.get();
            savedInventory.setIsDeleted(true);
            inventoryRepository.save(savedInventory);
            return "Deleted successfully";
        }else {
            return "Inventory not exist to delete";
        }
    }
}