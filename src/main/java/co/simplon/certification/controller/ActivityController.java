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

@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/activity")

public class ActivityController 
{
    //permet d'injecter DisciplineRepository dans mon contrôleur
    @Autowired

    // Créer une instance nommée disciplineRepo de DisciplineRepository
    private ActivityRepository activityRepo;
    
    // Lister toutes les disciplines
    @GetMapping
    // Méthode GetAllDiscipline() 
    // pour toutes les instances Discipline présentes dans notre Repository
    // @return List<Discipline> via disciplineRepo.findAll()
    List<Activity> getAllActivity() 
    {
    	return activityRepo.findAll();
    }
    
    // Lister une discipline par l'id
    @GetMapping("/{id}")
    ResponseEntity<Activity> getActivityById(@PathVariable(value = "id") long id) 
    {
        Activity activity = activityRepo.getOne(id);

        if (activity == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(activity);
    }
    
    // Ajouter une discipline
    @PostMapping
    Activity addActivity(@Valid @RequestBody Activity activity) 
    {
        return activityRepo.save(activity);
    }
    
    // Modifier une discipline par l'id
    @PutMapping("/{id}")
    ResponseEntity<Activity> updateActivity(@PathVariable(value = "id") long id, 
    										@Valid @RequestBody Activity activity) 
    {
        Activity activityToUpdate = activityRepo.getOne(id);

        // Si l'occurence est null alors id non trouvé 
        if (activityToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut discipline
        if (activity.getActivity() != null) 
        {
            activityToUpdate.setActivity(activity.getActivity());
        }

        // mise a jour de l'attribut horaire de début
        if (activity.getStartTime() != null) 
        {
            activityToUpdate.setStartTime(activity.getStartTime());
        }
        
        // mise a jour de l'attribut horaire de fin
        if (activity.getEndTime() != null) 
        {
            activityToUpdate.setEndTime(activity.getEndTime());
        }
        
        // retourne l'objet Activity avec tous ses attributs
        Activity updateActivity = activityRepo.save(activityToUpdate);

        return ResponseEntity.ok(updateActivity);
    }
    
    // Supprimer une discipline par l'id
    @DeleteMapping("/{id}")
    ResponseEntity<Activity> deleteActivity(@PathVariable(value = "id") long id) 
    {
        Activity activity = activityRepo.getOne(id);

        if (activity == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression d'une discipline par l'id
        activityRepo.delete(activity);

        return ResponseEntity.ok().build();
    }
}