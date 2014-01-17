package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Ocupacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOcupacion", nullable = false)
    private Integer idOcupacion;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    public Ocupacion ()
    {
    	
    }
    
    public Ocupacion (Integer idOcupacion){
    	this.idOcupacion = idOcupacion;
    }

	public Ocupacion(Integer idOcupacion, String descripcion) {
		super();
		this.idOcupacion = idOcupacion;
		this.descripcion = descripcion;
	}

	public Integer getIdOcupacion() {
		return idOcupacion;
	}

	public void setIdOcupacion(Integer idOcupacion) {
		this.idOcupacion = idOcupacion;
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
				+ ((idOcupacion == null) ? 0 : idOcupacion.hashCode());
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
		Ocupacion other = (Ocupacion) obj;
		if (idOcupacion == null) {
			if (other.idOcupacion != null)
				return false;
		} else if (!idOcupacion.equals(other.idOcupacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ocupacion [idOcupacion=" + idOcupacion + "]";
	}
    
}
