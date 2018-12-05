package co.simplon.certification.controller;

import co.simplon.certification.model.Activite;
import co.simplon.certification.model.Reservation;
import co.simplon.certification.repository.ReservationRepository;

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

//Signaler que les URL sont des embranchements
//Fusion de l'annotation Controller et response body
//Toutes les requetes arrivant sur api/activite viendront sur ce controller.
//
//Cette classe contient juste le traitement sur les URL qu'elle reçoit et
//passera en argument de methode une partie du contenu de l'url
//grace à @PathVariable pour parser a nouveau dans un type java

//Mettre en commentaire @CrossOrigin("http://localhost:4200")
//pour effectuer des tests de vos méthodes CRUD avec Postman
//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/reservation")
public class ReservationController 
{
    @Autowired

    // Créer une instance nommée reservationRepo de ReservationRepository
    private ReservationRepository reservationRepo;

    // Lister toutes les réservations
    @GetMapping
    List<Reservation> getAllReservation() 
    {
    	return reservationRepo.findAll();
    }
    
    // Lister une réservation par l'id
    @GetMapping("/{id}")
    ResponseEntity<Reservation> getReservationById(@PathVariable(value = "id") long id) 
    {
        Reservation reservation = reservationRepo.getOne(id);

        if (reservation == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(reservation);
    }
    
    // Ajouter une réservation d'une activite sportive
    @PostMapping
    Reservation addReservation(@Valid @RequestBody Reservation reservation) 
    {
        return reservationRepo.save(reservation);
    }
    
    // Modifier une reservation par l'id
    @PutMapping("/{id}")
    ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") long id, 
    										@Valid @RequestBody Reservation reservation) 
    {
        Reservation reservationToUpdate = reservationRepo.getOne(id);

        // Si l'occurence est null alors id non trouvé 
        if (reservationToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut date
        if (reservation.getDate() != null) 
        {
            reservationToUpdate.setDate(reservation.getDate());
        }

        // mise a jour de l'attribut heure de début
        if (reservation.getHeure_debut() != null) 
        {
            reservationToUpdate.setHeure_debut(reservation.getHeure_debut());
        }
        
        // mise a jour de l'attribut heure de fin
        if (reservation.getHeure_fin() != null) 
        {
            reservationToUpdate.setHeure_fin(reservation.getHeure_fin());
        }
        
        // mise a jour de la durée 
        if (reservation.getDuree() != 0)
        {
        	reservationToUpdate.setDuree(reservation.getDuree());
        }
        
        Reservation updateReservation = reservationRepo.save(reservationToUpdate);

        return ResponseEntity.ok(updateReservation);
    }
    
    // Supprimer une réservation par l'id
    @DeleteMapping("/{id}")
    ResponseEntity<Reservation> deleteReservation(@PathVariable(value = "id") long id) 
    {
        Reservation reservation = reservationRepo.getOne(id);

        if (reservation == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression d'une reservation par l'id
        reservationRepo.delete(reservation);

        return ResponseEntity.ok().build();
    }
}