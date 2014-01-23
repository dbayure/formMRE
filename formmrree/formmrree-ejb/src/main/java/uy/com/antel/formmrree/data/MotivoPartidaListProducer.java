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

import uy.com.antel.formmrree.model.MotivoPartida;

@RequestScoped
public class MotivoPartidaListProducer {
	
   @Inject
   private EntityManager em;

   private List<MotivoPartida> motivosPartida;


   @Produces
   @Named
   public List<MotivoPartida> getMotivosPartida() {
      return motivosPartida;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<MotivoPartida> criteria = cb.createQuery(MotivoPartida.class);
      Root<MotivoPartida> motivoPartida = criteria.from(MotivoPartida.class);
      criteria.select(motivoPartida).orderBy(cb.asc(motivoPartida.get("nombre")));
      motivosPartida = em.createQuery(criteria).getResultList();
   }
}
