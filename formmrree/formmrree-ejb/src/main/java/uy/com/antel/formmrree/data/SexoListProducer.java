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

import uy.com.antel.formmrree.model.Sexo;

@RequestScoped
public class SexoListProducer {
	
   @Inject
   private EntityManager em;

   private List<Sexo> sexos;


   @Produces
   @Named
   public List<Sexo> getSexos() {
      return sexos;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Sexo> criteria = cb.createQuery(Sexo.class);
      Root<Sexo> sexo = criteria.from(Sexo.class);
      criteria.select(sexo).orderBy(cb.asc(sexo.get("sexo")));
      sexos = em.createQuery(criteria).getResultList();
   }
}
