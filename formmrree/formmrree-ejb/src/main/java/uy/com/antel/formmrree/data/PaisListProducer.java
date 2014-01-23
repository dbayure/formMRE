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

import uy.com.antel.formmrree.model.Pais;

@RequestScoped
public class PaisListProducer {
	
   @Inject
   private EntityManager em;

   private List<Pais> paises;


   @Produces
   @Named
   public List<Pais> getPaises() {
      return paises;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Pais> criteria = cb.createQuery(Pais.class);
      Root<Pais> pais = criteria.from(Pais.class);
      criteria.select(pais).orderBy(cb.asc(pais.get("nombre")));
      paises = em.createQuery(criteria).getResultList();
   }
}
