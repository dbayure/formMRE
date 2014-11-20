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
package uy.com.antel.formmrree.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.antel.formmrree.model.DemandaInicial;


@Stateful
@Model
public class RegistroDemandaInicial {


	   @Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<DemandaInicial> demandaInicialEventSrc;

	   private DemandaInicial newDemandaInicial;

	   @Produces
	   @Named
	   public DemandaInicial getNewDemandaInical() {
	      return newDemandaInicial;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newDemandaInicial.getNombre());
	      em.persist(newDemandaInicial);
	      demandaInicialEventSrc.fire(newDemandaInicial);
	      initNewDemandaInicial();
	   }
	   
	   public void modificar(DemandaInicial demandaInicial) throws Exception {
		   log.info("Modifico " + demandaInicial);
		   em.merge(demandaInicial);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   DemandaInicial demandaInicial = em.find(DemandaInicial.class, id);
		   em.remove(demandaInicial);
		   demandaInicialEventSrc.fire(newDemandaInicial);
	   }

	   @PostConstruct
	   public void initNewDemandaInicial() {
	      newDemandaInicial = new DemandaInicial();
	   }
}
