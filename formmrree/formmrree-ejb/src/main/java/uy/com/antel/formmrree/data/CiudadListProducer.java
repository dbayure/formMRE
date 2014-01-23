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

import uy.com.antel.formmrree.model.Ciudad;

@RequestScoped
public class CiudadListProducer {
	
   @Inject
   private EntityManager em;

   private List<Ciudad> ciudades;


   @Produces
   @Named
   public List<Ciudad> getCiudades() {
      return ciudades;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Ciudad> criteria = cb.createQuery(Ciudad.class);
      Root<Ciudad> ciudad = criteria.from(Ciudad.class);
      criteria.select(ciudad).orderBy(cb.asc(ciudad.get("nombre")));
      ciudades = em.createQuery(criteria).getResultList();
   }
}
