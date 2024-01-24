package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Pays;
import com.voiture.gasicar.Service.PaysService;

import java.util.List;

@RestController
@RequestMapping("/api/pays")
public class PaysController {

    @Autowired
    private PaysService paysService;

    @GetMapping
    public List<Pays> getAllPays() {
        return paysService.getAllPays();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pays> getPaysById(@PathVariable Integer id) {
        return paysService.getPaysById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pays> createPays(@RequestBody Pays pays) {
        Pays createdPays = paysService.createPays(pays);
        return ResponseEntity.ok(createdPays);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pays> updatePays(@PathVariable Integer id, @RequestBody Pays updatedPays) {
        Pays updated = paysService.updatePays(id, updatedPays);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePays(@PathVariable Integer id) {
        paysService.deletePays(id);
        return ResponseEntity.noContent().build();
    }
}

