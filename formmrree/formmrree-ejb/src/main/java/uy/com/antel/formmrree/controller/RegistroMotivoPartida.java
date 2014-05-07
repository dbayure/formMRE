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

import uy.com.antel.formmrree.model.MotivoPartida;


@Stateful
@Model
public class RegistroMotivoPartida {
	   @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<MotivoPartida> motivoPartidaEventSrc;

	   private MotivoPartida newMotivoPartida;

	   @Produces
	   @Named
	   public MotivoPartida getNewMotivoPartida() {
	      return newMotivoPartida;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newMotivoPartida.getNombre());
	      em.persist(newMotivoPartida);
	      motivoPartidaEventSrc.fire(newMotivoPartida);
	      initNewMotivoPartida();
	   }
	   
	   public void modificar(MotivoPartida motivoPartida) throws Exception {
		   log.info("Modifico " + motivoPartida);
		   em.merge(motivoPartida);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   MotivoPartida motivoPartida = em.find(MotivoPartida.class, id);
		   em.remove(motivoPartida);
		   motivoPartidaEventSrc.fire(newMotivoPartida);
	   }

	   @PostConstruct
	   public void initNewMotivoPartida() {
	      newMotivoPartida = new MotivoPartida();
	   }

}
