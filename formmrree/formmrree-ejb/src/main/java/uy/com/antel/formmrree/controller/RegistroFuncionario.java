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

import uy.com.antel.formmrree.model.Funcionario;


@Stateful
@Model
public class RegistroFuncionario {

	   @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Funcionario> funcionarioEventSrc;

	   private Funcionario newFuncionario;

	   @Produces
	   @Named
	   public Funcionario getNewFuncionario() {
	      return newFuncionario;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newFuncionario.getNombre());
	      em.persist(newFuncionario);
	      funcionarioEventSrc.fire(newFuncionario);
	      initNewFuncionario();
	   }
	   
	   public void modificar(Funcionario funcionario) throws Exception {
		   log.info("Modifico " + funcionario);
		   em.merge(funcionario);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Funcionario funcionario = em.find(Funcionario.class, id);
		   em.remove(funcionario);
		   funcionarioEventSrc.fire(newFuncionario);
	   }

	   @PostConstruct
	   public void initNewFuncionario() {
		   newFuncionario = new Funcionario();
	   }
}
