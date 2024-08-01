package com.adboardz.adboardz_inventoryservice.controllers;

import com.adboardz.adboardz_inventoryservice.dtos.InventoryDto;
import com.adboardz.adboardz_inventoryservice.models.Inventory;
import com.adboardz.adboardz_inventoryservice.services.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    InventoryService inventoryService;

    InventoryController(InventoryService inventoryService)
    {
        this.inventoryService=inventoryService;
    }


    @PostMapping()
    public Inventory createInventory(@RequestBody InventoryDto inventoryDto) {
        return null;
    }
    @GetMapping("/all")
    public List<Inventory> getAllInventories() {
//        return inventoryService.getAllInventories();
        return null;
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
//        return inventoryService.getInventoryById(id);
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id) {
//        inventoryService.deleteInventory(id);

    }
}
