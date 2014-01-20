package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


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
    
    private char estado;
    
    @OneToOne @MapsId
    private Funcionario funcionario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_entrevista")    
    private Date fechaEntrevista;
        
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    
    @OneToMany( mappedBy = "formulario", orphanRemoval = true )
    private Set<Persona> personas;

    public Formulario() {
    	super();
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

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
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
		result = prime * result + estado;
		result = prime * result
				+ ((fechaEntrevista == null) ? 0 : fechaEntrevista.hashCode());
		result = prime
				* result
				+ ((fechaModificacion == null) ? 0 : fechaModificacion
						.hashCode());
		result = prime * result
				+ ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result
				+ ((personas == null) ? 0 : personas.hashCode());
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
		if (fechaModificacion == null) {
			if (other.fechaModificacion != null)
				return false;
		} else if (!fechaModificacion.equals(other.fechaModificacion))
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
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (personas == null) {
			if (other.personas != null)
				return false;
		} else if (!personas.equals(other.personas))
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
