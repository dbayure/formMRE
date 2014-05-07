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

import uy.com.antel.formmrree.model.Sexo;


@Stateful
@Model
public class RegistroSexo {
	
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Sexo> sexoEventSrc;

	   private Sexo newSexo;

	   @Produces
	   @Named
	   public Sexo getNewSexo() {
	      return newSexo;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newSexo.getSexo());
	      em.persist(newSexo);
	      sexoEventSrc.fire(newSexo);
	      initNewsexo();
	   }
	   
	   public void modificar(Sexo sexo) throws Exception {
		   log.info("Modifico " + sexo);
		   em.merge(sexo);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Sexo sexo = em.find(Sexo.class, id);
		   em.remove(sexo);
		   sexoEventSrc.fire(newSexo);
	   }

	   @PostConstruct
	   public void initNewsexo() {
		   newSexo = new Sexo();
	   }
	  

}
