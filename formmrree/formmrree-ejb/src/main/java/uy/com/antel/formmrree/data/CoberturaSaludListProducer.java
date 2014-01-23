package uy.com.antel.formmrree.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import uy.com.antel.formmrree.model.CoberturaSalud;

@RequestScoped
public class CoberturaSaludListProducer {
	
   @Inject
   private EntityManager em;

   private List<CoberturaSalud> coberturasSalud;


   @Produces
   @Named
   public List<CoberturaSalud> getCoberturasSalud() {
      return coberturasSalud;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<CoberturaSalud> criteria = cb.createQuery(CoberturaSalud.class);
      Root<CoberturaSalud> coberturaSalud = criteria.from(CoberturaSalud.class);
      criteria.select(coberturaSalud).orderBy(cb.asc(coberturaSalud.get("nombre")));
      coberturasSalud = em.createQuery(criteria).getResultList();
   }
}
