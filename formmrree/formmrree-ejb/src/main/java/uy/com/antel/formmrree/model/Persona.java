package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPersona", nullable = false)
    private Integer idPersona;
    @JoinColumn(name = "idFormulario", referencedColumnName = "idFormulario", nullable = false)
    @ManyToOne(optional = false)
    private Formulario formulario;    
    @JoinColumn(name = "iddocumento", referencedColumnName = "idDocumento", nullable = false)
    @OneToOne(optional = false)
    private Documento iddocumento;   
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido", length = 45)
    private String apellido;
    @Size(max = 45)
    @Column(name = "direccion", length = 45)
    private String direccion;
    @Column(name = "telFijo")
    private String telFijo;
    @Column(name = "telMovil")
    private String telMovil;
    @Size(max = 45)
    @Column(name = "correo", length = 45)
    private String correo;
    @JoinColumn(name = "estadoCivil", referencedColumnName = "idEstadoCivil", nullable = false)
    @OneToOne(optional = false)
    private EstadoCivil estadoCivil;	    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantHijos", nullable = false)
    private int cantHijos;
    @JoinColumn(name = "parentezco", referencedColumnName = "idParentezco", nullable = false)
    @OneToOne(optional = false)
    private Parentezco parentezco;    
    @JoinColumn(name = "sexo", referencedColumnName = "idSexo", nullable = false)
    @OneToOne(optional = false)
    private Sexo sexo;    
    @JoinColumn(name = "nacionalidad1", referencedColumnName = "idNacionalidad")
    @OneToOne
    private Nacionalidad nacionalidad1;
    @JoinColumn(name = "nacionalidad2", referencedColumnName = "idNacionalidad")
    @OneToOne
    private Nacionalidad nacionalidad2;    
    @JoinColumn(name = "nivelEducativoUruguay", referencedColumnName = "idNivelEducativo")
    @OneToOne
    private NivelEducativo nivelEducativoUruguay;
    @Size(max = 45)
    @JoinColumn(name = "tituloObtenidoUruguay", referencedColumnName = "idTitulo")
    @OneToOne(optional = false)
    private Titulo tituloObtenidoUruguay;    
    @JoinColumn(name = "oficioUruguay", referencedColumnName = "idOficio")
    @OneToOne(optional = false)
    private Oficio oficioUruguay; 
    @JoinColumn(name = "ocupacionUruguay", referencedColumnName = "idOcupacion")
    @OneToOne(optional = false)
    private Ocupacion ocupacionUruguay; 
    @JoinColumn(name = "motivoPartida", referencedColumnName = "idMotivoPartida", nullable = false)
    @OneToOne(optional = false)
    private MotivoPartida motivoPartida;
    @Size(max = 4)
    @Column(name = "anioPartida")
    private int anioPartida;
    @JoinColumn(name = "paisResidencia1", referencedColumnName = "idPais")
    @OneToOne(optional = false)
    private Paises paisResidencia1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "residenciaRegular1", nullable = false)
    private boolean residenciaRegular1;
    @JoinColumn(name = "paisResidencia2", referencedColumnName = "idPais")
    @OneToOne(optional = true)
    private Paises paisResidencia2;
    @Basic
    @Column(name = "residenciaRegular2", nullable = true)
    private boolean residenciaRegular2;   
    @JoinColumn(name = "condicionesResidencia", referencedColumnName = "idCondicionesResidencia")
    @OneToOne(optional = false)
    private CondicionesResidencia condicionesResidencia;
    @JoinColumn(name = "nivelEducativoExterior", referencedColumnName = "idNivelEducativo")
    @OneToOne
    private NivelEducativo nivelEducativoExterior;
    @Size(max = 45)
    @JoinColumn(name = "tituloObtenidoExterior", referencedColumnName = "idTitulo")
    @OneToOne
    private Titulo tituloObtenidoExterior;    
    @JoinColumn(name = "oficioExterior", referencedColumnName = "idOficio")
    @OneToOne
    private Oficio oficioExterior; 
    @JoinColumn(name = "ocupacionExterior", referencedColumnName = "idOcupacion")
    @OneToOne(optional = false)
    private Ocupacion ocupacionExterior;    
    @JoinColumn(name = "formaRetorno", referencedColumnName = "idFormaRetorno")
    @OneToOne(optional = false)
    private FormaRetorno formaRetorno;
    @JoinColumn(name = "motivoRetorno", referencedColumnName = "idMotivoRetorno")
    @OneToOne(optional = false)
    private MotivoRetorno motivoRetorno;    
    @JoinColumn(name = "situacionHabitacionalActual", referencedColumnName = "idSituacionHabitacional", nullable = false)
    @OneToOne(optional = false)
    private SituacionHabitacional situacionHabitacionalActual;
    @JoinColumn(name = "coberturaSalud", referencedColumnName = "idCoberturaSalud", nullable = false)
    @OneToOne(optional = false)
    private CoberturaSalud coberturaSalud;    
    @JoinColumn(name = "situacionLaboral", referencedColumnName = "idSituacionLaboral", nullable = false)
    @OneToOne(optional = false)
    private SituacionLaboral situacionLaboral;
    @JoinColumn(name = "enseresVehiculos", referencedColumnName = "idEnseresVehiculos", nullable = false)
    @OneToOne(optional = false)
    private EnseresVehiculos enseresVehiculos;    
    @JoinColumn(name = "demandaInicial", referencedColumnName = "idDemandaInicial", nullable = false)
    @OneToOne(optional = false)
    private DemandaInicial demandaInicial;
    
    
    public Persona () {
    	
    }
        
    public Persona (Integer idPersona){
    	this.idPersona = idPersona;
    }
	public Persona(Integer idPersona, Formulario formulario,
			Documento iddocumento, String nombre, String apellido,
			String direccion, String telFijo, String telMovil, String correo,
			EstadoCivil estadoCivil, int cantHijos, Parentezco parentezco,
			Sexo sexo, Nacionalidad nacionalidad1, Nacionalidad nacionalidad2,
			NivelEducativo nivelEducativoUruguay, Titulo tituloObtenidoUruguay,
			Oficio oficioUruguay, Ocupacion ocupacionUruguay,
			MotivoPartida motivoPartida, int anioPartida,
			Paises paisResidencia1, boolean residenciaRegular1,
			Paises paisResidencia2, boolean residenciaRegular2,
			CondicionesResidencia condicionesResidencia,
			NivelEducativo nivelEducativoExterior,
			Titulo tituloObtenidoExterior, Oficio oficioExterior,
			Ocupacion ocupacionExterior, FormaRetorno formaRetorno,
			MotivoRetorno motivoRetorno,
			SituacionHabitacional situacionHabitacionalActual,
			CoberturaSalud coberturaSalud, SituacionLaboral situacionLaboral,
			EnseresVehiculos enseresVehiculos, DemandaInicial demandaInicial) {
		super();
		this.idPersona = idPersona;
		this.formulario = formulario;
		this.iddocumento = iddocumento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telFijo = telFijo;
		this.telMovil = telMovil;
		this.correo = correo;
		this.estadoCivil = estadoCivil;
		this.cantHijos = cantHijos;
		this.parentezco = parentezco;
		this.sexo = sexo;
		this.nacionalidad1 = nacionalidad1;
		this.nacionalidad2 = nacionalidad2;
		this.nivelEducativoUruguay = nivelEducativoUruguay;
		this.tituloObtenidoUruguay = tituloObtenidoUruguay;
		this.oficioUruguay = oficioUruguay;
		this.ocupacionUruguay = ocupacionUruguay;
		this.motivoPartida = motivoPartida;
		this.anioPartida = anioPartida;
		this.paisResidencia1 = paisResidencia1;
		this.residenciaRegular1 = residenciaRegular1;
		this.paisResidencia2 = paisResidencia2;
		this.residenciaRegular2 = residenciaRegular2;
		this.condicionesResidencia = condicionesResidencia;
		this.nivelEducativoExterior = nivelEducativoExterior;
		this.tituloObtenidoExterior = tituloObtenidoExterior;
		this.oficioExterior = oficioExterior;
		this.ocupacionExterior = ocupacionExterior;
		this.formaRetorno = formaRetorno;
		this.motivoRetorno = motivoRetorno;
		this.situacionHabitacionalActual = situacionHabitacionalActual;
		this.coberturaSalud = coberturaSalud;
		this.situacionLaboral = situacionLaboral;
		this.enseresVehiculos = enseresVehiculos;
		this.demandaInicial = demandaInicial;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public Formulario getFormulario() {
		return formulario;
	}
	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}
	public Documento getIddocumento() {
		return iddocumento;
	}
	public void setIddocumento(Documento iddocumento) {
		this.iddocumento = iddocumento;
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
	public String getTelFijo() {
		return telFijo;
	}
	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}
	public String getTelMovil() {
		return telMovil;
	}
	public void setTelMovil(String telMovil) {
		this.telMovil = telMovil;
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
	public int getCantHijos() {
		return cantHijos;
	}
	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
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
	public Nacionalidad getNacionalidad1() {
		return nacionalidad1;
	}
	public void setNacionalidad1(Nacionalidad nacionalidad1) {
		this.nacionalidad1 = nacionalidad1;
	}
	public Nacionalidad getNacionalidad2() {
		return nacionalidad2;
	}
	public void setNacionalidad2(Nacionalidad nacionalidad2) {
		this.nacionalidad2 = nacionalidad2;
	}
	public NivelEducativo getNivelEducativoUruguay() {
		return nivelEducativoUruguay;
	}
	public void setNivelEducativoUruguay(NivelEducativo nivelEducativoUruguay) {
		this.nivelEducativoUruguay = nivelEducativoUruguay;
	}
	public Titulo getTituloObtenidoUruguay() {
		return tituloObtenidoUruguay;
	}
	public void setTituloObtenidoUruguay(Titulo tituloObtenidoUruguay) {
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
	public int getAnioPartida() {
		return anioPartida;
	}
	public void setAnioPartida(int anioPartida) {
		this.anioPartida = anioPartida;
	}
	public Paises getPaisResidencia1() {
		return paisResidencia1;
	}
	public void setPaisResidencia1(Paises paisResidencia1) {
		this.paisResidencia1 = paisResidencia1;
	}
	public boolean isResidenciaRegular1() {
		return residenciaRegular1;
	}
	public void setResidenciaRegular1(boolean residenciaRegular1) {
		this.residenciaRegular1 = residenciaRegular1;
	}
	public Paises getPaisResidencia2() {
		return paisResidencia2;
	}
	public void setPaisResidencia2(Paises paisResidencia2) {
		this.paisResidencia2 = paisResidencia2;
	}
	public boolean isResidenciaRegular2() {
		return residenciaRegular2;
	}
	public void setResidenciaRegular2(boolean residenciaRegular2) {
		this.residenciaRegular2 = residenciaRegular2;
	}
	public CondicionesResidencia getCondicionesResidencia() {
		return condicionesResidencia;
	}
	public void setCondicionesResidencia(CondicionesResidencia condicionesResidencia) {
		this.condicionesResidencia = condicionesResidencia;
	}
	public NivelEducativo getNivelEducativoExterior() {
		return nivelEducativoExterior;
	}
	public void setNivelEducativoExterior(NivelEducativo nivelEducativoExterior) {
		this.nivelEducativoExterior = nivelEducativoExterior;
	}
	public Titulo getTituloObtenidoExterior() {
		return tituloObtenidoExterior;
	}
	public void setTituloObtenidoExterior(Titulo tituloObtenidoExterior) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPersona == null) ? 0 : idPersona.hashCode());
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
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + "]";
	}
	

}
