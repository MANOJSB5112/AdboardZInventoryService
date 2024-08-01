package com.adboardz.adboardz_inventoryservice.repos;

import com.adboardz.adboardz_inventoryservice.models.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaTypeRepository extends JpaRepository<MediaType,Long> {
    Optional<MediaType> findByName(String name);
}
