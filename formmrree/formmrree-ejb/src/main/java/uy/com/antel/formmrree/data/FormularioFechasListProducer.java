/*

FORMMRREEANTEL - Formulario Ministerio Relaciones Exteriores
Copyright (C) 2009  ANTEL - MRREE

This file is part of FORMMRREEANTEL.

FORMMRREEANTEL is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 
*/
package uy.com.antel.formmrree.data;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import uy.com.antel.formmrree.model.Formulario;

@RequestScoped
public class FormularioFechasListProducer {
	
   @Inject
   private EntityManager em;

   private List<Formulario> formulariosFechas;
  
   @Produces
   @Named
   public List<Formulario> getformulariosFechas() {
      return formulariosFechas;
   }
   

   
   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Formulario formulario) {
	      retrieveAllOrderedByName(null, null);
   }


   @PostConstruct
   public void retrieveAllOrderedByName(Timestamp desde, Timestamp hasta	) {
//      CriteriaBuilder cb = em.getCriteriaBuilder();
//      CriteriaQuery<Formulario> criteria = cb.createQuery(Formulario.class);
//      Root<Formulario> formulario = criteria.from(Formulario.class);
//      criteria.where(cb.between((formulario.get("fechaEntrevista"), desde, hasta));
//      criteria.select(formulario).orderBy(cb.asc(formulario.get("id")));
//      formulariosFechas = em.createQuery(criteria).getResultList();
	   String consForm = "select * from formulario where formulario.fechaEntrevista between ? and ?";
	   Query q = em.createNativeQuery(consForm, Formulario.class);
	   q.setParameter( 1, desde );
	   q.setParameter( 2, hasta );
	   formulariosFechas = q.getResultList();
   }
}
