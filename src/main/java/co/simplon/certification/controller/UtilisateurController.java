package co.simplon.certification.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.certification.model.Profil;
import co.simplon.certification.model.Utilisateur;
import co.simplon.certification.repository.UtilisateurRepository;

@CrossOrigin("http://localhost:")
@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController 
{
    @Autowired

    // Créer une instance nommée utilisateurRepo de UtilisateurRepository
    private UtilisateurRepository utilisateurRepo;

    // Lister tous les utilisateurs
    @GetMapping
    List<Utilisateur> getAllUtilisateur() 
    {
    	return utilisateurRepo.findAll();
    }
    
    // Lister un utilisateur par l'id
    @GetMapping("{id}")
    ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable(value = "id") long id) 
    {
        Utilisateur utilisateur = utilisateurRepo.getOne(id);

        if (utilisateur == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(utilisateur);
    }
    
    // Modifier un utilisateur par l'id
    @PutMapping("/{id}")
    ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id") long id, 
    										@Valid @RequestBody Utilisateur utilisateur) 
    {
        Utilisateur utilisateurToUpdate = utilisateurRepo.getOne(id);

        // Si l'occurence est null alors id non trouvé 
        if (utilisateurToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut email
        if (utilisateur.getEmail() != null) 
        {
            utilisateurToUpdate.setEmail(utilisateur.getEmail());
        }

        // mise a jour de l'attribut password
        if (utilisateur.getPassword() != null) 
        {
            utilisateurToUpdate.setPassword(utilisateur.getPassword());
        }
        
        Utilisateur updateUtilisateur = utilisateurRepo.save(utilisateurToUpdate);

        return ResponseEntity.ok(updateUtilisateur);
    }
    
    // Supprimer un utilisateur par l'id
    @DeleteMapping("/{id}")
    ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable(value = "id") long id) 
    {
        Utilisateur utilisateur = utilisateurRepo.getOne(id);

        if (utilisateur == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression d'un utilisateur par l'id
        utilisateurRepo.delete(utilisateur);

        return ResponseEntity.ok().build();
    }
}