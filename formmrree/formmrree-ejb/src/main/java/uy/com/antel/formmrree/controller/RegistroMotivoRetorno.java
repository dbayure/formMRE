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

import uy.com.antel.formmrree.model.MotivoRetorno;


@Stateful
@Model
public class RegistroMotivoRetorno {
	   @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<MotivoRetorno> motivoRetornoEventSrc;

	   private MotivoRetorno newMotivoRetorno;

	   @Produces
	   @Named
	   public MotivoRetorno getNewMotivoRetorno() {
	      return newMotivoRetorno;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newMotivoRetorno.getNombre());
	      em.persist(newMotivoRetorno);
	      motivoRetornoEventSrc.fire(newMotivoRetorno);
	      initNewMotivoRetorno();
	   }
	   
	   public void modificar(MotivoRetorno motivoRetorno) throws Exception {
		   log.info("Modifico " + motivoRetorno);
		   em.merge(motivoRetorno);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   MotivoRetorno motivoRetorno = em.find(MotivoRetorno.class, id);
		   em.remove(motivoRetorno);
		   motivoRetornoEventSrc.fire(newMotivoRetorno);
	   }

	   @PostConstruct
	   public void initNewMotivoRetorno() {
	      newMotivoRetorno = new MotivoRetorno();
	   }


}
