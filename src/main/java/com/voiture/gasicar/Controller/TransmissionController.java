package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Transmission;
import com.voiture.gasicar.Service.TransmissionService;

import java.util.List;

@RestController
@RequestMapping("/api/transmission")
public class TransmissionController {

    @Autowired
    private TransmissionService transmissionService;

    @GetMapping("/voir")
    public List<Transmission> getAllTransmissions() {
        return transmissionService.getAllTransmissions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transmission> getTransmissionById(@PathVariable Integer id) {
        return transmissionService.getTransmissionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transmission> createTransmission(@RequestBody Transmission transmission) {
        Transmission createdTransmission = transmissionService.createTransmission(transmission);
        return ResponseEntity.ok(createdTransmission);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transmission> updateTransmission(@PathVariable Integer id, @RequestBody Transmission updatedTransmission) {
        Transmission updated = transmissionService.updateTransmission(id, updatedTransmission);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransmission(@PathVariable Integer id) {
        transmissionService.deleteTransmission(id);
        return ResponseEntity.noContent().build();
    }
}

