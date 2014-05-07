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

import uy.com.antel.formmrree.model.Oficio;

@RequestScoped
public class OficioListProducer {
	
   @Inject
   private EntityManager em;

   private List<Oficio> oficios;


   @Produces
   @Named
   public List<Oficio> getOficios() {
      return oficios;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Oficio oficio) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Oficio> criteria = cb.createQuery(Oficio.class);
      Root<Oficio> oficio = criteria.from(Oficio.class);
      criteria.select(oficio).orderBy(cb.asc(oficio.get("nombre")));
      oficios = em.createQuery(criteria).getResultList();
   }
}
