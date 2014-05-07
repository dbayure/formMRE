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

import uy.com.antel.formmrree.model.SituacionLaboral;



@Stateful
@Model
public class RegistroSituacionLaboral {
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<SituacionLaboral> situacionLaboralEventSrc;

	   private SituacionLaboral newSituacionLaboral;

	   @Produces
	   @Named
	   public SituacionLaboral getNewSituacionLaboral() {
	      return newSituacionLaboral;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newSituacionLaboral.getNombre());
	      em.persist(newSituacionLaboral);
	      situacionLaboralEventSrc.fire(newSituacionLaboral);
	      initNewSituacionLaboral();
	   }
	   
	   public void modificar(SituacionLaboral situacionLaboral) throws Exception {
		   log.info("Modifico " + situacionLaboral);
		   em.merge(situacionLaboral);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   SituacionLaboral situacionLaboral = em.find(SituacionLaboral.class, id);
		   em.remove(situacionLaboral);
		   situacionLaboralEventSrc.fire(newSituacionLaboral);
	   }

	   @PostConstruct
	   public void initNewSituacionLaboral() {
	      newSituacionLaboral = new SituacionLaboral();
	   }

}
