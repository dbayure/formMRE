package uy.com.antel.formmrree.controller;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.antel.formmrree.enums.Estado;
import uy.com.antel.formmrree.model.Formulario;
import uy.com.antel.formmrree.model.Funcionario;
import uy.com.antel.formmrree.model.Persona;

@Stateful
@Model
public class RegistroFormulario {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	private Formulario _formulario;
	private Persona _persona;

	@Produces
	@Named
	public Formulario getFormulario() {
		return _formulario;
	}

	@Produces
	@Named
	public Persona getPersona() {
		return _persona;
	}

	public void registro() throws Exception {		
		_formulario.getPersonas().add(_persona);
		log.info("Registro formulario " + _formulario);
		em.persist(_formulario);
		initialize();
	}

	public void init() {
		_persona = new Persona();
	}

	@PostConstruct
	public void initialize() {
		_formulario = new Formulario();
		Funcionario funcionario = em.find(Funcionario.class, 1L);
		_formulario.setFuncionario(funcionario);
		_formulario.setFechaEntrevista(new Date());
		_formulario.setEstado(Estado.ALTA);
		init();
	}
}
