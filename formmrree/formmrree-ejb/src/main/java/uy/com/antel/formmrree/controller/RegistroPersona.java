package uy.com.antel.formmrree.controller;

import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import uy.com.antel.formmrree.model.Persona;

@Stateful
@Model
@RolesAllowed({"MRREE_FORMADMIN"})
public class RegistroPersona {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	private Persona newPersona;
	
	@Inject
	private Event<Persona> personaRetornoEventSrc;

	@Produces
	@Named
	public Persona getnewPersona() {
		return newPersona;
	}
	
	public void eliminarPersona (long id) throws Exception {
		log.info("Se va a eliminar la persona " + id);
		Persona p = em.find(Persona.class,id);
		em.remove(p);
		personaRetornoEventSrc.fire(newPersona);
	}

}
