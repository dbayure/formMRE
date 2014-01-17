package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EnseresVehiculos implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEnseresVehiculos", nullable = false)
    private Integer idEnseresVehiculos;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    public EnseresVehiculos (){
    	
    }

    public EnseresVehiculos (Integer idEnseresVehiculos){
    	this.idEnseresVehiculos = idEnseresVehiculos;
    }

	public EnseresVehiculos(Integer idEnseresVehiculos, String descripcion) {
		super();
		this.idEnseresVehiculos = idEnseresVehiculos;
		this.descripcion = descripcion;
	}

	public Integer getIdEnseresVehiculos() {
		return idEnseresVehiculos;
	}

	public void setIdEnseresVehiculos(Integer idEnseresVehiculos) {
		this.idEnseresVehiculos = idEnseresVehiculos;
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
				+ ((idEnseresVehiculos == null) ? 0 : idEnseresVehiculos
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
		EnseresVehiculos other = (EnseresVehiculos) obj;
		if (idEnseresVehiculos == null) {
			if (other.idEnseresVehiculos != null)
				return false;
		} else if (!idEnseresVehiculos.equals(other.idEnseresVehiculos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnseresVehiculos [idEnseresVehiculos=" + idEnseresVehiculos
				+ "]";
	}
    
    
}
