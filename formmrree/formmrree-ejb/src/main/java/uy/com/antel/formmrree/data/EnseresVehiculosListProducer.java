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

import uy.com.antel.formmrree.model.EnseresVehiculos;

@RequestScoped
public class EnseresVehiculosListProducer {
	
   @Inject
   private EntityManager em;

   private List<EnseresVehiculos> enseresVehiculos;


   @Produces
   @Named
   public List<EnseresVehiculos> getEnseresVehiculos() {
      return enseresVehiculos;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<EnseresVehiculos> criteria = cb.createQuery(EnseresVehiculos.class);
      Root<EnseresVehiculos> ensereVehiculo = criteria.from(EnseresVehiculos.class);
      criteria.select(ensereVehiculo).orderBy(cb.asc(ensereVehiculo.get("descripcion")));
      enseresVehiculos = em.createQuery(criteria).getResultList();
   }
}
