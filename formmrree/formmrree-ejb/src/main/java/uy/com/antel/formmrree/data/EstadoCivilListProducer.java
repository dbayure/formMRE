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

import uy.com.antel.formmrree.model.EstadoCivil;

@RequestScoped
public class EstadoCivilListProducer {
	
   @Inject
   private EntityManager em;

   private List<EstadoCivil> estadosCiviles;


   @Produces
   @Named
   public List<EstadoCivil> getEstadosCiviles() {
      return estadosCiviles;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<EstadoCivil> criteria = cb.createQuery(EstadoCivil.class);
      Root<EstadoCivil> estadoCivil = criteria.from(EstadoCivil.class);
      criteria.select(estadoCivil).orderBy(cb.asc(estadoCivil.get("estado")));
      estadosCiviles = em.createQuery(criteria).getResultList();
   }
}
