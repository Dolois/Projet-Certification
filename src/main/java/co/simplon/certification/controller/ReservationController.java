package co.simplon.certification.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.certification.model.Reservation;
import co.simplon.certification.model.Utilisateur;
import co.simplon.certification.repository.ReservationRepository;

//@CrossOrigin("http://localhost:")
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
    @GetMapping("{id}")
    ResponseEntity<Reservation> getReservationById(@PathVariable(value = "id") long id) 
    {
        Reservation reservation = reservationRepo.getOne(id);

        if (reservation == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(reservation);
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

        // mise a jour de l'attribut heure
        if (reservation.getHeure() != null) 
        {
            reservationToUpdate.setHeure(reservation.getHeure());
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