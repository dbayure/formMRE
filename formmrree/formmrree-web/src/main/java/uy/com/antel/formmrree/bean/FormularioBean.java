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

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import uy.com.antel.formmrree.controller.RegistroFormulario;
import uy.com.antel.formmrree.model.Persona;


@ManagedBean(name="formularioBean")
@ViewScoped
public class FormularioBean {
	
	@Inject
	private RegistroFormulario registroFormulario;
	
	
	public RegistroFormulario getRegistroFormulario() {
		return registroFormulario;
	}


	public void setRegistroFormulario(RegistroFormulario registroFormulario) {
		this.registroFormulario = registroFormulario;
	}


	public void registro() throws Exception {
		try {
			registroFormulario.registro();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro", "El formulario se registro con éxito!"));  			
		}
		catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro", "Ocurrió un error al intentar el registro."));  
		}
	}
	
	
	public void ingresarPersona () throws Exception{
		try {
			registroFormulario.ingresarPersona();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro", "La persona se registro con éxito!"));
		}
		catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro", "Ocurrió un error al intentar el registro."));
		}
	}
	
	
	public void eliminarPersona (long idf, long idp) throws Exception{
		try{
			registroFormulario.eliminarPersona(idf, idp);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Baja", "La persona se elimino con éxito!"));
		}
		catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Baja", "Ocurrió un error al intentar eliminar el registro."));
		}
	}
	
	public String registrar() throws Exception {
		try{
			registroFormulario.registro();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return "/paginas/formulario/";
	}
	
    public Persona buscarPersona (long id){
    	try{
    		return registroFormulario.encontrarPersona(id);
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public void modificar (Persona p) throws Exception {
    	try{
    		registroFormulario.modificar(p);
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Modificacion", "La persona se Modifico con éxito!"));
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Modificacion", "La persona no pudo modificarse!"));
    	}
    }
    

}
