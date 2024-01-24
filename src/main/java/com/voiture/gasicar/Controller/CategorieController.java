package com.voiture.gasicar.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.gasicar.Model.Categorie;
import com.voiture.gasicar.Service.CategorieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/categorie")

public class CategorieController {

    
    @Autowired
    private CategorieService CategorieService;

    @GetMapping("/voir")
    public List<Categorie> getAllCategories() {
        return CategorieService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable int id) {
        return CategorieService.getCategorieById(id);
    }

    @PostMapping
    public Categorie saveCategorie(@RequestBody Categorie Categorie) {
        return CategorieService.saveCategorie(Categorie);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable int id) {
        CategorieService.deleteCategorie(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire

}
