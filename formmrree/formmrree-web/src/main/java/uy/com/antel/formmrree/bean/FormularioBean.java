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
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
    

}
