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

import uy.com.antel.formmrree.model.TipoDocumento;


@Stateful
@Model
public class RegistroTipoDocumento {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<TipoDocumento> tipoDocumentoEventSrc;

	   private TipoDocumento newTipoDocumento;

	   @Produces
	   @Named
	   public TipoDocumento getNewTipoDocumento() {
	      return newTipoDocumento;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newTipoDocumento.getNombre());
	      em.persist(newTipoDocumento);
	      tipoDocumentoEventSrc.fire(newTipoDocumento);
	      initNewTipoDocumento();
	   }
	   
	   public void modificar(TipoDocumento tipoDocumento) throws Exception {
		   log.info("Modifico " + tipoDocumento);
		   em.merge(tipoDocumento);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   TipoDocumento tipoDocumento = em.find(TipoDocumento.class, id);
		   em.remove(tipoDocumento);
		   tipoDocumentoEventSrc.fire(newTipoDocumento);
	   }

	   @PostConstruct
	   public void initNewTipoDocumento() {
		   newTipoDocumento = new TipoDocumento();
	   }

}
