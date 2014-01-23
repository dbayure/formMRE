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

import uy.com.antel.formmrree.model.Ocupacion;

@RequestScoped
public class OcupacionListProducer {
	
   @Inject
   private EntityManager em;

   private List<Ocupacion> ocupaciones;


   @Produces
   @Named
   public List<Ocupacion> getOcupaciones() {
      return ocupaciones;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Ocupacion> criteria = cb.createQuery(Ocupacion.class);
      Root<Ocupacion> ocupacion = criteria.from(Ocupacion.class);
      criteria.select(ocupacion).orderBy(cb.asc(ocupacion.get("nombre")));
      ocupaciones = em.createQuery(criteria).getResultList();
   }
}
