package co.simplon.certification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.certification.model.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long>
{
	// <ctrl> + <space> pour la liste de toutes les méthodes
	
	// signature(s) de(s) méthode(s)
	
	//List<Activite> findActiviteById(Long id);
	List<Activite> findActiviteByVille(String ville);
} 