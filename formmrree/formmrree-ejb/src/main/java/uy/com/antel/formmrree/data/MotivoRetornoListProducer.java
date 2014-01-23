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

import uy.com.antel.formmrree.model.MotivoRetorno;

@RequestScoped
public class MotivoRetornoListProducer {
	
   @Inject
   private EntityManager em;

   private List<MotivoRetorno> motivosRetorno;


   @Produces
   @Named
   public List<MotivoRetorno> getMotivosRetorno() {
      return motivosRetorno;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<MotivoRetorno> criteria = cb.createQuery(MotivoRetorno.class);
      Root<MotivoRetorno> motivoRetorno = criteria.from(MotivoRetorno.class);
      criteria.select(motivoRetorno).orderBy(cb.asc(motivoRetorno.get("nombre")));
      motivosRetorno = em.createQuery(criteria).getResultList();
   }
}
