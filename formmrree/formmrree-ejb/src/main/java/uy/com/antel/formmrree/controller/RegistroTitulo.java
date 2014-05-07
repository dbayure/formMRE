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

import uy.com.antel.formmrree.model.Titulo;

@Stateful
@Model
public class RegistroTitulo {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Titulo> tituloEventSrc;

	   private Titulo newTitulo;

	   @Produces
	   @Named
	   public Titulo getNewTitulo() {
	      return newTitulo;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newTitulo.getNombre());
	      em.persist(newTitulo);
	      tituloEventSrc.fire(newTitulo);
	      initNewTitulo();
	   }
	   
	   public void modificar(Titulo titulo) throws Exception {
		   log.info("Modifico " + titulo);
		   em.merge(titulo);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Titulo titulo = em.find(Titulo.class, id);
		   em.remove(titulo);
		   tituloEventSrc.fire(newTitulo);
	   }

	   @PostConstruct
	   public void initNewTitulo() {
		   newTitulo = new Titulo();
	   }

}
