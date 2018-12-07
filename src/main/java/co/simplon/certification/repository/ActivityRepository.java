package co.simplon.certification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.certification.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>
{

	List<Activity> findAllActivityByCity();
	
// <ctrl> + <space> pour lister toutes les méthodes Jpa
// ou
// https://docs.spring.io/spring-data/jpa/docs/1.6.0.RELEASE/reference/html/jpa.repositories.html

// implémentation et héritage de toutes les signatures des méthodes JpaRepositories
	
} 