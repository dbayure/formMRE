package uy.com.antel.formmrree.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.antel.formmrree.model.Pais;


public class RegistroPais {
	
	 @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Pais> paisEventSrc;

	   private Pais newPais;

	   @Produces
	   @Named
	   public Pais getNewPais() {
	      return newPais;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newPais.getNombre());
	      em.persist(newPais);
	      paisEventSrc.fire(newPais);
	      initNewPais();
	   }
	   
	   public void modificar(Pais pais) throws Exception {
		   log.info("Modifico " + pais);
		   em.merge(pais);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Pais pais = em.find(Pais.class, id);
		   em.remove(pais);
		   paisEventSrc.fire(newPais);
	   }

	   @PostConstruct
	   public void initNewPais() {
	      newPais = new Pais();
	   }

}
