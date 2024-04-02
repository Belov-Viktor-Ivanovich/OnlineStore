package org.example.storage.servises;

import org.example.storage.entities.Supply;

public interface SupplyService {
    Supply createSupply(Supply supply);
    Supply getSupplyById(Long id);
    Supply updateSupply(Supply supply);
    void deleteSupplyById(Long id);
    Integer getCountFreeSupply(String name);
    Supply getFirstFreeSupplyByName(String name);

}
