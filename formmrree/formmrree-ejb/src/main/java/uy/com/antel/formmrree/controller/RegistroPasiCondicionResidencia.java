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

import uy.com.antel.formmrree.model.PaisResidencia;


@Stateful
@Model
public class RegistroPasiCondicionResidencia {

		
		@Inject Logger log;
		
		@Inject 
		EntityManager em;

		@Inject
		private Event <PaisResidencia> pasiCondicionResidenciaEventSrc;
		
		private PaisResidencia newPaisCondicionResidencia;
		
		@Produces
		@Named
		public PaisResidencia getNewPaisCondicionResidencia ()
		{
			return newPaisCondicionResidencia;
		}
		
		public void registro () throws Exception
		{
			log.info("Registro " + newPaisCondicionResidencia.getCondiciones());
			em.persist(newPaisCondicionResidencia);
			pasiCondicionResidenciaEventSrc.fire(newPaisCondicionResidencia);
			initPaisCondicionResidencia();
		}
		
		public void modificar (PaisResidencia paisCondicionResidencia) throws Exception
		{
			log.info("Modifico" + paisCondicionResidencia);
			em.merge(paisCondicionResidencia);
		}
		
		
		public void eliminar (long id) throws Exception
		{
			log.info("elimino" + id);
			RegistroPasiCondicionResidencia paisCondicionResidencia = em.find(RegistroPasiCondicionResidencia.class, id);
			em.remove(paisCondicionResidencia);
			pasiCondicionResidenciaEventSrc.fire(newPaisCondicionResidencia);
		}
		
		@PostConstruct
		public void initPaisCondicionResidencia ()
		{
			newPaisCondicionResidencia = new PaisResidencia();
		}
		

}
