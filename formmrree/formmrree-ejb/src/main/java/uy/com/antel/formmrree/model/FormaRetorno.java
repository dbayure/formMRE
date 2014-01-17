package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormaRetorno implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFormaRetorno", nullable = false)
    private Integer idFormaRetorno;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    public FormaRetorno (){
    	
    }
    
    public FormaRetorno (Integer idFormaRetorno){
    	this.idFormaRetorno = idFormaRetorno;
    }

	public FormaRetorno(Integer idFormaRetorno, String descripcion) {
		super();
		this.idFormaRetorno = idFormaRetorno;
		this.descripcion = descripcion;
	}

	public Integer getIdFormaRetorno() {
		return idFormaRetorno;
	}

	public void setIdFormaRetorno(Integer idFormaRetorno) {
		this.idFormaRetorno = idFormaRetorno;
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
				+ ((idFormaRetorno == null) ? 0 : idFormaRetorno.hashCode());
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
		FormaRetorno other = (FormaRetorno) obj;
		if (idFormaRetorno == null) {
			if (other.idFormaRetorno != null)
				return false;
		} else if (!idFormaRetorno.equals(other.idFormaRetorno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormaRetorno [idFormaRetorno=" + idFormaRetorno + "]";
	}
    
}
