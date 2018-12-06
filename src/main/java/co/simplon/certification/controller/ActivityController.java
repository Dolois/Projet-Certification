package co.simplon.certification.controller;

import co.simplon.certification.model.Activity;
import co.simplon.certification.repository.ActivityRepository;

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

// Signaler que les URL sont des embranchements
// Fusion de l'annotation Controller et response body
//Toutes les requetes arrivant sur api/activite viendront sur ce controller.
//
//Cette classe contient juste le traitement sur les URL qu'elle reçoit et
//passera en argument de methode une partie du contenu de l'url
//grace à @PathVariable pour parser a nouveau dans un type java


// Mettre en commentaire @CrossOrigin("http://localhost:4200")
// pour effectuer des tests de vos méthodes CRUD avec Postman 
@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/activity")

public class ActivityController 
{
	// Injection de dépendance JPA
	// grace à l'annotation Autowired et 
	// l'utilisation d'un constructeur
    @Autowired
    
    // Création d'une instance nommé activityRepo 
    // de l'interface ActivityRepository
    private ActivityRepository activityRepo;
    
	// retourne une liste du résultat de la requête select * from activity
    @GetMapping
    // Méthode GetAllActivities() 
    // pour toutes les instances Activity présentes dans notre Repository
    // @return List<Activity> via activityRepo.findAll()
    List<Activity> getAllActivities()
    {
    	return activityRepo.findAll();
    }

    // Retourne une activité sportive par l'id
    @GetMapping("/{id}")
    ResponseEntity<Activity> getActivityById(@PathVariable long id) 
    {
        Activity activity = activityRepo.getOne(id);

        if (activity == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(activity);
    }
    
    /*
    // Retourne une liste d'activité sportive d'une ville
    @GetMapping("/ville")
    List<Activite> getActiviteByCity() 
    {
    	return activiteRepo.findByVilleEquals();
    }
    */
    
    // Ajouter une activité sportive
    @PostMapping
    Activity addActivity(@Valid @RequestBody Activity activity) 
    {
        return activityRepo.save(activity);
    }

    // Modifier une activité sportive par l'id
    @PutMapping("/{id}")
    ResponseEntity<Activity> updActivityById(@PathVariable(value = "id") long id, 
    										@Valid @RequestBody Activity activity) 
    {
        Activity activityToUpdate = activityRepo.getOne(id);

        // Si l'occurence est null alors id non trouvé 
        if (activityToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut etablissement
        if (activity.getEtablissement() != null) 
        {
            activityToUpdate.setEtablissement(activity.getEtablissement());
        }

        // mise a jour de l'attribut nom
        if (activity.getNom() != null) 
        {
            activityToUpdate.setNom(activity.getNom());
        }

        // mise a jour de l'attribut adresse
        if (activity.getAdresse() != null) 
        {
            activityToUpdate.setAdresse(activity.getAdresse());
        }
        
        // mise a jour de l'attribut ville
        if (activity.getVille() != null) 
        {
            activityToUpdate.setVille(activity.getVille());
        }
        
        // mise a jour de l'attribut codepostal
        if (activity.getCodepostal() != null) 
        {
            activityToUpdate.setCodepostal(activity.getCodepostal());
        }

        // mise a jour de l'attribut telephone
        if (activity.getTelephone() != null) 
        {
            activityToUpdate.setTelephone(activity.getTelephone());
        }
        
        // mise a jour de l'attribut jour_1
        if (activity.getJour_1() != null) 
        {
            activityToUpdate.setJour_1(activity.getJour_1());
        }
        
        // mise a jour de l'attribut jour_2
        if (activity.getJour_2() != null) 
        {
            activityToUpdate.setJour_2(activity.getJour_2());
        }
        
        // mise a jour de l'attribut jour_3
        if (activity.getJour_3() != null) 
        {
            activityToUpdate.setJour_3(activity.getJour_3());
        }
        
        // mise a jour de l'attribut jour_4
        if (activity.getJour_4() != null) 
        {
            activityToUpdate.setJour_4(activity.getJour_4());
        }
        
        // mise a jour de l'attribut jour_5
        if (activity.getJour_5() != null) 
        {
            activityToUpdate.setJour_5(activity.getJour_5());
        }
        
        // mise a jour de l'attribut jour_6
        if (activity.getJour_6() != null) 
        {
            activityToUpdate.setJour_6(activity.getJour_6());
        }
        
        // mise a jour de l'attribut jour_7
        if (activity.getJour_7() != null) 
        {
            activityToUpdate.setJour_7(activity.getJour_7());
        }

        // mise a jour de l'attribut image
        if (activity.getImage() != null) 
        {
            activityToUpdate.setImage(activity.getImage());
        }
        
        Activity updateActivity = activityRepo.save(activityToUpdate);

        return ResponseEntity.ok(updateActivity);
    }

    // Supprimer une activité sportive par l'id
    @DeleteMapping("/{id}")
    ResponseEntity<Activity> delActivityById(@PathVariable(value = "id") long id) 
    {
        Activity activity = activityRepo.getOne(id);

        if (activity == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression de l'activité sportive (id)
        activityRepo.delete(activity);

        return ResponseEntity.ok().build();
    }
}