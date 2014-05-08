package uy.com.antel.formmrree.controller;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.antel.formmrree.enums.Estado;
import uy.com.antel.formmrree.model.Formulario;
import uy.com.antel.formmrree.model.Funcionario;
import uy.com.antel.formmrree.model.PaisResidencia;
import uy.com.antel.formmrree.model.Persona;

import javax.enterprise.event.Event;


@Stateful
//@Model
@RolesAllowed({"MRREE_FORMADMIN"})
public class RegistroFormulario {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	private Formulario _formulario;
	private Persona _persona;
	@Inject
	private Event<Persona> personaEventSrc;

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
		log.info("Registro formulario ");// + _formulario);
		em.persist(_formulario);
		initialize();
	}
	
	public void ingresarPersona () throws Exception{
		_persona.setFormulario(_formulario);
		_formulario.getPersonas().add(_persona);
		init();
	}
	
	public void eliminarPersona (long idForm, long idPers) throws Exception {
		log.info("Se va a eliminar la persona " + idPers + "del formulario " + idForm);
		Formulario f = em.find(Formulario.class, idForm);
		Persona p = em.find(Persona.class,idPers);
		f.getPersonas().remove(p);
		personaEventSrc.fire(_persona);
		em.remove(p);
		em.merge(f);
		
		log.info("personas restantes en formulario: " + f.getId());
		log.info("personas: " + p.getId());
	}
	
	public Persona encontrarPersona (long idp){
		Persona p = em.find(Persona.class, idp);
		return p;
	}
	
	public void modificar(Persona p){
		Persona per = em.find(Persona.class, p.getId());
		em.merge(per);
		log.info("El id de la persona modificada es: " + p.getId());
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
