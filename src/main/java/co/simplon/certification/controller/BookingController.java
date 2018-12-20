package co.simplon.certification.controller;

import co.simplon.certification.model.Place;
import co.simplon.certification.model.User;
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

// TODO: Auto-generated Javadoc

/** Signaler que les URI sont des embranchements 
 * Fusion de l'annotation Controller et response body
 * Toutes les requetes arrivant sur api/activite viendront sur ce controller.
 *
 * Cette classe contient juste le traitement sur les URL qu'elle reçoit et
 * passera en argument de methode une partie du contenu de l'url
 * grace à @PathVariable pour parser a nouveau dans un type java
 *
 * Mettre en commentaire pour effectuer vos tests 
 * de vos méthodes CRUD avec Postman 
 * @CrossOrigin("http://localhost:4200")
 */

/**
 * The Class BookingController.
 */
@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/booking")
public class BookingController 
{
    
    /** The booking repo. */
    @Autowired

    /** Creer une instance nommee bookingRepo de BookingRepository */
    private BookingRepository bookingRepo;

    /**
     * Gets the all booking.
     *
     * @return the all booking
     */
    @GetMapping
    List<Booking> getAllBooking() 
    {
    	return bookingRepo.findAll();
    }
    
    /**
     * Gets the booking by id.
     *
     * @param id the id
     * @return the booking by id
     */
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
    
    /**
     * Adds the booking.
     *
     * @param booking the booking
     * @return the booking
     */
    @PostMapping
    Booking addBooking(@Valid @RequestBody Booking booking) 
    {
        return bookingRepo.save(booking);
    }
    
    /**
     * Update booking.
     *
     * @param id the id
     * @param booking the booking
     * @return the response entity
     */
    @PutMapping("/{id}")
    ResponseEntity<Booking> updateBooking(@PathVariable(value = "id") long id, 
    									  @Valid @RequestBody Booking booking) 
    {
        Booking bookingToUpdate = bookingRepo.getOne(id);

        /** Si l'occurence est null alors id non trouve */
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
        if (booking.getStartTime() != null) 
        {
            bookingToUpdate.setStartTime(booking.getStartTime());
        }
        
        // mise a jour de l'attribut heure de fin
        if (booking.getEndTime() != null) 
        {
            bookingToUpdate.setEndTime(booking.getEndTime());
        }
        
        // mise a jour de la duree 
        if (booking.getDuration() != 0)
        {
        	bookingToUpdate.setDuration(booking.getDuration());
        }
        
        Booking updateBooking = bookingRepo.save(bookingToUpdate);

        return ResponseEntity.ok(updateBooking);
    }
    
    /**
     * Delete booking.
     *
     * @param id the id
     * @return the response entity
     */
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