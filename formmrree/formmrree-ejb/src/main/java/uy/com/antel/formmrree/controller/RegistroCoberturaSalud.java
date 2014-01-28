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

import uy.com.antel.formmrree.model.CoberturaSalud;

@Stateful
@Model
public class RegistroCoberturaSalud {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<CoberturaSalud> coberturaSaludEventSrc;

   private CoberturaSalud newCoberturaSalud;

   @Produces
   @Named
   public CoberturaSalud getNewCoberturaSalud() {
      return newCoberturaSalud;
   }

   public void registro() throws Exception {
      log.info("Registro " + newCoberturaSalud.getNombre());
      em.persist(newCoberturaSalud);
      coberturaSaludEventSrc.fire(newCoberturaSalud);
      initNewCoberturaSalud();
   }
   
   public void modificar(CoberturaSalud coberturaSalud) throws Exception {
	   log.info("Modifico " + coberturaSalud);
	   em.merge(coberturaSalud);
   }
   
   public void eliminar(Long id) throws Exception {
	   log.info("Elimino " + id);
	   CoberturaSalud coberturaSalud = em.find(CoberturaSalud.class, id);
	   em.remove(coberturaSalud);
	   coberturaSaludEventSrc.fire(newCoberturaSalud);
   }

   @PostConstruct
   public void initNewCoberturaSalud() {
      newCoberturaSalud = new CoberturaSalud();
   }
  
}
