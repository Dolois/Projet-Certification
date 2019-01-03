package co.simplon.certification.controller;

import co.simplon.certification.model.Activity;
import co.simplon.certification.model.Place;
import co.simplon.certification.repository.PlaceRepository;

import java.util.List;
import java.util.Optional;

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
/** Signaler que les URL sont des embranchements
 * Fusion de l'annotation Controller et response body
 * Toutes les requetes arrivant sur api/activite viendront sur ce controller.
 *
 * Cette classe contient juste le traitement sur les URL qu'elle reçoit et
 * passera en argument de methode une partie du contenu de l'url
 * grace à @PathVariable pour parser a nouveau dans un type java
 */

/** Mettre en commentaire @CrossOrigin("http://localhost:4200")
 * pour effectuer des tests de vos méthodes CRUD avec Postman
 */ 
@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/place")

public class PlaceController 
{
	
	/**  
	 * Injection de dependance JPA 
	 * grace à l'annotation @Autowired du framework Spring 
	 * et l'utilisation d'un constructeur. 
	 * 
	 */
    @Autowired
    
    /** 
     * Creation d'une instance nommee activityRepo 
     * de l'interface ActivityRepository
     */
    private PlaceRepository placeRepo;
    
    /**
     * Retourne une liste de lieux avec Postman :
     * test de ma methode getAllPlaces
     * Get : localhost:8080/api/place.
     *
     * @return the all places
     */
    @GetMapping
    List<Place> getAllPlaces()
    {
    	return placeRepo.findAll();
    }
    
    /**
     * Retourne une liste d'activites avec l'objet lieu avec Postman :
     * test de ma methode getAllActivitiesByPlace
     * Get : localhost:8080/api/place/activities/1.
     *
     * @param id the id
     * @return the all activities by place
     */
    @GetMapping("/activities/{id}")
    List<Activity> getAllActivitiesByPlace(@PathVariable(value="id") long id)
    {
    	Place place = placeRepo.getOne(id);
    	return place.getActivities();
    }
    
    /**
     * Recuperer un lieu avec Postman :
     * test de ma methode getPlaceById
     * Get : localhost:8080/api/place/1.
     *
     * @param id the id
     * @return the place by id
     */
    @GetMapping("/{id}")
    Optional<Place> getPlaceById(@PathVariable(value="id") long id)
    {
    	return placeRepo.findById(id);
    }

    /**
     * Ajouter un lieu avec Postman :
     * test de ma methode addPlace
     * Post : localhost:8080/api/place.
     *
     * @param place the place
     * @return the place
     */
    @PostMapping
    Place addPlace(@Valid @RequestBody Place place) 
    {
        return placeRepo.save(place);
    }

    /**
     * Modifier un lieu avec Postman :
     * test de ma methode updPlaceById
     * Put : localhost:8080/api/place/1.
     *
     * @param id the id
     * @param place the place
     * @return the response entity
     */
    @PutMapping("/{id}")
    ResponseEntity<Place> updPlaceById(@PathVariable(value = "id") long id, 
    										@Valid @RequestBody Place place) 
    {
        Place placeToUpdate = placeRepo.getOne(id);

        // Si l'occurence est null alors id non trouve 
        if (placeToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut etablissement
        if (place.getPlace() != null) 
        {
            placeToUpdate.setPlace(place.getPlace());
        }

        // mise a jour de l'attribut nom
        if (place.getName() != null) 
        {
            placeToUpdate.setName(place.getName());
        }

        // mise a jour de l'attribut adresse
        if (place.getAddress() != null) 
        {
            placeToUpdate.setAddress(place.getAddress());
        }
        
        // mise a jour de l'attribut ville
        if (place.getCity() != null) 
        {
            placeToUpdate.setCity(place.getCity());
        }
        
        // mise a jour de l'attribut codepostal
        if (place.getZipCode() != null) 
        {
            placeToUpdate.setZipCode(place.getZipCode());
        }

        // mise a jour de l'attribut telephone
        if (place.getPhone() != null) 
        {
            placeToUpdate.setPhone(place.getPhone());
        }
        
        // mise a jour de l'attribut jour_1
        if (place.getMonday() != null) 
        {
            placeToUpdate.setMonday(place.getMonday());
        }
        
        // mise a jour de l'attribut jour_2
        if (place.getTuesday() != null) 
        {
            placeToUpdate.setTuesday(place.getTuesday());
        }
        
        // mise a jour de l'attribut jour_3
        if (place.getWednesday() != null) 
        {
            placeToUpdate.setWednesday(place.getWednesday());
        }
        
        // mise a jour de l'attribut jour_4
        if (place.getThursday() != null) 
        {
            placeToUpdate.setThursday(place.getThursday());
        }
        
        // mise a jour de l'attribut jour_5
        if (place.getFriday() != null) 
        {
            placeToUpdate.setFriday(place.getFriday());
        }
        
        // mise a jour de l'attribut jour_6
        if (place.getSaturday() != null) 
        {
            placeToUpdate.setSaturday(place.getSaturday());
        }
        
        // mise a jour de l'attribut jour_7
        if (place.getSunday() != null)
        {
            placeToUpdate.setSunday(place.getSunday());
        }

        // mise a jour de l'attribut image
        if (place.getImage() != null) 
        {
            placeToUpdate.setImage(place.getImage());
        }

        // mise a jour de l'attribut longitude
        if (place.getLongitude() != 0) 
        {
            placeToUpdate.setLongitude(place.getLongitude());
        }
        
        // mise a jour de l'attribut latitude
        if (place.getLatitude() != 0) 
        {
            placeToUpdate.setLatitude(place.getLatitude());
        }
        
        Place updatePlace = placeRepo.save(placeToUpdate);

        return ResponseEntity.ok(updatePlace);
    }

    /**
     * Supprimer un lieu avec Postman :
     * test de ma methode deletePlaceById
     * Delete : localhost:8080/api/place/1.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Place> delPlaceById(@PathVariable(value = "id") long id) 
    {
        Place place = placeRepo.getOne(id);

        if (place == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression de l'activité sportive (id)
        placeRepo.delete(place);

        return ResponseEntity.ok().build();
    }
}