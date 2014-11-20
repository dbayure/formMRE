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

import uy.com.antel.formmrree.model.CoberturaSalud;

@RequestScoped
public class CoberturaSaludListProducer {
	
   @Inject
   private EntityManager em;

   private List<CoberturaSalud> coberturasSalud;


   @Produces
   @Named
   public List<CoberturaSalud> getCoberturasSalud() {
      return coberturasSalud;
   }
   
   public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final CoberturaSalud coberturaSalud) {
	      retrieveAllOrderedByName();
   }


   @PostConstruct
   public void retrieveAllOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<CoberturaSalud> criteria = cb.createQuery(CoberturaSalud.class);
      Root<CoberturaSalud> coberturaSalud = criteria.from(CoberturaSalud.class);
      criteria.select(coberturaSalud).orderBy(cb.asc(coberturaSalud.get("nombre")));
      coberturasSalud = em.createQuery(criteria).getResultList();
   }
}
