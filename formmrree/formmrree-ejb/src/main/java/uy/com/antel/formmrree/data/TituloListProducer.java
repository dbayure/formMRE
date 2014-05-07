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

import uy.com.antel.formmrree.model.Titulo;

@RequestScoped
public class TituloListProducer {
	
   @Inject
   private EntityManager em;

   private List<Titulo> titulos;


   @Produces
   @Named
   public List<Titulo> getTitulos() {
      return titulos;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Titulo titulo) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Titulo> criteria = cb.createQuery(Titulo.class);
      Root<Titulo> titulo = criteria.from(Titulo.class);
      criteria.select(titulo).orderBy(cb.asc(titulo.get("nombre")));
      titulos = em.createQuery(criteria).getResultList();
   }
}
