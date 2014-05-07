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

import uy.com.antel.formmrree.model.EnseresVehiculos;

@Stateful
@Model
public class RegistroEnseresVehiculos {
	

	   @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<EnseresVehiculos> enseresVehiculosEventSrc;

	   private EnseresVehiculos newEnseresVehiculos;

	   @Produces
	   @Named
	   public EnseresVehiculos getNewEnseresVehiculos() {
	      return newEnseresVehiculos;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newEnseresVehiculos.getDescripcion());
	      em.persist(newEnseresVehiculos);
	      enseresVehiculosEventSrc.fire(newEnseresVehiculos);
	      initNewDemandaInicial();
	   }
	   
	   public void modificar(EnseresVehiculos enseresVehiculos) throws Exception {
		   log.info("Modifico " + enseresVehiculos);
		   em.merge(enseresVehiculos);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   EnseresVehiculos enseresVehiculos = em.find(EnseresVehiculos.class, id);
		   em.remove(enseresVehiculos);
		   enseresVehiculosEventSrc.fire(newEnseresVehiculos);
	   }

	   @PostConstruct
	   public void initNewDemandaInicial() {
	      newEnseresVehiculos = new EnseresVehiculos();
	   }

}
