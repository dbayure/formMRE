package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CodicionesResidencia implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCodicionesResidencia", nullable = false)
    private Integer idCodicionesResidencia;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    
    public CodicionesResidencia (){
    	
    }
    
    public CodicionesResidencia (Integer idCodicionesResidencia){
    	this.idCodicionesResidencia = idCodicionesResidencia;
    }

	public CodicionesResidencia(Integer idCodicionesResidencia,
			String descripcion) {
		super();
		this.idCodicionesResidencia = idCodicionesResidencia;
		this.descripcion = descripcion;
	}

	public Integer getIdCodicionesResidencia() {
		return idCodicionesResidencia;
	}

	public void setIdCodicionesResidencia(Integer idCodicionesResidencia) {
		this.idCodicionesResidencia = idCodicionesResidencia;
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
				+ ((idCodicionesResidencia == null) ? 0
						: idCodicionesResidencia.hashCode());
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
		CodicionesResidencia other = (CodicionesResidencia) obj;
		if (idCodicionesResidencia == null) {
			if (other.idCodicionesResidencia != null)
				return false;
		} else if (!idCodicionesResidencia.equals(other.idCodicionesResidencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CodicionesResidencia [idCodicionesResidencia="
				+ idCodicionesResidencia + "]";
	}
    
}
