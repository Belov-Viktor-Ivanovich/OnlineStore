package org.example.storage.repositories;

import org.example.storage.entities.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supply,Long> {
    Supply getSuppliesByNameAndUsernameIsNull(String name);
    Integer countAllByNameAndUsernameIsNull(String name);
}
