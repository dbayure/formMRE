package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@XmlRootElement
@Table(name = "beneficio")
@JsonIgnoreProperties({"formulario"})
public class Beneficio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5815809470148059527L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String beneficio;
	
	@ManyToMany(targetEntity = Formulario.class)
	private Set<Formulario> formulario;


	public Beneficio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}

	public Set<Formulario> getFormulario() {
		return formulario;
	}

	public void setFormulario(Set<Formulario> formulario) {
		this.formulario = formulario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((beneficio == null) ? 0 : beneficio.hashCode());
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
		Beneficio other = (Beneficio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (beneficio == null) {
			if (other.beneficio != null)
				return false;
		} else if (!beneficio.equals(other.beneficio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Beneficio [id=" + id + ", beneficio=" + beneficio + ", formulario=" + formulario + "]";
	}
}
