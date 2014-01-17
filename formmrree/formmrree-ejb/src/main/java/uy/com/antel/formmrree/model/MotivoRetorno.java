package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MotivoRetorno implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMotivoRetorno", nullable = false)
    private Integer idMotivoRetorno;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    public MotivoRetorno (){
    	
    }
    
    public MotivoRetorno (Integer idMotivoRetorno){
    	this.idMotivoRetorno = idMotivoRetorno;
    }

	public MotivoRetorno(Integer idMotivoRetorno, String descripcion) {
		super();
		this.idMotivoRetorno = idMotivoRetorno;
		this.descripcion = descripcion;
	}

	public Integer getIdMotivoRetorno() {
		return idMotivoRetorno;
	}

	public void setIdMotivoRetorno(Integer idMotivoRetorno) {
		this.idMotivoRetorno = idMotivoRetorno;
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
	public String toString() {
		return "MotivoRetorno [idMotivoRetorno=" + idMotivoRetorno + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idMotivoRetorno == null) ? 0 : idMotivoRetorno.hashCode());
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
		MotivoRetorno other = (MotivoRetorno) obj;
		if (idMotivoRetorno == null) {
			if (other.idMotivoRetorno != null)
				return false;
		} else if (!idMotivoRetorno.equals(other.idMotivoRetorno))
			return false;
		return true;
	}
    
    
}
