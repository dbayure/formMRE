package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "pais_residencia")
public class PaisResidencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1694917175389424451L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "pais_id", unique = false)
	private Pais pais;
	
	private Boolean residencia;
	
	private String condiciones;
	
	@ManyToOne
	@JoinColumn ( name = "persona_id")
	private Persona persona;

	public PaisResidencia() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Boolean getResidencia() {
		return residencia;
	}

	public void setResidencia(Boolean residencia) {
		this.residencia = residencia;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public String getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((condiciones == null) ? 0 : condiciones.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result
				+ ((residencia == null) ? 0 : residencia.hashCode());
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
		PaisResidencia other = (PaisResidencia) obj;
		if (condiciones == null) {
			if (other.condiciones != null)
				return false;
		} else if (!condiciones.equals(other.condiciones))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (residencia == null) {
			if (other.residencia != null)
				return false;
		} else if (!residencia.equals(other.residencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaisResidencia [id=" + id + ", pais=" + pais + ", residencia="
				+ residencia + ", condiciones=" + condiciones + ", persona="
				+ persona + "]";
	}
}
