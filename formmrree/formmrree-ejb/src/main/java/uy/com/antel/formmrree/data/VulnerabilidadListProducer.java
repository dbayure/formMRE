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

import uy.com.antel.formmrree.model.Vulnerabilidad;

@RequestScoped
public class VulnerabilidadListProducer {
	
   @Inject
   private EntityManager em;

   private List<Vulnerabilidad> vulnerabilidades;


   @Produces
   @Named
   public List<Vulnerabilidad> getVulnerabilidades() {
      return vulnerabilidades;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Vulnerabilidad vulnerabilidad) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Vulnerabilidad> criteria = cb.createQuery(Vulnerabilidad.class);
      Root<Vulnerabilidad> vulnerabilidad = criteria.from(Vulnerabilidad.class);
      criteria.select(vulnerabilidad).orderBy(cb.asc(vulnerabilidad.get("vulnerabilidad")));
      vulnerabilidades = em.createQuery(criteria).getResultList();
   }
}
