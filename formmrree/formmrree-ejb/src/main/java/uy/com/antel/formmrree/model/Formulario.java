package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

public class Formulario implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFormulario", nullable = false)
    private Integer idFormulario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrevista", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrevista;
    @Size(max = 500)
    @Column(name = "observaciones", length = 500)
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private char estado;
    @Column(name = "fechaModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumn(name = "funcionario", referencedColumnName = "idFuncionario", nullable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idformulario")
    private Collection<Persona> personas;

    public Formulario() {
    }

    public Formulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Formulario(Integer idFormulario, Date fechaEntrevista, char estado) {
        this.idFormulario = idFormulario;
        this.fechaEntrevista = fechaEntrevista;
        this.estado = estado;
    }

    public Integer getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
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

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @XmlTransient
    public Collection<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Collection<Persona> personas) {
		this.personas = personas;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormulario != null ? idFormulario.hashCode() : 0);
        return hash;
    }

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.idFormulario == null && other.idFormulario != null) || (this.idFormulario != null && !this.idFormulario.equals(other.idFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Formulario[ idFormulario=" + idFormulario + " ]";
    }
    

}
