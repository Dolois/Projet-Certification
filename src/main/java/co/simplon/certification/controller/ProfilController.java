package co.simplon.certification.controller;

import co.simplon.certification.model.Profil;
import co.simplon.certification.repository.ProfilRepository;

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

@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/profil")
public class ProfilController 
{
    @Autowired

    // Créer une instance nommée profilRepo de ProfilRepository
    private ProfilRepository profilRepo;

    // Lister tous les profils
    @GetMapping
    List<Profil> getAllProfil() 
    {
    	return profilRepo.findAll();
    }

    // Lister un profil par l'id
    @GetMapping("{id}")
    ResponseEntity<Profil> getProfilById(@PathVariable(value = "id") long id) 
    {
        Profil profil = profilRepo.getOne(id);

        if (profil == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(profil);
    }

    // Ajouter un profil
    @PostMapping
    Profil addProfil(@Valid @RequestBody Profil profil) 
    {
        return profilRepo.save(profil);
    }
    
    // Modifier un profil par l'id
    @PutMapping("/{id}")
    ResponseEntity<Profil> updateProfil(@PathVariable(value = "id") long id, 
    										@Valid @RequestBody Profil profil) 
    {
        Profil profilToUpdate = profilRepo.getOne(id);

        // Si l'occurence est null alors id non trouvé 
        if (profilToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut nom
        if (profil.getNom() != null) 
        {
            profilToUpdate.setNom(profil.getNom());
        }

        // mise a jour de l'attribut prenom
        if (profil.getPrenom() != null) 
        {
            profilToUpdate.setPrenom(profil.getPrenom());
        }

        // mise a jour de l'attribut sexe
        if (profil.getSexe() != null) 
        {
            profilToUpdate.setSexe(profil.getSexe());
        }
        
        // mise a jour de l'attribut role (utilisateur, organisateur, administrateur)
        if (profil.getRole() != null) 
        {
            profilToUpdate.setRole(profil.getRole());
        }

        // mise a jour de l'attribut telephone
        if (profil.getTelephone() != null) 
        {
            profilToUpdate.setTelephone(profil.getTelephone());
        }
        
        // mise a jour de l'attribut discipline_1
        if (profil.getDiscipline_1() != null) 
        {
            profilToUpdate.setDiscipline_1(profil.getDiscipline_1());
        }
        
        // mise a jour de l'attribut discipline_2
        if (profil.getDiscipline_2() != null) 
        {
            profilToUpdate.setDiscipline_2(profil.getDiscipline_2());
        }
        
        // mise a jour de l'attribut discipline_3
        if (profil.getDiscipline_3() != null) 
        {
            profilToUpdate.setDiscipline_3(profil.getDiscipline_3());
        }

        // mise a jour de l'attribut photo
        if (profil.getPhoto() != null) 
        {
            profilToUpdate.setPhoto(profil.getPhoto());
        }
        
        // mise a jour de l'attribut ref_utilisateur
        if (profil.getRef_utilisateur() != 0) 
        {
            profilToUpdate.setRef_utilisateur(profil.getRef_utilisateur());
        }
        
        Profil updateProfil = profilRepo.save(profilToUpdate);

        return ResponseEntity.ok(updateProfil);
    }

    // Supprimer une activité sportive par l'id
    @DeleteMapping("/{id}")
    ResponseEntity<Profil> deleteProfil(@PathVariable(value = "id") long id) 
    {
        Profil profil = profilRepo.getOne(id);

        if (profil == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression d'un profil par l'id
        profilRepo.delete(profil);

        return ResponseEntity.ok().build();
    }
}