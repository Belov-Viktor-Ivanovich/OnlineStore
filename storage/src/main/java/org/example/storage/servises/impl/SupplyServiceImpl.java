package org.example.storage.servises.impl;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.storage.entities.Supply;
import org.example.storage.repositories.SupplyRepository;
import org.example.storage.servises.SupplyService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService {
    private final SupplyRepository repository;

    @Override
    public Supply createSupply(Supply supply) {
        return repository.save(supply);
    }

    @Override
    public Supply getSupplyById(Long id) {
        return repository.findById(id).orElseThrow(()->new NotFoundException("supplynot found"));
    }

    @Override
    public Supply updateSupply(Supply supply) {
        Supply owner = getSupplyById(supply.getId());
        if(supply.getName()!=null)owner.setName(supply.getName());
        owner.setUsername(supply.getUsername());
        return repository.save(owner);
    }

    @Override
    public void deleteSupplyById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Integer getCountFreeSupply(String name) {
        return repository.countAllByNameAndUsernameIsNull(name);
    }

    @Override
    public Supply getFirstFreeSupplyByName(String name) {
        return repository.getFirstByNameAndUsernameIsNull(name);
    }
}
