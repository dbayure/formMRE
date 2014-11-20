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

import uy.com.antel.formmrree.model.Formulario;


@ManagedBean(name="formulariosBean")
@ViewScoped
public class FormulariosBean {
	
	private Formulario selectedFormulario;

	
	private List<Formulario> formulariosFiltrados;
	

	public Formulario getSelectedFormulario() {
		return selectedFormulario;
	}

	public void setSelectedFormulario(Formulario selectedFormulario) {
		this.selectedFormulario = selectedFormulario;
	}

	public List<Formulario> getFormulariosFiltrados() {
		return formulariosFiltrados;
	}

	public void setFormulariosFiltrados(List<Formulario> formulariosFiltrados) {
		this.formulariosFiltrados = formulariosFiltrados;
	}

	
	public String add()
	{
		return "registroPersonas.jsf?faces-redirect=true";
	}

	public String home()
	{
		return "listadoFormularios.jsf?faces-redirect=true";
	}
}
