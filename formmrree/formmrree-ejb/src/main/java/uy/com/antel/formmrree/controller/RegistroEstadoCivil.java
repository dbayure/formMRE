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

import uy.com.antel.formmrree.model.EstadoCivil;


@Stateful
@Model
public class RegistroEstadoCivil {

	   @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<EstadoCivil> estadoCivilEventSrc;

	   private EstadoCivil newEstadoCivil;

	   @Produces
	   @Named
	   public EstadoCivil getNewEstadoCivil() {
	      return newEstadoCivil;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newEstadoCivil.getEstado());
	      em.persist(newEstadoCivil);
	      estadoCivilEventSrc.fire(newEstadoCivil);
	      initNewEstadoCivil();
	   }
	   
	   public void modificar(EstadoCivil estadoCivil) throws Exception {
		   log.info("Modifico " + estadoCivil);
		   em.merge(estadoCivil);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   EstadoCivil estadoCivil = em.find(EstadoCivil.class, id);
		   em.remove(estadoCivil);
		   estadoCivilEventSrc.fire(newEstadoCivil);
	   }

	   @PostConstruct
	   public void initNewEstadoCivil() {
	      newEstadoCivil = new EstadoCivil();
	   }
}
