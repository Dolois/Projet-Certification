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
}