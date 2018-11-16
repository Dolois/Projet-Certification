package co.simplon.certification.controller;

import co.simplon.certification.model.Discipline;
import co.simplon.certification.repository.DisciplineRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/discipline")
public class DisciplineController 
{
    //permet d'injecter DisciplineRepository dans mon contrôleur
    @Autowired

    // Créer une instance nommée disciplineRepo de DisciplineRepository
    private DisciplineRepository disciplineRepo;
    
    @GetMapping
    // Méthode GetAllDiscipline() 
    // pour toutes les instances Discipline présentes dans notre Repository
    // @return List<Discipline> via disciplineRepo.findAll()
    List<Discipline> getAllDiscipline() 
    {
    	return disciplineRepo.findAll();
    }
}
