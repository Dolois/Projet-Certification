package co.simplon.certification.controller;

import co.simplon.certification.model.Activite;
import co.simplon.certification.repository.ActiviteRepository;

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
@RequestMapping("/api/activite")
public class ActiviteController 
{
    @Autowired

    // Créer une instance nommée activiteRepo de ActiviteRepository
    private ActiviteRepository activiteRepo;

    // Lister toutes les activités sportives
    @GetMapping
    List<Activite> getAllActivite() 
    {
    	return activiteRepo.findAll();
    }

    // Lister une activité sportive par l'id
    @GetMapping("{id}")
    ResponseEntity<Activite> getActiviteById(@PathVariable(value = "id") long id) 
    {
        Activite activite = activiteRepo.getOne(id);

        if (activite == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(activite);
    }

    // Ajouter une activité sportive
    @PostMapping
    Activite addActivite(@Valid @RequestBody Activite activite) 
    {
        return activiteRepo.save(activite);
    }

    // Modifier une activité sportive par l'id
    @PutMapping("/{id}")
    ResponseEntity<Activite> updateActivite(@PathVariable(value = "id") long id, 
    										@Valid @RequestBody Activite activite) 
    {
        Activite activiteToUpdate = activiteRepo.getOne(id);

        // Si l'occurence est null alors id non trouvé 
        if (activiteToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut structure
        if (activite.getStructure() != null) 
        {
            activiteToUpdate.setStructure(activite.getStructure());
        }

        // mise a jour de l'attribut nom
        if (activite.getNom() != null) 
        {
            activiteToUpdate.setNom(activite.getNom());
        }

        // mise a jour de l'attribut adresse
        if (activite.getAdresse() != null) 
        {
            activiteToUpdate.setAdresse(activite.getAdresse());
        }
        
        // mise a jour de l'attribut ville
        if (activite.getVille() != null) 
        {
            activiteToUpdate.setVille(activite.getVille());
        }
        
        // mise a jour de l'attribut codepostal
        if (activite.getCodepostal() != null) 
        {
            activiteToUpdate.setCodepostal(activite.getCodepostal());
        }

        // mise a jour de l'attribut telephone
        if (activite.getTelephone() != null) 
        {
            activiteToUpdate.setTelephone(activite.getTelephone());
        }
        
        // mise a jour de l'attribut détail
        if (activite.getDetail() != null) 
        {
            activiteToUpdate.setDetail(activite.getDetail());
        }

        // mise a jour de l'attribut image
        if (activite.getImage() != null) 
        {
            activiteToUpdate.setImage(activite.getImage());
        }
        
        Activite updateActivite = activiteRepo.save(activiteToUpdate);

        return ResponseEntity.ok(updateActivite);
    }

    // Supprimer une activité sportive par l'id
    @DeleteMapping("/{id}")
    ResponseEntity<Activite> deleteMatch(@PathVariable(value = "id") long id) 
    {
        Activite activite = activiteRepo.getOne(id);

        if (activite == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression de l'activité sportive (id)
        activiteRepo.delete(activite);

        return ResponseEntity.ok().build();
    }
}