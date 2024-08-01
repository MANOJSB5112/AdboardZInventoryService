package com.adboardz.adboardz_inventoryservice.repos;

import com.adboardz.adboardz_inventoryservice.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {

}
