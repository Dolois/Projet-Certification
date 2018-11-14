package co.simplon.certification.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.certification.model.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long>
{
	// <ctrl> + <space> pour la liste de toutes les methodes
	
	// signature(s) de(s) methode(s)
	
	// grace a l'inplementation de JpaRepository, 
	// spring permet de recuperer tous les occurences a la date du jour
	//
	// equivalent select * from activite where date = 'date du jour'
	List<Activite> findByDate(LocalDate date);
	
	// equivalent select * from activite where structure = 'stade'
	List<Activite> findByStructure(String structure);
	
	// equivalent select * from activite where ville = 'pessac'
	List<Activite> findByVille(String ville);
}