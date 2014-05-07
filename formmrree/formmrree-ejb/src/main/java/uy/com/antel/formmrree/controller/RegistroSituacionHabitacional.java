package uy.com.antel.formmrree.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.antel.formmrree.model.SituacionHabitacional;



@Stateful
@Model
public class RegistroSituacionHabitacional {

	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<SituacionHabitacional> situacionHabitacionalEventSrc;

	   private SituacionHabitacional newSituacionHabitacional;

	   @Produces
	   @Named
	   public SituacionHabitacional getNewSituacionHabitacional() {
	      return newSituacionHabitacional;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newSituacionHabitacional.getNombre());
	      em.persist(newSituacionHabitacional);
	      situacionHabitacionalEventSrc.fire(newSituacionHabitacional);
	      initNewSituacionHabitacional();
	   }
	   
	   public void modificar(SituacionHabitacional situacionHabitacional) throws Exception {
		   log.info("Modifico " + situacionHabitacional);
		   em.merge(situacionHabitacional);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   SituacionHabitacional situacionHabitacional = em.find(SituacionHabitacional.class, id);
		   em.remove(situacionHabitacional);
		   situacionHabitacionalEventSrc.fire(newSituacionHabitacional);
	   }

	   @PostConstruct
	   public void initNewSituacionHabitacional() {
		   newSituacionHabitacional = new SituacionHabitacional();
	   }
}
