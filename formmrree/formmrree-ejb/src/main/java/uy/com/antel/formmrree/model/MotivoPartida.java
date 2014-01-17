package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MotivoPartida implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMotivoPartida", nullable = false)
    private Integer idMotivoPartida;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    public MotivoPartida (){
    	
    }
    
    public MotivoPartida (Integer idMotivoPartida){
    	this.idMotivoPartida = idMotivoPartida;
    }

	public MotivoPartida(Integer idMotivoPartida, String descripcion) {
		super();
		this.idMotivoPartida = idMotivoPartida;
		this.descripcion = descripcion;
	}

	public Integer getIdMotivoPartida() {
		return idMotivoPartida;
	}

	public void setIdMotivoPartida(Integer idMotivoPartida) {
		this.idMotivoPartida = idMotivoPartida;
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
				+ ((idMotivoPartida == null) ? 0 : idMotivoPartida.hashCode());
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
		MotivoPartida other = (MotivoPartida) obj;
		if (idMotivoPartida == null) {
			if (other.idMotivoPartida != null)
				return false;
		} else if (!idMotivoPartida.equals(other.idMotivoPartida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MotivoPartida [idMotivoPartida=" + idMotivoPartida + "]";
	}
    
    
}
