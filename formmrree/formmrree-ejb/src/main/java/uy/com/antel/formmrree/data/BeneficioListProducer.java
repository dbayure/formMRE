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

import uy.com.antel.formmrree.model.Beneficio;

@RequestScoped
public class BeneficioListProducer {
	
   @Inject
   private EntityManager em;

   private List<Beneficio> beneficios;


   @Produces
   @Named
   public List<Beneficio> getBeneficio() {
      return beneficios;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Beneficio beneficio) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Beneficio> criteria = cb.createQuery(Beneficio.class);
      Root<Beneficio> beneficio = criteria.from(Beneficio.class);
      criteria.select(beneficio).orderBy(cb.asc(beneficio.get("beneficio")));
      beneficios = em.createQuery(criteria).getResultList();
   }
}
