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

import uy.com.antel.formmrree.model.CondicionResidencia;


@Stateful
@Model
public class RegistroCondicionResidencia {

		
		@Inject Logger log;
		
		@Inject 
		EntityManager em;

		@Inject
		private Event <CondicionResidencia> condicionResidenciaEventSrc;
		
		private CondicionResidencia newCondicionResidencia;
		
		@Produces
		@Named
		public CondicionResidencia getNewCondicionResidencia ()
		{
			return newCondicionResidencia;
		}
		
		public void registro () throws Exception
		{
			log.info("Registro " + newCondicionResidencia.getNombre());
			em.persist(newCondicionResidencia);
			condicionResidenciaEventSrc.fire(newCondicionResidencia);
			initCondicionResidencia();
		}
		
		public void modificar (CondicionResidencia condicionResidencia) throws Exception
		{
			log.info("Modifico" + condicionResidencia);
			em.merge(condicionResidencia);
		}
		
		
		public void eliminar (long id) throws Exception
		{
			log.info("elimino" + id);
			RegistroCondicionResidencia condicionResidencia = em.find(RegistroCondicionResidencia.class, id);
			em.remove(condicionResidencia);
			condicionResidenciaEventSrc.fire(newCondicionResidencia);
		}
		
		@PostConstruct
		public void initCondicionResidencia ()
		{
			newCondicionResidencia = new CondicionResidencia();
		}
		

}
