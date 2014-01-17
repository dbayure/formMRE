package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CoberturaSalud implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCoberturaSalud", nullable = false)
    private Integer idCoberturaSalud;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    public CoberturaSalud (){
    	
    }
    
    public CoberturaSalud (Integer idCoberturaSalud){
    	this.idCoberturaSalud = idCoberturaSalud;
    }

	public CoberturaSalud(Integer idCoberturaSalud, String descripcion) {
		super();
		this.idCoberturaSalud = idCoberturaSalud;
		this.descripcion = descripcion;
	}

	public Integer getIdCoberturaSalud() {
		return idCoberturaSalud;
	}

	public void setIdCoberturaSalud(Integer idCoberturaSalud) {
		this.idCoberturaSalud = idCoberturaSalud;
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
				+ ((idCoberturaSalud == null) ? 0 : idCoberturaSalud.hashCode());
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
		CoberturaSalud other = (CoberturaSalud) obj;
		if (idCoberturaSalud == null) {
			if (other.idCoberturaSalud != null)
				return false;
		} else if (!idCoberturaSalud.equals(other.idCoberturaSalud))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CoberturaSalud [idCoberturaSalud=" + idCoberturaSalud + "]";
	}
    
}
