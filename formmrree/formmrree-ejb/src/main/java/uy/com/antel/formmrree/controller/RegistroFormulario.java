package uy.com.antel.formmrree.controller;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.antel.formmrree.model.Formulario;

@Stateful
@Model
public class RegistroFormulario {
	
	@Inject
	private Logger log;

	@Inject
	private EntityManager em;
	
	private Formulario _formulario;
	
	@Produces
	@Named
	public Formulario getFormulario()
	{
		return _formulario;
	}
	
	public void registro() throws Exception
	{
		log.info("Registro formulario " + _formulario);
		em.persist(_formulario);
		init();
	}
	
	public void init()
	{
		_formulario = new Formulario();
	}
	

}
