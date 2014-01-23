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

import uy.com.antel.formmrree.model.FormaRetorno;

@RequestScoped
public class FormaRetornoListProducer {
	
   @Inject
   private EntityManager em;

   private List<FormaRetorno> formasRetorno;


   @Produces
   @Named
   public List<FormaRetorno> getFormasRetorno() {
      return formasRetorno;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<FormaRetorno> criteria = cb.createQuery(FormaRetorno.class);
      Root<FormaRetorno> formaRetorno = criteria.from(FormaRetorno.class);
      criteria.select(formaRetorno).orderBy(cb.asc(formaRetorno.get("nombre")));
      formasRetorno = em.createQuery(criteria).getResultList();
   }
}
