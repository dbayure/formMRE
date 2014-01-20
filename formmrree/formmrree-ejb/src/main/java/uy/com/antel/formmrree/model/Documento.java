package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "documento")
public class Documento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3090791953880881907L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
	
	@OneToOne @MapsId
    private TipoDocumento tipoDocumento;
    
    @OneToOne @MapsId       
    private Pais paisEmisor;
    
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision")
    private Date fechaEmision;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_expiracion")
    private Date fechaExpiracion;
    
    private String documento;

	public Documento() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Pais getPaisEmisor() {
		return paisEmisor;
	}

	public void setPaisEmisor(Pais paisEmisor) {
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
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
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null)
				return false;
		} else if (!tipoDocumento.equals(other.tipoDocumento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", tipoDocumento=" + tipoDocumento
				+ ", paisEmisor=" + paisEmisor + ", fechaNacimiento="
				+ fechaNacimiento + ", fechaEmision=" + fechaEmision
				+ ", fechaExpiracion=" + fechaExpiracion + ", documento="
				+ documento + "]";
	}
}
