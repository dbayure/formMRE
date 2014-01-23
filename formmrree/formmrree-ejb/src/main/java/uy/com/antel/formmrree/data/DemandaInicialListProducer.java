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

import uy.com.antel.formmrree.model.DemandaInicial;

@RequestScoped
public class DemandaInicialListProducer {
	
   @Inject
   private EntityManager em;

   private List<DemandaInicial> demandasIniciales;


   @Produces
   @Named
   public List<DemandaInicial> getDemandasIniciales() {
      return demandasIniciales;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<DemandaInicial> criteria = cb.createQuery(DemandaInicial.class);
      Root<DemandaInicial> demandaInicial = criteria.from(DemandaInicial.class);
      criteria.select(demandaInicial).orderBy(cb.asc(demandaInicial.get("nombre")));
      demandasIniciales = em.createQuery(criteria).getResultList();
   }
}
