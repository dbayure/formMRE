package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Titulo implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTitulo", nullable = false)
    private Integer idTitulo;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;

public Titulo (){
	
}

public Titulo (Integer idTitulo){
	this.idTitulo = idTitulo;
}

public Titulo(Integer idTitulo, String descripcion) {
	super();
	this.idTitulo = idTitulo;
	this.descripcion = descripcion;
}

public Integer getIdTitulo() {
	return idTitulo;
}

public void setIdTitulo(Integer idTitulo) {
	this.idTitulo = idTitulo;
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
	result = prime * result + ((idTitulo == null) ? 0 : idTitulo.hashCode());
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
	Titulo other = (Titulo) obj;
	if (idTitulo == null) {
		if (other.idTitulo != null)
			return false;
	} else if (!idTitulo.equals(other.idTitulo))
		return false;
	return true;
}

@Override
public String toString() {
	return "Titulo [idTitulo=" + idTitulo + "]";
}

}

