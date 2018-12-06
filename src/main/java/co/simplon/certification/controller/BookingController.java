package co.simplon.certification.controller;

import co.simplon.certification.model.Activity;
import co.simplon.certification.model.Booking;
import co.simplon.certification.repository.BookingRepository;

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

// Signaler que les URI sont des embranchements
// Fusion de l'annotation Controller et response body
// Toutes les requetes arrivant sur api/activite viendront sur ce controller.
//
// Cette classe contient juste le traitement sur les URL qu'elle reçoit et
// passera en argument de methode une partie du contenu de l'url
// grace à @PathVariable pour parser a nouveau dans un type java

// Mettre en commentaire @CrossOrigin("http://localhost:4200")
// pour effectuer des tests de vos méthodes CRUD avec Postman
@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/booking")
public class BookingController 
{
    @Autowired

    // Créer une instance nommée bookingRepo de BookingRepository
    private BookingRepository bookingRepo;

    // Lister toutes les réservations
    @GetMapping
    List<Booking> getAllBooking() 
    {
    	return bookingRepo.findAll();
    }
    
    // Lister une réservation par l'id
    @GetMapping("/{id}")
    ResponseEntity<Booking> getBookingById(@PathVariable(value = "id") long id) 
    {
        Booking booking = bookingRepo.getOne(id);

        if (booking == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(booking);
    }
    
    // Ajouter une réservation d'une activite sportive
    @PostMapping
    Booking addBooking(@Valid @RequestBody Booking booking) 
    {
        return bookingRepo.save(booking);
    }
    
    // Modifier une reservation par l'id
    @PutMapping("/{id}")
    ResponseEntity<Booking> updateBooking(@PathVariable(value = "id") long id, 
    									  @Valid @RequestBody Booking booking) 
    {
        Booking bookingToUpdate = bookingRepo.getOne(id);

        // Si l'occurence est null alors id non trouvé 
        if (bookingToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut date
        if (booking.getDate() != null) 
        {
            bookingToUpdate.setDate(booking.getDate());
        }

        // mise a jour de l'attribut heure de début
        if (booking.getHeure_debut() != null) 
        {
            bookingToUpdate.setHeure_debut(booking.getHeure_debut());
        }
        
        // mise a jour de l'attribut heure de fin
        if (booking.getHeure_fin() != null) 
        {
            bookingToUpdate.setHeure_fin(booking.getHeure_fin());
        }
        
        // mise a jour de la durée 
        if (booking.getDuree() != 0)
        {
        	bookingToUpdate.setDuree(booking.getDuree());
        }
        
        Booking updateBooking = bookingRepo.save(bookingToUpdate);

        return ResponseEntity.ok(updateBooking);
    }
    
    // Supprimer une réservation par l'id
    @DeleteMapping("/{id}")
    ResponseEntity<Booking> deleteBooking(@PathVariable(value = "id") long id) 
    {
        Booking booking = bookingRepo.getOne(id);

        if (booking == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression d'une reservation par l'id
        bookingRepo.delete(booking);

        return ResponseEntity.ok().build();
    }
}