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

import uy.com.antel.formmrree.model.Nacionalidad;

@Stateful
@Model
public class RegistroNacionalidad {
	
	  @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Nacionalidad> nacionalidadEventSrc;

	   private Nacionalidad newNacionalidad;

	   @Produces
	   @Named
	   public Nacionalidad getNewNacionalidad() {
	      return newNacionalidad;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newNacionalidad.getNombre());
	      em.persist(newNacionalidad);
	      nacionalidadEventSrc.fire(newNacionalidad);
	      initNewNacionalidad();
	   }
	   
	   public void modificar(Nacionalidad nacionalidad) throws Exception {
		   log.info("Modifico " + nacionalidad);
		   em.merge(nacionalidad);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Nacionalidad nacionalidad = em.find(Nacionalidad.class, id);
		   em.remove(nacionalidad);
		   nacionalidadEventSrc.fire(newNacionalidad);
	   }

	   @PostConstruct
	   public void initNewNacionalidad() {
	      newNacionalidad = new Nacionalidad();
	   }

}
