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

import uy.com.antel.formmrree.model.TipoDocumento;

@RequestScoped
public class TipoDocumentoListProducer {
	
   @Inject
   private EntityManager em;

   private List<TipoDocumento> tiposDocumento;


   @Produces
   @Named
   public List<TipoDocumento> getTiposDocumento() 
   {
      return tiposDocumento;
   }
   

   @PostConstruct
   public void retrieveAllOrderedByName() 
   {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<TipoDocumento> criteria = cb.createQuery(TipoDocumento.class);
      Root<TipoDocumento> tipoDocumento = criteria.from(TipoDocumento.class);
      criteria.select(tipoDocumento).orderBy(cb.asc(tipoDocumento.get("id")));
      tiposDocumento = em.createQuery(criteria).getResultList();
   }
}
