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

import uy.com.antel.formmrree.model.Ocupacion;


@Stateful
@Model
public class RegistroOcupacion {
	@Inject
	   private Logger log;

	   @Inject
	   private EntityManager em;

	   @Inject
	   private Event<Ocupacion> OcupacionEventSrc;

	   private Ocupacion newOcupacion;

	   @Produces
	   @Named
	   public Ocupacion getNewOcupacion() {
	      return newOcupacion;
	   }

	   public void registro() throws Exception {
	      log.info("Registro " + newOcupacion.getNombre());
	      em.persist(newOcupacion);
	      OcupacionEventSrc.fire(newOcupacion);
	      initNewOcupacion();
	   }
	   
	   public void modificar(Ocupacion ocupacion) throws Exception {
		   log.info("Modifico " + ocupacion);
		   em.merge(ocupacion);
	   }
	   
	   public void eliminar(Long id) throws Exception {
		   log.info("Elimino " + id);
		   Ocupacion ocupacion = em.find(Ocupacion.class, id);
		   em.remove(ocupacion);
		   OcupacionEventSrc.fire(newOcupacion);
	   }

	   @PostConstruct
	   public void initNewOcupacion() {
	      newOcupacion = new Ocupacion();
	   }

}
