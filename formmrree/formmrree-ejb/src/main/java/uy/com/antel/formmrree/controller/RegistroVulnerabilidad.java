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
import uy.com.antel.formmrree.model.Vulnerabilidad;

@Stateful
@Model
public class RegistroVulnerabilidad {
	
	  @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Vulnerabilidad> vulnerabilidadEventSrc;

	   private Vulnerabilidad newVulnerabilidad;

	   @Produces
	   @Named
	   public Vulnerabilidad getNewVulnerabilidad() {
	      return newVulnerabilidad;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newVulnerabilidad.getVulnerabilidad());
	      em.persist(newVulnerabilidad);
	      vulnerabilidadEventSrc.fire(newVulnerabilidad);
	      initNewVulnerabilidad();
	   }
	   
	   public void modificar(Vulnerabilidad vulnerabilidad) throws Exception {
		   log.info("Modifico " + vulnerabilidad);
		   em.merge(vulnerabilidad);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Vulnerabilidad vulnerabilidad = em.find(Vulnerabilidad.class, id);
		   em.remove(vulnerabilidad);
		   vulnerabilidadEventSrc.fire(newVulnerabilidad);
	   }

	   @PostConstruct
	   public void initNewVulnerabilidad() {
		   newVulnerabilidad = new Vulnerabilidad();
	   }

}
