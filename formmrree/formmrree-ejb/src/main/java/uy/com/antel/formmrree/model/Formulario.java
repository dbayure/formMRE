package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import uy.com.antel.formmrree.enums.Estado;


@Entity
@XmlRootElement
@Table(name = "formulario")
public class Formulario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -703972235105949141L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Lob
	@Column(length = 500)
    private String observaciones;
    
	@Enumerated(EnumType.STRING)
    private Estado estado;
    
    @OneToOne(orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "funcionario_id", unique = false)
    private Funcionario funcionario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_entrevista")    
    private Date fechaEntrevista;
        
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    
    @OneToMany( mappedBy = "formulario", cascade = CascadeType.ALL , orphanRemoval = true )
    private Set<Persona> personas;

    public Formulario() {
    	super();
    	personas = new HashSet<Persona>();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaEntrevista() {
		return fechaEntrevista;
	}

	public void setFechaEntrevista(Date fechaEntrevista) {
		this.fechaEntrevista = fechaEntrevista;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((fechaEntrevista == null) ? 0 : fechaEntrevista.hashCode());
		result = prime * result
				+ ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Formulario other = (Formulario) obj;
		if (estado != other.estado)
			return false;
		if (fechaEntrevista == null) {
			if (other.fechaEntrevista != null)
				return false;
		} else if (!fechaEntrevista.equals(other.fechaEntrevista))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Formulario [id=" + id + ", fechaEntrevista=" + fechaEntrevista
				+ ", observaciones=" + observaciones + ", estado=" + estado
				+ ", funcionario=" + funcionario + ", fechaModificacion="
				+ fechaModificacion + ", personas=" + personas + "]";
	}
}
