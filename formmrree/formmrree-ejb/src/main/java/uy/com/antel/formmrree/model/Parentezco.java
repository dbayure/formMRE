package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Parentezco implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idParentezco", nullable = false)
    private Integer idParentezco;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    public Parentezco (){
    	
    }

    public Parentezco (Integer idParentezco){
    	this.idParentezco = idParentezco;
    }

	public Parentezco(Integer idParentezco, String descripcion) {
		super();
		this.idParentezco = idParentezco;
		this.descripcion = descripcion;
	}

	public Integer getIdParentezco() {
		return idParentezco;
	}

	public void setIdParentezco(Integer idParentezco) {
		this.idParentezco = idParentezco;
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
				+ ((idParentezco == null) ? 0 : idParentezco.hashCode());
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
		Parentezco other = (Parentezco) obj;
		if (idParentezco == null) {
			if (other.idParentezco != null)
				return false;
		} else if (!idParentezco.equals(other.idParentezco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parentezco [idParentezco=" + idParentezco + "]";
	}
    
}
