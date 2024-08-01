package com.adboardz.adboardz_inventoryservice.services;

import com.adboardz.adboardz_inventoryservice.dtos.InventoryDto;
import com.adboardz.adboardz_inventoryservice.models.Inventory;
import com.adboardz.adboardz_inventoryservice.repos.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {


   private InventoryRepo inventoryRepo;

    @Autowired
    InventoryService(InventoryRepo inventoryRepo)
    {
        this.inventoryRepo=inventoryRepo;
    }

    public void createInventory(InventoryDto inventoryDto) {

        Inventory inventory=Inventory.builder()
                .setName(inventoryDto.getName())
                .setMediaType(inventoryDto.getMediaType())
                .setScreenType(inventoryDto.getScreenType())
                .setIsAvailable(inventoryDto.getIsAvailable())
                .setLocation(inventoryDto.getLocation())
                .setPricePerDay(inventoryDto.getPricePerDay())
                .build();
        inventoryRepo.save(inventory);


    }


    public List<Inventory> getAllInventories() {
        return null;
    }


    public Inventory getInventoryById(Long id) {
        return null;
    }


    public void deleteInventory(Long id) {

    }
}
