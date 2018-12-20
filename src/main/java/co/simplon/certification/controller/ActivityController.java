package co.simplon.certification.controller;

import co.simplon.certification.model.Activity;
import co.simplon.certification.model.Place;
import co.simplon.certification.repository.ActivityRepository;
import co.simplon.certification.repository.PlaceRepository;

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

// TODO: Auto-generated Javadoc
/**
 * The Class ActivityController.
 */
@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/activity")

public class ActivityController 
{
    
    /** The activity repo. */
    /** permet d'injecter ActivityRepository dans mon contrôleur */
    @Autowired
    /** Creer une instance nommee activityRepo de ActivityRepository */
    private ActivityRepository activityRepo;
    
    /** The place repo. */
    @Autowired
    /* Creer une instance nommee placeRepo de PlaceRepository */
    private PlaceRepository placeRepo;
    
    /**
     * Gets the all activity.
     *
     * @return the all activity
     */
    @GetMapping
    List<Activity> getAllActivity() 
    {
    	return activityRepo.findAll();
    }
    
    /**
     * Gets the activity by id.
     *
     * @param id the id
     * @return the activity by id
     */
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

    /**
     * Adds the activity.
     *
     * @param activity the activity
     * @return the activity
     */
    @PostMapping 
    /** @RequestBody me permet dans mon URL de recuperer un objet 
     *  de type Json que je parse en type de mon argument de methode
     *  qui est pour ce cas un de mes modeles.
     *  @Valid = validation au @RequestBody
     */ 
    Activity addActivity(@Valid @RequestBody Activity activity) 
    {
        return activityRepo.save(activity);
    }
    
    
    /** ajouter une activite en la liant a un lieu
     *  ===============================================
     *  Ajouter une activite suivante avec Postman :
     *  test de ma méthode addActivity
     *  POST : localhost:8080/api/activity/activity/place/1
     * ===============================================
     */
    
    /**
     * Post activity by id place.
     *
     * @param id the id
     * @param activity the activity
     * @return the activity
     */
    @PostMapping("/activity/place/{id}")
    Activity addActivityByIdPlace(@PathVariable(value = "id") long id,
    		@Valid @RequestBody Activity activity) 
    {
    	/** Apres l'injection du repository de Place
    	 * pour disposer des dependances Jpa de Place
    	 * je recupere mon place_id et ses attributs
    	 */
    	Place place = placeRepo.getOne(id);
    	
    	/** Je lie les entites Activity et place 
    	 * grave aux relations OneToMany et ManyToOne 
    	 * dans leur modeles des deux objets
    	 */
    	activity.setPlace(place);
    	
    	return activityRepo.save(activity);
    }
    
    /**
     * Update activity.
     *
     * @param id the id
     * @param activity the activity
     * @return the response entity
     */
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

        // mise a jour de l'attribut acivite
        if (activity.getActivity() != null) 
        {
            activityToUpdate.setActivity(activity.getActivity());
        }

        // mise a jour de l'attribut horaire de début
        if (activity.getStartTime() != 0) 
        {
            activityToUpdate.setStartTime(activity.getStartTime());
        }
        
        // mise a jour de l'attribut horaire de fin
        if (activity.getEndTime() != 0) 
        {
            activityToUpdate.setEndTime(activity.getEndTime());
        }
        
        // retourne l'objet Activity avec tous ses attributs
        Activity updateActivity = activityRepo.save(activityToUpdate);

        return ResponseEntity.ok(updateActivity);
    }
    
    /**
     * Delete activity.
     *
     * @param id the id
     * @return the response entity
     */
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