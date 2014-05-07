package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "nivel_educativo_persona")
public class NivelEducativoPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6931416655288148069L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
	@JoinColumn(name="nivel_educativo_id", unique = false)
	private NivelEducativo nivelEducativo;
	
	private Boolean finalizado;

	public NivelEducativoPersona() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NivelEducativo getNivelEducativo() {
		return nivelEducativo;
	}

	public void setNivelEducativo(NivelEducativo nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	@Override
	public String toString() {
		return "NivelEducativoPersona [id=" + id + ", nivelEducativo="
				+ nivelEducativo + ", finalizado=" + finalizado + "]";
	}
}
