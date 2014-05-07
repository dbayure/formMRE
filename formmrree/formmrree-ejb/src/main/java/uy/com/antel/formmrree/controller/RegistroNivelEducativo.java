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

import uy.com.antel.formmrree.model.NivelEducativo;

@Stateful
@Model
public class RegistroNivelEducativo {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<NivelEducativo> nivelEducativoEventSrc;

	   private NivelEducativo newNivelEducativo;

	   @Produces
	   @Named
	   public NivelEducativo getNewNivelEducativo() {
	      return newNivelEducativo;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newNivelEducativo);
	      em.persist(newNivelEducativo);
	      nivelEducativoEventSrc.fire(newNivelEducativo);
	      initNewNivelEducativo();
	   }
	   
	   public void modificar(NivelEducativo nivelEducativo) throws Exception {
		   log.info("Modifico " + nivelEducativo);
		   em.merge(nivelEducativo);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   NivelEducativo nivelEducativo = em.find(NivelEducativo.class, id);
		   em.remove(nivelEducativo);
		   nivelEducativoEventSrc.fire(newNivelEducativo);
	   }

	   @PostConstruct
	   public void initNewNivelEducativo() {
	      newNivelEducativo = new NivelEducativo();
	   }

}
