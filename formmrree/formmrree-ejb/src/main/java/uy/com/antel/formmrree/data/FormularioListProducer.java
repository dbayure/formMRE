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

import uy.com.antel.formmrree.model.Ciudad;
import uy.com.antel.formmrree.model.Formulario;

@RequestScoped
public class FormularioListProducer {
	
   @Inject
   private EntityManager em;

   private List<Formulario> formularios;


   @Produces
   @Named
   public List<Formulario> getFormularios() {
      return formularios;
   }
   
   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Ciudad ciudad) {
	      retrieveAllOrderedByName();
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Formulario> criteria = cb.createQuery(Formulario.class);
      Root<Formulario> formulario = criteria.from(Formulario.class);
      criteria.select(formulario).orderBy(cb.asc(formulario.get("id")));
      formularios = em.createQuery(criteria).getResultList();
   }
}
