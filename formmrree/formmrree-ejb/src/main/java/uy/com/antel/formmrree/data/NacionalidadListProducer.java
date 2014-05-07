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

import uy.com.antel.formmrree.model.Nacionalidad;

@RequestScoped
public class NacionalidadListProducer {
	
   @Inject
   private EntityManager em;

   private List<Nacionalidad> nacionalidades;


   @Produces
   @Named
   public List<Nacionalidad> getNacionalidades() {
      return nacionalidades;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Nacionalidad nacionalidad) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Nacionalidad> criteria = cb.createQuery(Nacionalidad.class);
      Root<Nacionalidad> nacionalidad = criteria.from(Nacionalidad.class);
      criteria.select(nacionalidad).orderBy(cb.asc(nacionalidad.get("nombre")));
      nacionalidades = em.createQuery(criteria).getResultList();
   }
}
