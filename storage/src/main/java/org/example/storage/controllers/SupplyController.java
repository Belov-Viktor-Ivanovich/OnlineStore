package org.example.storage.controllers;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.storage.entities.Supply;
import org.example.storage.servises.SupplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/supplies")
public class SupplyController {
    private final SupplyService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Supply createSupply(@RequestBody Supply supply) {
        return service.createSupply(supply);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supply> getSupplyById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getSupplyById(id), HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Supply updateSupply(@RequestBody Supply supply) {
        return service.updateSupply(supply);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSupplyById(@PathVariable Long id) {
        service.deleteSupplyById(id);
    }

    @GetMapping("/{name}/count")
    @ResponseStatus(HttpStatus.OK)
    public Integer getCountFreeSupply(@PathVariable String name) {
        return service.getCountFreeSupply(name);
    }

    @GetMapping("/{name}/first_free")
    @ResponseStatus(HttpStatus.OK)
    public Supply getFirstFreeSupplyByName(@PathVariable String name) {
        return service.getFirstFreeSupplyByName(name);
    }

}
