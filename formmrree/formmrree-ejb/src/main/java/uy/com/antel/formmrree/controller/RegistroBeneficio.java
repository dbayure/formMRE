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

import uy.com.antel.formmrree.model.Beneficio;


@Stateful
@Model
public class RegistroBeneficio {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Beneficio> beneficioEventSrc;

	   private Beneficio newBeneficio;

	   @Produces
	   @Named
	   public Beneficio getNewBeneficio() {
	      return newBeneficio;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newBeneficio.getBeneficio());
	      em.persist(newBeneficio);
	      beneficioEventSrc.fire(newBeneficio);
	      initNewBeneficio();
	   }
	   
	   public void modificar(Beneficio beneficio) throws Exception {
		   log.info("Modifico " + beneficio);
		   em.merge(beneficio);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Beneficio beneficio = em.find(Beneficio.class, id);
		   em.remove(beneficio);
		   beneficioEventSrc.fire(newBeneficio);
	   }

	   @PostConstruct
	   public void initNewBeneficio() {
		   newBeneficio = new Beneficio();
	   }
	  

}
