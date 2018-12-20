package co.simplon.certification.controller;

import co.simplon.certification.model.User;
import co.simplon.certification.repository.UserRepository;

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
 * The Class UserController.
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/user")

public class UserController 
{
    
    /** The user repo. */
    @Autowired

    /** Creer une instance nommee utilisateurRepo de UtilisateurRepository */
    private UserRepository userRepo;

    /**
     * Gets the all user.
     *
     * @return the all user
     */
    @GetMapping
    List<User> getAllUser() 
    {
    	return userRepo.findAll();
    }
    
    /**
     * Gets the user by id.
     *
     * @param id the id
     * @return the user by id
     */
    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable long id) 
    {
        User user = userRepo.getOne(id);

        if (user == null) 
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user);
    }
    
    /**
     * Adds the user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping
    User addUser(@Valid @RequestBody User user) 
    {
        return userRepo.save(user);
    }
    
    /**
     * Update user.
     *
     * @param id the id
     * @param user the user
     * @return the response entity
     */
    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable(value = "id") long id, 
    								@Valid @RequestBody User user) 
    {
        User userToUpdate = userRepo.getOne(id);

        // Si l'occurence est null alors id non trouvé 
        if (userToUpdate == null) 
        {
            return ResponseEntity.notFound().build();
        }

        // mise a jour de l'attribut email
        if (user.getEmail() != null) 
        {
            userToUpdate.setEmail(user.getEmail());
        }

        // mise a jour de l'attribut password
        if (user.getPassword() != null) 
        {
            userToUpdate.setPassword(user.getPassword());
        }
        
        User updateUser = userRepo.save(userToUpdate);

        return ResponseEntity.ok(updateUser);
    }
    
    /**
     * Delete user.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    ResponseEntity<User> deleteUser(@PathVariable(value = "id") long id) 
    {
        User user = userRepo.getOne(id);

        if (user == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        // Suppression d'un utilisateur par l'id
        userRepo.delete(user);

        return ResponseEntity.ok().build();
    }
}