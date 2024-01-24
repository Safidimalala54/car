package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Marque;
import com.voiture.gasicar.Service.MarqueService;

import java.util.List;

@RestController
@RequestMapping("/api/marques")
public class MarqueController {

    @Autowired
    private MarqueService marqueService;

    @GetMapping("/voir")
    public List<Marque> getAllMarques() {
        return marqueService.getAllMarques();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marque> getMarqueById(@PathVariable Integer id) {
        return marqueService.getMarqueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Marque> createMarque(@RequestBody Marque marque) {
        Marque createdMarque = marqueService.createMarque(marque);
        return ResponseEntity.ok(createdMarque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marque> updateMarque(@PathVariable Integer id, @RequestBody Marque updatedMarque) {
        Marque updated = marqueService.updateMarque(id, updatedMarque);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarque(@PathVariable Integer id) {
        marqueService.deleteMarque(id);
        return ResponseEntity.noContent().build();
    }
}

