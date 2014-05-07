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

import uy.com.antel.formmrree.model.CondicionResidencia;

@RequestScoped
public class CondicionResidenciaListProducer {
	
   @Inject
   private EntityManager em;

   private List<CondicionResidencia> condicionesResidencia;


   @Produces
   @Named
   public List<CondicionResidencia> getCondicionResidencia() {
      return condicionesResidencia;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final CondicionResidencia condicionResidencia) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<CondicionResidencia> criteria = cb.createQuery(CondicionResidencia.class);
      Root<CondicionResidencia> ciudad = criteria.from(CondicionResidencia.class);
      criteria.select(ciudad).orderBy(cb.asc(ciudad.get("nombre")));
      condicionesResidencia = em.createQuery(criteria).getResultList();
   }
}
