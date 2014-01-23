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

import uy.com.antel.formmrree.model.NivelEducativo;

@RequestScoped
public class NivelEducativoListProducer {
	
   @Inject
   private EntityManager em;

   private List<NivelEducativo> nivelesEducativos;


   @Produces
   @Named
   public List<NivelEducativo> getNivelesEducativos() {
      return nivelesEducativos;
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<NivelEducativo> criteria = cb.createQuery(NivelEducativo.class);
      Root<NivelEducativo> nivelEducativo = criteria.from(NivelEducativo.class);
      criteria.select(nivelEducativo).orderBy(cb.asc(nivelEducativo.get("nombre")));
      nivelesEducativos = em.createQuery(criteria).getResultList();
   }
}
