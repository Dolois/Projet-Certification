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

@CrossOrigin("http://localhost:")
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

        // mise a jour de l'attribut etablissement
        if (activite.getEtablissement() != null) 
        {
            activiteToUpdate.setEtablissement(activite.getEtablissement());
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
        
        // mise a jour de l'attribut jour_1
        if (activite.getJour_1() != null) 
        {
            activiteToUpdate.setJour_1(activite.getJour_1());
        }
        
        // mise a jour de l'attribut jour_2
        if (activite.getJour_2() != null) 
        {
            activiteToUpdate.setJour_2(activite.getJour_2());
        }
        
        // mise a jour de l'attribut jour_3
        if (activite.getJour_3() != null) 
        {
            activiteToUpdate.setJour_3(activite.getJour_3());
        }
        
        // mise a jour de l'attribut jour_4
        if (activite.getJour_4() != null) 
        {
            activiteToUpdate.setJour_4(activite.getJour_4());
        }
        
        // mise a jour de l'attribut jour_5
        if (activite.getJour_5() != null) 
        {
            activiteToUpdate.setJour_5(activite.getJour_5());
        }
        
        // mise a jour de l'attribut jour_6
        if (activite.getJour_6() != null) 
        {
            activiteToUpdate.setJour_6(activite.getJour_6());
        }
        
        // mise a jour de l'attribut jour_7
        if (activite.getJour_7() != null) 
        {
            activiteToUpdate.setJour_7(activite.getJour_7());
        }

        // mise a jour de l'attribut image
        if (activite.getImage() != null) 
        {
            activiteToUpdate.setImage(activite.getImage());
        }
        
        // mise a jour de l'attribut ref_discipline
        if (activite.getRef_discipline() != 0) 
        {
            activiteToUpdate.setRef_discipline(activite.getRef_discipline());
        }
        
        Activite updateActivite = activiteRepo.save(activiteToUpdate);

        return ResponseEntity.ok(updateActivite);
    }

    // Supprimer une activité sportive par l'id
    @DeleteMapping("/{id}")
    ResponseEntity<Activite> deleteActivite(@PathVariable(value = "id") long id) 
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