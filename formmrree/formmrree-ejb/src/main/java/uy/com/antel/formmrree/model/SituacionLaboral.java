package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SituacionLaboral implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSituacionLaboral", nullable = false)
    private Integer idSituacionLaboral;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    public SituacionLaboral (){
    	
    }
    
    public SituacionLaboral (Integer idSituacionLaboral){
    	this.idSituacionLaboral = idSituacionLaboral;
    }

	public SituacionLaboral(Integer idSituacionLaboral, String descripcion) {
		super();
		this.idSituacionLaboral = idSituacionLaboral;
		this.descripcion = descripcion;
	}

	public Integer getIdSituacionLaboral() {
		return idSituacionLaboral;
	}

	public void setIdSituacionLaboral(Integer idSituacionLaboral) {
		this.idSituacionLaboral = idSituacionLaboral;
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
				+ ((idSituacionLaboral == null) ? 0 : idSituacionLaboral
						.hashCode());
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
		SituacionLaboral other = (SituacionLaboral) obj;
		if (idSituacionLaboral == null) {
			if (other.idSituacionLaboral != null)
				return false;
		} else if (!idSituacionLaboral.equals(other.idSituacionLaboral))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SituacionLaboral [idSituacionLaboral=" + idSituacionLaboral
				+ "]";
	}

}

