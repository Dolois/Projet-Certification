package co.simplon.certification.controller;

import co.simplon.certification.model.Discipline;
import co.simplon.certification.repository.DisciplineRepository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin("http://localhost:")
@RestController
@RequestMapping("/api/discipline")
public class DisciplineController 
{
    //permet d'injecter DisciplineRepository dans mon contrôleur
    @Autowired

    // Créer une instance nommée disciplineRepo de DisciplineRepository
    private DisciplineRepository disciplineRepo;
    
    // Lister toutes les disciplines
    @GetMapping
    // Méthode GetAllDiscipline() 
    // pour toutes les instances Discipline présentes dans notre Repository
    // @return List<Discipline> via disciplineRepo.findAll()
    List<Discipline> getAllDiscipline() 
    {
    	return disciplineRepo.findAll();
    }
    
    // Lister une discipline par l'id
    @GetMapping("{id}")
    ResponseEntity<Discipline> getDisciplineById(@PathVariable(value = "id") long id) 
    {
        Discipline discipline = disciplineRepo.getOne(id);

        if (discipline == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(discipline);
    }
    
    // Ajouter une discipline
    @PostMapping
    Discipline addDiscipline(@Valid @RequestBody Discipline discipline) 
    {
        return disciplineRepo.save(discipline);
    }
    
    // Modifier une discipline par l'id
    @PutMapping("/{id}")
    ResponseEntity<Discipline> updateDiscipline(@PathVariable(value = "id") long id, 
    										@Valid @RequestBody Discipline discipline) 
    {
        Discipline disciplineToUpdate = disciplineRepo.getOne(id);

        // Si l'occurence est null alors id non trouvé 
        if (disciplineToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut discipline
        if (discipline.getDiscipline() != null) 
        {
            disciplineToUpdate.setDiscipline(discipline.getDiscipline());
        }

        // mise a jour de l'attribut horaire
        if (discipline.getHoraire() != null) 
        {
            disciplineToUpdate.setHoraire(discipline.getHoraire());
        }
        
        // mise a jour de l'attribut ref_activite
        if (discipline.getRef_activite() != 0) 
        {
            disciplineToUpdate.setRef_activite(discipline.getRef_activite());
        }
        
        Discipline updateDiscipline = disciplineRepo.save(disciplineToUpdate);

        return ResponseEntity.ok(updateDiscipline);
    }
    
    // Supprimer une discipline par l'id
    @DeleteMapping("/{id}")
    ResponseEntity<Discipline> deleteDiscipline(@PathVariable(value = "id") long id) 
    {
        Discipline discipline = disciplineRepo.getOne(id);

        if (discipline == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression d'une discipline par l'id
        disciplineRepo.delete(discipline);

        return ResponseEntity.ok().build();
    }
}