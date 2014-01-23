package uy.com.antel.formmrree.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import uy.com.antel.formmrree.controller.RegistroFormulario;


@ManagedBean(name="formularioBean")
@ViewScoped
public class FormularioBean {
	
	@Inject
	private RegistroFormulario registroFormulario;
	
	public void registro() {
		try {
			registroFormulario.registro();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro", "El formulario se registro con éxito!"));  			
		}
		catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro", "Ocurrió un error al intentar el registro."));  
		}
	}

}
