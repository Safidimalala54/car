package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Energie;
import com.voiture.gasicar.Service.EnergieService;

import java.util.List;

@RestController
@RequestMapping("/api/energies")
public class EnergieController {

    @Autowired
    private EnergieService energieService;

    @GetMapping
    public List<Energie> getAllEnergies() {
        return energieService.getAllEnergies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Energie> getEnergieById(@PathVariable Integer id) {
        return energieService.getEnergieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Energie> createEnergie(@RequestBody Energie energie) {
        Energie createdEnergie = energieService.createEnergie(energie);
        return ResponseEntity.ok(createdEnergie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Energie> updateEnergie(@PathVariable Integer id, @RequestBody Energie updatedEnergie) {
        Energie updated = energieService.updateEnergie(id, updatedEnergie);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnergie(@PathVariable Integer id) {
        energieService.deleteEnergie(id);
        return ResponseEntity.noContent().build();
    }
}

