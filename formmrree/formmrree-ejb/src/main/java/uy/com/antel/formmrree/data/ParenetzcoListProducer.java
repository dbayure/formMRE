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

import uy.com.antel.formmrree.model.Parentezco;

@RequestScoped
public class ParenetzcoListProducer {
	
   @Inject
   private EntityManager em;

   private List<Parentezco> parentezcos;


   @Produces
   @Named
   public List<Parentezco> getParentezcos() {
      return parentezcos;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Parentezco> criteria = cb.createQuery(Parentezco.class);
      Root<Parentezco> parentezco = criteria.from(Parentezco.class);
      criteria.select(parentezco).orderBy(cb.asc(parentezco.get("descripcion")));
      parentezcos = em.createQuery(criteria).getResultList();
   }
}
