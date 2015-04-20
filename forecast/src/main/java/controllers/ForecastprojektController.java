package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ninja.Result;
import ninja.Results;
import ninja.jpa.UnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import model.Forecastprojekt;

public class ForecastprojektController {

	//Daten abfragen
	@Inject 
	Provider<EntityManager> entitiyManagerProvider;

	@UnitOfWork
	public Result getforecastprojekt() {
		
	   EntityManager entityManager = entitiyManagerProvider.get();

	    Query q = entityManager.createNamedQuery("Forecastprojekt.findAll",Forecastprojekt.class);
		List<Forecastprojekt> Forecastprojekte = (List<Forecastprojekt>) q.getResultList();

	    //String postforecast = router.getReverseRoute(ApplicationController.class, "postforecast");
	    return Results
	            .html()
	           .render("Forecastprojekt", Forecastprojekte);
	            /*render(" postforecast",  postforecast);*/
	}

	/*
	//Daten speichern
	@Transactional
	public Result postIndex(Forecastprojekt Forecastprojekt) {

	    logger.info("In postRoute");        

	    EntityManager entityManager = entitiyManagerProvider.get();

	    entityManager.persist(Forecastprojekt);


	    return Results.redirect(router.getReverseRoute(ApplicationController.class, "getForecastprojekt"));
	}	
	*/
}