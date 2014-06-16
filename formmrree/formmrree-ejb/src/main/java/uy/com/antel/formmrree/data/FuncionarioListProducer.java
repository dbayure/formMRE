package uy.com.antel.formmrree.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uy.com.antel.formmrree.model.Funcionario;

@RequestScoped
public class FuncionarioListProducer {
	
   @Inject
   private EntityManager em;

   private List<Funcionario> funcionarios;


   @Produces
   @Named
   public List<Funcionario> getFuncionario() {
      return funcionarios;
   }
   
   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Funcionario funcionario) {
	      retrieveAllOrderedByName();
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Funcionario> criteria = cb.createQuery(Funcionario.class);
      Root<Funcionario> funcionario = criteria.from(Funcionario.class);
      criteria.select(funcionario).orderBy(cb.asc(funcionario.get("id")));
      funcionarios = em.createQuery(criteria).getResultList();
   }
}
