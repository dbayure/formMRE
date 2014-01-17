package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Nacionalidad implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNacionalidad", nullable = false)
    private Integer idNacionalidad;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    public Nacionalidad (){
    	
    }
    
    public Nacionalidad (Integer idNacionalidad){
    	this.idNacionalidad = idNacionalidad;
    }

	public Nacionalidad(Integer idNacionalidad, String descripcion) {
		super();
		this.idNacionalidad = idNacionalidad;
		this.descripcion = descripcion;
	}

	public Integer getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(Integer idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idNacionalidad == null) ? 0 : idNacionalidad.hashCode());
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
		Nacionalidad other = (Nacionalidad) obj;
		if (idNacionalidad == null) {
			if (other.idNacionalidad != null)
				return false;
		} else if (!idNacionalidad.equals(other.idNacionalidad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nacionalidad [idNacionalidad=" + idNacionalidad + "]";
	}
    
}
