package uy.com.antel.formmrree.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import uy.com.antel.formmrree.model.Formulario;


@ManagedBean(name="formulariosBean")
@ViewScoped
public class FormulariosBean {
	
	private Formulario selectedFormulario;

	
	private List<Formulario> formulariosFiltrados;
	

	public Formulario getSelectedFormulario() {
		return selectedFormulario;
	}

	public void setSelectedFormulario(Formulario selectedFormulario) {
		this.selectedFormulario = selectedFormulario;
	}

	public List<Formulario> getFormulariosFiltrados() {
		return formulariosFiltrados;
	}

	public void setFormulariosFiltrados(List<Formulario> formulariosFiltrados) {
		this.formulariosFiltrados = formulariosFiltrados;
	}

	
	public String add()
	{
		return "registroPersonas.jsf?faces-redirect=true";
	}

	public String home()
	{
		return "listadoFormularios.jsf?faces-redirect=true";
	}
}
