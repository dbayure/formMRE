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

package uy.com.antel.formmrree.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import uy.com.antel.formmrree.model.Persona;


@ManagedBean(name="personasBean")
@ViewScoped
public class PersonasBean {
		
		private Persona selectedPersonas;
		
		private List<Persona> PersonasFiltradas;

		public Persona getselectedPersonas() {
			return selectedPersonas;
		}

		public void setselectedPersonas(Persona selectedPersonas) {
			this.selectedPersonas = selectedPersonas;
		}

		public List<Persona> getPersonasFiltradas() {
			return PersonasFiltradas;
		}

		public void setPersonasFiltradas(List<Persona> personasFiltradas) {
			this.PersonasFiltradas = personasFiltradas;
		}
		
		public void mostrarPersona(){
			System.out.println("Nombre de la persona seleccionada:  " + selectedPersonas.getNombre());
		}
		
		public String add()
		{
			return "registroPersonas.jsf?faces-redirect=true";
		}

}
