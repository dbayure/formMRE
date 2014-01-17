package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NivelEducativo implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNivelEducativo", nullable = false)
    private Integer idNivelEducativo;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    public NivelEducativo (){
    	
    }

    public NivelEducativo (Integer idNivelEducativo)
    {
    	this.idNivelEducativo = idNivelEducativo;
    }

	public NivelEducativo(Integer idNivelEducativo, String descripcion) {
		super();
		this.idNivelEducativo = idNivelEducativo;
		this.descripcion = descripcion;
	}

	public Integer getIdNivelEducativo() {
		return idNivelEducativo;
	}

	public void setIdNivelEducativo(Integer idNivelEducativo) {
		this.idNivelEducativo = idNivelEducativo;
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
		result = prime
				* result
				+ ((idNivelEducativo == null) ? 0 : idNivelEducativo.hashCode());
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
		NivelEducativo other = (NivelEducativo) obj;
		if (idNivelEducativo == null) {
			if (other.idNivelEducativo != null)
				return false;
		} else if (!idNivelEducativo.equals(other.idNivelEducativo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NivelEducativo [idNivelEducativo=" + idNivelEducativo + "]";
	}
    
}
