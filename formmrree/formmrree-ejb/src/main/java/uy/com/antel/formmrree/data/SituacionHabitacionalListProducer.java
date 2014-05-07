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

import uy.com.antel.formmrree.model.SituacionHabitacional;

@RequestScoped
public class SituacionHabitacionalListProducer {
	
   @Inject
   private EntityManager em;

   private List<SituacionHabitacional> situacionesHabitacionales;


   @Produces
   @Named
   public List<SituacionHabitacional> getSitaucionesHabitacionales() {
      return situacionesHabitacionales;
   }

   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final SituacionHabitacional situacionHabitacional) {
	      retrieveAllOrderedByName();
   }

   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<SituacionHabitacional> criteria = cb.createQuery(SituacionHabitacional.class);
      Root<SituacionHabitacional> situacionHabitacional = criteria.from(SituacionHabitacional.class);
      criteria.select(situacionHabitacional).orderBy(cb.asc(situacionHabitacional.get("nombre")));
      situacionesHabitacionales = em.createQuery(criteria).getResultList();
   }
}
