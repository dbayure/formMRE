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

import uy.com.antel.formmrree.model.FormaRetorno;


@Stateful
@Model
public class RegistroFormaRetorno {
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<FormaRetorno> formaRetornoEventSrc;

	   private FormaRetorno newFormaRetorno;

	   @Produces
	   @Named
	   public FormaRetorno getNewFormaRetorno() {
	      return newFormaRetorno;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newFormaRetorno.getNombre());
	      em.persist(newFormaRetorno);
	      formaRetornoEventSrc.fire(newFormaRetorno);
	      initNewFormaRetorno();
	   }
	   
	   public void modificar(FormaRetorno formaRetorno) throws Exception {
		   log.info("Modifico " + formaRetorno);
		   em.merge(formaRetorno);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   FormaRetorno formaRetorno = em.find(FormaRetorno.class, id);
		   em.remove(formaRetorno);
		   formaRetornoEventSrc.fire(newFormaRetorno);
	   }

	   @PostConstruct
	   public void initNewFormaRetorno() {
	      newFormaRetorno = new FormaRetorno();
	   }

}
