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

import uy.com.antel.formmrree.model.Ocupacion;


@Stateful
@Model
public class RegistroOcupacion {
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Ocupacion> OcupacionEventSrc;

	   private Ocupacion newOcupacion;

	   @Produces
	   @Named
	   public Ocupacion getNewOcupacion() {
	      return newOcupacion;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newOcupacion.getNombre());
	      em.persist(newOcupacion);
	      OcupacionEventSrc.fire(newOcupacion);
	      initNewOcupacion();
	   }
	   
	   public void modificar(Ocupacion ocupacion) throws Exception {
		   log.info("Modifico " + ocupacion);
		   em.merge(ocupacion);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Ocupacion ocupacion = em.find(Ocupacion.class, id);
		   em.remove(ocupacion);
		   OcupacionEventSrc.fire(newOcupacion);
	   }

	   @PostConstruct
	   public void initNewOcupacion() {
	      newOcupacion = new Ocupacion();
	   }

}
