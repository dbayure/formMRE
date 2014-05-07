package uy.com.antel.formmrree.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import uy.com.antel.formmrree.model.Persona;


@ManagedBean(name="personasBean")
@ViewScoped
public class PersonasBean {
		
		private Persona selectedPersonas;
		
		private List<Persona> PersonasFiltradas;

		public Persona getselectedPersonas() {
			return selectedPersonas;
		}

		public void setselectedPersonas(Persona selectedPersonas) {
			this.selectedPersonas = selectedPersonas;
		}

		public List<Persona> getPersonasFiltradas() {
			return PersonasFiltradas;
		}

		public void setPersonasFiltradas(List<Persona> personasFiltradas) {
			this.PersonasFiltradas = personasFiltradas;
		}
		
		public void mostrarPersona(){
			System.out.println("Nombre de la persona seleccionada:  " + selectedPersonas.getNombre());
		}
		
		public String add()
		{
			return "registroPersonas.jsf?faces-redirect=true";
		}

}
