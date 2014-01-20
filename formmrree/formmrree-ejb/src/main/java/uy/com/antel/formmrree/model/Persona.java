package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "persona")
public class Persona implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5495749414331061120L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn ( name = "formulario_id", nullable = false )
    private Formulario formulario;
    
    @OneToOne @MapsId
    private Documento documento;
    
    private String nombre;
    private String apellido;
    private String direccion;
    
    @Column(name="telefono_fijo")
    private String telefonoFijo;
    
    @Column(name="telefono_movil")
    private String tellefonoMovil;
    private String correo;

    @OneToOne @MapsId
    @Column(name="estado_civil")
    private EstadoCivil estadoCivil;
    
    @Column(name = "cantidad_hijos")
    private int cantidadHijos;
    
    @OneToOne @MapsId
    private Parentezco parentezco;
    
    @OneToOne @MapsId
    private Sexo sexo;    
    
    @ManyToMany
    private Set<Nacionalidad> nacionalidades;
    
    @OneToOne @MapsId
    @Column(name="nivel_educativo_uruguay")
    private NivelEducativo nivelEducativoUruguay;
    
    @ManyToMany
    @Column(name="titulo_obtenido_uruguay")
    private Set<Titulo> tituloObtenidoUruguay;
    
    @OneToOne @MapsId
    @Column(name="oficio_uruguay")
    private Oficio oficioUruguay;
    
    @OneToOne @MapsId
    @Column(name="ocupacion_uruguay")
    private Ocupacion ocupacionUruguay;
    
    @OneToOne @MapsId
    private MotivoPartida motivoPartida;
    
    @Column(name = "anio_partida")
    private Integer anioPartida;
    
    @OneToMany( mappedBy = "persona", orphanRemoval = true )
    private Set<PaisResidencia> paisesResidencia;

    @OneToOne @MapsId
    @Column(name="nivel_educativo_exterior")
    private NivelEducativo nivelEducativoExterior;
    
    @ManyToMany
    @Column(name="titulo_obtenido_exterior")
    private Set<Titulo> tituloObtenidoExterior;    
    
    @OneToOne @MapsId
    @Column(name="oficio_exterior")
    private Oficio oficioExterior; 
    
    @OneToOne @MapsId
    @Column(name="ocupacion_exterior")
    private Ocupacion ocupacionExterior; 
    
    @OneToOne @MapsId
    private FormaRetorno formaRetorno;
    
    @OneToOne @MapsId
    private MotivoRetorno motivoRetorno;    
    
    @OneToOne @MapsId
    @Column(name="situacion_habitacional_actual")
    private SituacionHabitacional situacionHabitacionalActual;
    
    @OneToOne @MapsId
    @Column(name="cobertura_salud")
    private CoberturaSalud coberturaSalud;    
    
    @OneToOne @MapsId
    @Column(name="situacion_laboral")
    private SituacionLaboral situacionLaboral;
    
    @OneToOne @MapsId
    @Column(name="enseres_vehiculos")
    private EnseresVehiculos enseresVehiculos;   
    
    @OneToOne @MapsId
    @Column(name="demanda_inicial")
    private DemandaInicial demandaInicial;
    
    
    public Persona() {
    	super();
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Formulario getFormulario() {
		return formulario;
	}


	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}


	public Documento getDocumento() {
		return documento;
	}


	public void setDocumento(Documento documento) {
		this.documento = documento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefonoFijo() {
		return telefonoFijo;
	}


	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}


	public String getTellefonoMovil() {
		return tellefonoMovil;
	}


	public void setTellefonoMovil(String tellefonoMovil) {
		this.tellefonoMovil = tellefonoMovil;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public int getCantidadHijos() {
		return cantidadHijos;
	}


	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}


	public Parentezco getParentezco() {
		return parentezco;
	}


	public void setParentezco(Parentezco parentezco) {
		this.parentezco = parentezco;
	}


	public Sexo getSexo() {
		return sexo;
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	public Set<Nacionalidad> getNacionalidades() {
		return nacionalidades;
	}


	public void setNacionalidades(Set<Nacionalidad> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}


	public NivelEducativo getNivelEducativoUruguay() {
		return nivelEducativoUruguay;
	}


	public void setNivelEducativoUruguay(NivelEducativo nivelEducativoUruguay) {
		this.nivelEducativoUruguay = nivelEducativoUruguay;
	}


	public Set<Titulo> getTituloObtenidoUruguay() {
		return tituloObtenidoUruguay;
	}


	public void setTituloObtenidoUruguay(Set<Titulo> tituloObtenidoUruguay) {
		this.tituloObtenidoUruguay = tituloObtenidoUruguay;
	}


	public Oficio getOficioUruguay() {
		return oficioUruguay;
	}


	public void setOficioUruguay(Oficio oficioUruguay) {
		this.oficioUruguay = oficioUruguay;
	}


	public Ocupacion getOcupacionUruguay() {
		return ocupacionUruguay;
	}


	public void setOcupacionUruguay(Ocupacion ocupacionUruguay) {
		this.ocupacionUruguay = ocupacionUruguay;
	}


	public MotivoPartida getMotivoPartida() {
		return motivoPartida;
	}


	public void setMotivoPartida(MotivoPartida motivoPartida) {
		this.motivoPartida = motivoPartida;
	}


	public Integer getAnioPartida() {
		return anioPartida;
	}


	public void setAnioPartida(Integer anioPartida) {
		this.anioPartida = anioPartida;
	}


	public Set<PaisResidencia> getPaisesResidencia() {
		return paisesResidencia;
	}


	public void setPaisesResidencia(Set<PaisResidencia> paisesResidencia) {
		this.paisesResidencia = paisesResidencia;
	}


	public NivelEducativo getNivelEducativoExterior() {
		return nivelEducativoExterior;
	}


	public void setNivelEducativoExterior(NivelEducativo nivelEducativoExterior) {
		this.nivelEducativoExterior = nivelEducativoExterior;
	}


	public Set<Titulo> getTituloObtenidoExterior() {
		return tituloObtenidoExterior;
	}


	public void setTituloObtenidoExterior(Set<Titulo> tituloObtenidoExterior) {
		this.tituloObtenidoExterior = tituloObtenidoExterior;
	}


	public Oficio getOficioExterior() {
		return oficioExterior;
	}


	public void setOficioExterior(Oficio oficioExterior) {
		this.oficioExterior = oficioExterior;
	}


	public Ocupacion getOcupacionExterior() {
		return ocupacionExterior;
	}


	public void setOcupacionExterior(Ocupacion ocupacionExterior) {
		this.ocupacionExterior = ocupacionExterior;
	}


	public FormaRetorno getFormaRetorno() {
		return formaRetorno;
	}


	public void setFormaRetorno(FormaRetorno formaRetorno) {
		this.formaRetorno = formaRetorno;
	}


	public MotivoRetorno getMotivoRetorno() {
		return motivoRetorno;
	}


	public void setMotivoRetorno(MotivoRetorno motivoRetorno) {
		this.motivoRetorno = motivoRetorno;
	}


	public SituacionHabitacional getSituacionHabitacionalActual() {
		return situacionHabitacionalActual;
	}


	public void setSituacionHabitacionalActual(
			SituacionHabitacional situacionHabitacionalActual) {
		this.situacionHabitacionalActual = situacionHabitacionalActual;
	}


	public CoberturaSalud getCoberturaSalud() {
		return coberturaSalud;
	}


	public void setCoberturaSalud(CoberturaSalud coberturaSalud) {
		this.coberturaSalud = coberturaSalud;
	}


	public SituacionLaboral getSituacionLaboral() {
		return situacionLaboral;
	}


	public void setSituacionLaboral(SituacionLaboral situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}


	public EnseresVehiculos getEnseresVehiculos() {
		return enseresVehiculos;
	}


	public void setEnseresVehiculos(EnseresVehiculos enseresVehiculos) {
		this.enseresVehiculos = enseresVehiculos;
	}


	public DemandaInicial getDemandaInicial() {
		return demandaInicial;
	}


	public void setDemandaInicial(DemandaInicial demandaInicial) {
		this.demandaInicial = demandaInicial;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result
				+ ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
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
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", formulario=" + formulario
				+ ", documento=" + documento + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", direccion=" + direccion
				+ ", telefonoFijo=" + telefonoFijo + ", tellefonoMovil="
				+ tellefonoMovil + ", correo=" + correo + ", estadoCivil="
				+ estadoCivil + ", cantidadHijos=" + cantidadHijos
				+ ", parentezco=" + parentezco + ", sexo=" + sexo
				+ ", nacionalidades=" + nacionalidades
				+ ", nivelEducativoUruguay=" + nivelEducativoUruguay
				+ ", tituloObtenidoUruguay=" + tituloObtenidoUruguay
				+ ", oficioUruguay=" + oficioUruguay + ", ocupacionUruguay="
				+ ocupacionUruguay + ", motivoPartida=" + motivoPartida
				+ ", anioPartida=" + anioPartida + ", paisesResidencia="
				+ paisesResidencia + ", nivelEducativoExterior="
				+ nivelEducativoExterior + ", tituloObtenidoExterior="
				+ tituloObtenidoExterior + ", oficioExterior=" + oficioExterior
				+ ", ocupacionExterior=" + ocupacionExterior
				+ ", formaRetorno=" + formaRetorno + ", motivoRetorno="
				+ motivoRetorno + ", situacionHabitacionalActual="
				+ situacionHabitacionalActual + ", coberturaSalud="
				+ coberturaSalud + ", situacionLaboral=" + situacionLaboral
				+ ", enseresVehiculos=" + enseresVehiculos
				+ ", demandaInicial=" + demandaInicial + "]";
	}
}
