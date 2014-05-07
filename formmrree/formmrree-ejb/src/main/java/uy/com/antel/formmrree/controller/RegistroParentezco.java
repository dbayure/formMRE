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

import uy.com.antel.formmrree.model.Parentezco;



@Stateful
@Model
public class RegistroParentezco {

	 @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Parentezco> parentezcoEventSrc;

	   private Parentezco newParentezcos;

	   @Produces
	   @Named
	   public Parentezco getNewParentezcos() {
	      return newParentezcos;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newParentezcos.getDescripcion());
	      em.persist(newParentezcos);
	      parentezcoEventSrc.fire(newParentezcos);
	      initNewCoberturaSalud();
	   }
	   
	   public void modificar(Parentezco parentezco) throws Exception {
		   log.info("Modifico " + parentezco);
		   em.merge(parentezco);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Parentezco parentezco = em.find(Parentezco.class, id);
		   em.remove(parentezco);
		   parentezcoEventSrc.fire(newParentezcos);
	   }

	   @PostConstruct
	   public void initNewCoberturaSalud() {
	      newParentezcos = new Parentezco();
	   }
}
