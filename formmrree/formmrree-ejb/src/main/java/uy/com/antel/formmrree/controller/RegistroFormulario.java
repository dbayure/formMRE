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
package uy.com.antel.formmrree.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import uy.com.antel.formmrree.enums.Estado;
import uy.com.antel.formmrree.model.Beneficio;
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
	private List<Formulario> formularios;
	private Date fdesde = new Date();
	private Date fhasta = new Date();
	private String consulta = "select f.* from formulario f where f.fecha_entrevista between ? and ?";

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

	@Produces
	@Named
    public List<Formulario> getFormulariosPorFecha() {
	   	  
   	  System.out.println("comebzando la consulta...\n");
	  Query q = em.createNativeQuery(consulta, Formulario.class);	
	  Timestamp desde = new Timestamp(fdesde.getTime());
	  Timestamp hasta = new Timestamp(fhasta.getTime());
	  q.setParameter( 1, desde );
	  q.setParameter( 2, hasta );
	  System.out.println("cantidad de parametros: " + q.getResultList().size());
	  for (int i =0; i < q.getResultList().size(); i++){
		  System.out.println("adentro de la consulta");
		  Formulario f = (Formulario) q.getResultList().get(i);
		  System.out.println("Nombre persona :" + f.getId());
		  formularios.add(f);
	  }
      return formularios;
   }
	@Produces
	@Named
	public Date getFdesde() {
		return fdesde;
	}

	public void setFdesde(Date fdesde) {
		this.fdesde = fdesde;
	}
	@Produces
	@Named
	public Date getFhasta() {
		return fhasta;
	}

	public void setFhasta(Date fhasta) {
		this.fhasta = fhasta;
	}

	public void registro() throws Exception {		
		log.info("Registro formulario ");// + _formulario);
		em.persist(_formulario);
		initialize();
	}
	
	public void ingresarPersona () throws Exception{
		PaisResidencia pr = _persona.getPaisResidencia();
		pr.setPersona(_persona);
		_persona.setPaisResidencia(pr);
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
		em.merge(p);
		log.info("La persona " + p.getNombre() + "fue modificada correctamente");
	}
	
	public void init() {
		_persona = new Persona();
	}

	@PostConstruct
	public void initialize() {
		_formulario = new Formulario();
		Funcionario funcionario = em.find(Funcionario.class, 1L);
		List<Beneficio> beneficio = _formulario.getBeneficio();
		_formulario.setFuncionario(funcionario);
		_formulario.setBeneficio(beneficio);
		_formulario.setFechaEntrevista(new Date());
		_formulario.setEstado(Estado.ALTA);
		init();
	}
}
