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

import uy.com.antel.formmrree.model.Oficio;


@Stateful
@Model
public class RegistroOficio {
	
	 @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Oficio> oficioEventSrc;

	   private Oficio newOficio;

	   @Produces
	   @Named
	   public Oficio getNewOficio() {
	      return newOficio;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newOficio.getNombre());
	      em.persist(newOficio);
	      oficioEventSrc.fire(newOficio);
	      initNewOficio();
	   }
	   
	   public void modificar(Oficio oficio) throws Exception {
		   log.info("Modifico " + oficio);
		   em.merge(oficio);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Oficio oficio = em.find(Oficio.class, id);
		   em.remove(oficio);
		   oficioEventSrc.fire(newOficio);
	   }

	   @PostConstruct
	   public void initNewOficio() {
	      newOficio = new Oficio();
	   }

}
