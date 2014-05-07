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

import uy.com.antel.formmrree.model.PaisResidencia;

@RequestScoped
public class PaisCondicionResidenciaListProducer {
	
   @Inject
   private EntityManager em;

   private List<PaisResidencia> paisCondicionResidencia;


   @Produces
   @Named
   public List<PaisResidencia> getpaisCondicionResidencia() {
      return paisCondicionResidencia;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final PaisResidencia paisResidencia) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<PaisResidencia> criteria = cb.createQuery(PaisResidencia.class);
      Root<PaisResidencia> cr = criteria.from(PaisResidencia.class);
      criteria.select(cr).orderBy(cb.asc(cr.get("condiciones")));
      paisCondicionResidencia = em.createQuery(criteria).getResultList();
   }
}
