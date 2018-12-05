package co.simplon.certification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.certification.model.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long>
{
	// <ctrl> + <space> pour la liste de toutes les méthodes

	// signature(s) de(s) méthode(s)

	// public List<Activite> findByVilleEquals();
} 