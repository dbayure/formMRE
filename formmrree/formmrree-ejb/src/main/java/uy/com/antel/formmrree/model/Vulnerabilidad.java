package uy.com.antel.formmrree.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "vulnerabilidad")
public class Vulnerabilidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5815809470148059527L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String vulnerabilidad;


	public Vulnerabilidad() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVulnerabilidad() {
		return vulnerabilidad;
	}

	public void setVulnerabilidad(String vulnerabilidad) {
		this.vulnerabilidad = vulnerabilidad;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vulnerabilidad == null) ? 0 : vulnerabilidad.hashCode());
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
		Vulnerabilidad other = (Vulnerabilidad) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vulnerabilidad == null) {
			if (other.vulnerabilidad != null)
				return false;
		} else if (!vulnerabilidad.equals(other.vulnerabilidad))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Vulnerabilidad [id=" + id + ", vulnerabilidad=" + vulnerabilidad + "]";
	}
}
