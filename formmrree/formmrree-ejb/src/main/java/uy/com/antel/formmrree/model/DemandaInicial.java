package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DemandaInicial implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDemandaInicial", nullable = false)
    private Integer idDemandaInicial;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    public DemandaInicial (){
    	
    }
    
    public DemandaInicial (Integer idDemandaInicial){
    	this.idDemandaInicial = idDemandaInicial;
    }

	public DemandaInicial(Integer idDemandaInicial, String descripcion) {
		super();
		this.idDemandaInicial = idDemandaInicial;
		this.descripcion = descripcion;
	}

	public Integer getIdDemandaInicial() {
		return idDemandaInicial;
	}

	public void setIdDemandaInicial(Integer idDemandaInicial) {
		this.idDemandaInicial = idDemandaInicial;
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
				+ ((idDemandaInicial == null) ? 0 : idDemandaInicial.hashCode());
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
		DemandaInicial other = (DemandaInicial) obj;
		if (idDemandaInicial == null) {
			if (other.idDemandaInicial != null)
				return false;
		} else if (!idDemandaInicial.equals(other.idDemandaInicial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DemandaInicial [idDemandaInicial=" + idDemandaInicial + "]";
	}
	
}
