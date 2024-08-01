package com.adboardz.adboardz_inventoryservice.controllers;

import com.adboardz.adboardz_inventoryservice.dtos.InventoryDto;
import com.adboardz.adboardz_inventoryservice.models.Inventory;
import com.adboardz.adboardz_inventoryservice.services.InventoryService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createInventory(@RequestBody InventoryDto inventoryDto) {
        inventoryService.createInventory(inventoryDto);
        return ResponseEntity.ok("Inventory added Successfully");

    }
    @GetMapping("/all")
    public List<Inventory> getAllInventories() {
       return inventoryService.getAllInventories();
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
       return inventoryService.getInventoryById(id);

    }

    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Long id) {
      return  inventoryService.deleteInventory(id);
    }
}
