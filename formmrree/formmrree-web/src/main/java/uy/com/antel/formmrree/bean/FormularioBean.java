package uy.com.antel.formmrree.bean;

import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import uy.com.antel.formmrree.controller.RegistroFormulario;
import uy.com.antel.formmrree.model.Persona;


@ManagedBean(name="formularioBean")
@RequestScoped
public class FormularioBean {
	
	@Inject
	private Logger log;
	
	@Inject
	private RegistroFormulario registroFormulario;
	
	private Persona persona;

	public Persona getPersona() 
	{
		return persona;
	}

	public void setPersona(Persona persona) 
	{
		this.persona = persona;
	}
	
	public void init()
	{
		log.info("init Persona");
		persona = new Persona();
	}

}
