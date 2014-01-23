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

import uy.com.antel.formmrree.model.SituacionLaboral;

@RequestScoped
public class SituacionLaboralListProducer {
	
   @Inject
   private EntityManager em;

   private List<SituacionLaboral> situacionesLaborales;


   @Produces
   @Named
   public List<SituacionLaboral> getSituacionesLaborales() {
      return situacionesLaborales;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<SituacionLaboral> criteria = cb.createQuery(SituacionLaboral.class);
      Root<SituacionLaboral> situacionLaboral = criteria.from(SituacionLaboral.class);
      criteria.select(situacionLaboral).orderBy(cb.asc(situacionLaboral.get("nombre")));
      situacionesLaborales = em.createQuery(criteria).getResultList();
   }
}
