package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Oficio implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOficio", nullable = false)
    private Integer idOficio;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    public Oficio (){
    	
    }

    public Oficio (Integer idOficio){
    	this.idOficio = idOficio;
    }

	public Oficio(Integer idOficio, String descripcion) {
		super();
		this.idOficio = idOficio;
		this.descripcion = descripcion;
	}

	public Integer getIdOficio() {
		return idOficio;
	}

	public void setIdOficio(Integer idOficio) {
		this.idOficio = idOficio;
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
				+ ((idOficio == null) ? 0 : idOficio.hashCode());
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
		Oficio other = (Oficio) obj;
		if (idOficio == null) {
			if (other.idOficio != null)
				return false;
		} else if (!idOficio.equals(other.idOficio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Oficio [idOficio=" + idOficio + "]";
	}
	
}
