package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@XmlRootElement
@Table(name = "pais")
@JsonIgnoreProperties({"personas"})
public class Pais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1694917175389424451L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	
	@OneToMany( mappedBy = "pais", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Ciudad> ciudades;
	
	@ManyToMany(targetEntity = Persona.class, fetch = FetchType.EAGER)
	private Set<Persona> personas;

	public Pais() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(Set<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}
	
	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + "]";
	}
}
