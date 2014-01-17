package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Documento implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDocumento", nullable = false)
    private Integer idDocumento;
    @JoinColumn (name = "tipodocumento", referencedColumnName = "idTipo")
    @OneToOne(optional = false)
    private TipoDocumento tipoDocumento;
    @JoinColumn(name = "paisEmisor", referencedColumnName = "idPais")
    @OneToOne(optional = false)
    private Paises paisEmisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEmision")
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaExpiracion")
    private Date fechaExpiracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    private String numeroDoc;
	
    public Documento () {
    	
    }
    
    public Documento (Integer idDocumento) {
    	this.idDocumento = idDocumento;
    }
    
    public Documento(Integer idDocumento, TipoDocumento tipoDocumento,
			Paises paisEmisor, Date fechaNacimiento, Date fechaEmision,
			Date fechaExpiracion, String numeroDoc) {
		super();
		this.idDocumento = idDocumento;
		this.tipoDocumento = tipoDocumento;
		this.paisEmisor = paisEmisor;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaEmision = fechaEmision;
		this.fechaExpiracion = fechaExpiracion;
		this.numeroDoc = numeroDoc;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Paises getPaisEmisor() {
		return paisEmisor;
	}

	public void setPaisEmisor(Paises paisEmisor) {
		this.paisEmisor = paisEmisor;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDocumento == null) ? 0 : idDocumento.hashCode());
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
		Documento other = (Documento) obj;
		if (idDocumento == null) {
			if (other.idDocumento != null)
				return false;
		} else if (!idDocumento.equals(other.idDocumento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Documento [idDocumento=" + idDocumento + "]";
	}

    
    
}
