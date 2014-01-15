package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPersona", nullable = false)
    private Integer idPersona;
    @Size(max = 45)
    @Column(name = "direccion", length = 45)
    private String direccion;
    @Column(name = "telFijo")
    private Integer telFijo;
    @Column(name = "telMovil")
    private Integer telMovil;
    @Size(max = 45)
    @Column(name = "correo", length = 45)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantHijos", nullable = false)
    private int cantHijos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "motivoRetorno", nullable = false)
    private int motivoRetorno;
    @Size(max = 45)
    @Column(name = "tituloObtenido", length = 45)
    private String tituloObtenido;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido", length = 45)
    private String apellido;
    @Column(name = "estudioFinalizadoUruguay")
    private Character estudioFinalizadoUruguay;
    @Column(name = "estudioFinalizadoExterior")
    private Character estudioFinalizadoExterior;
    @Size(max = 45)
    @Column(name = "tituloObtenidoExterior", length = 45)
    private String tituloObtenidoExterior;
    @OneToMany(mappedBy = "idPersona")
    private Collection<PaisesVisitados> paisesVisitadosCollection;
    @JoinColumn(name = "situacionLaboral", referencedColumnName = "idSituacionLaboral", nullable = false)
    @ManyToOne(optional = false)
    private SituacionLaboral situacionLaboral;
    @JoinColumn(name = "sexo", referencedColumnName = "idSexo", nullable = false)
    @ManyToOne(optional = false)
    private Sexo sexo;
    @JoinColumn(name = "coberturaSalud", referencedColumnName = "idCoberturaSalud", nullable = false)
    @ManyToOne(optional = false)
    private CoberturaSalud coberturaSalud;
    @JoinColumn(name = "parentezco", referencedColumnName = "idParentezco", nullable = false)
    @ManyToOne(optional = false)
    private Parentezco parentezco;
    @JoinColumn(name = "otraNacionalidad", referencedColumnName = "idNacionalidad")
    @ManyToOne
    private Nacionalidad otraNacionalidad;
    @JoinColumn(name = "oficioExterior", referencedColumnName = "idOficio")
    @ManyToOne
    private Oficio oficioExterior;
    @JoinColumn(name = "oficioUruguay", referencedColumnName = "idOficio", nullable = false)
    @ManyToOne(optional = false)
    private Oficio oficioUruguay;
    @JoinColumn(name = "ocupacionExterior", referencedColumnName = "idOcupacion", nullable = false)
    @ManyToOne(optional = false)
    private Ocupacion ocupacionExterior;
    @JoinColumn(name = "condResidExterior", referencedColumnName = "idCodicionesResidencia", nullable = false)
    @ManyToOne(optional = false)
    private CodicionesResidencia condResidExterior;
    @JoinColumn(name = "demandaInicial", referencedColumnName = "idDemandaInicial", nullable = false)
    @ManyToOne(optional = false)
    private DemandaInicial demandaInicial;
    @JoinColumn(name = "documento", referencedColumnName = "idDocumento", nullable = false)
    @OneToOne(optional = false)
    private Documento documento;
    @JoinColumn(name = "nivelEducativoUruguay", referencedColumnName = "idNivelEducativo", nullable = false)
    @ManyToOne(optional = false)
    private NivelEducativo nivelEducativoUruguay;
    @JoinColumn(name = "enseresVehiculos", referencedColumnName = "idEnseresVehiculos", nullable = false)
    @ManyToOne(optional = false)
    private EnseresVehiculos enseresVehiculos;
    @JoinColumn(name = "estadoCivil", referencedColumnName = "idEstadoCivil", nullable = false)
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivil;
    @JoinColumn(name = "idFormulario", referencedColumnName = "idFormulario", nullable = false)
    @ManyToOne(optional = false)
    private Formulario Formulario;
   	@JoinColumn(name = "formaRetorno", referencedColumnName = "idFormaRetorno", nullable = false)
    @ManyToOne(optional = false)
    private FormaRetorno formaRetorno;
    @JoinColumn(name = "solucionHabitacional", referencedColumnName = "idSituacionHabitacional", nullable = false)
    @ManyToOne(optional = false)
    private SituacionHabitacional solucionHabitacional;
    @JoinColumn(name = "motivoPartida", referencedColumnName = "idMotivoPartida", nullable = false)
    @ManyToOne(optional = false)
    private MotivoPartida motivoPartida;
    @JoinColumn(name = "nacionalidad", referencedColumnName = "idNacionalidad", nullable = false)
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidad;
    @JoinColumn(name = "nivelEducativoExterior", referencedColumnName = "idNivelEducativo")
    @ManyToOne
    private NivelEducativo nivelEducativoExterior;
    @JoinColumn(name = "ocupacionPrevia", referencedColumnName = "idOcupacion", nullable = false)
    @ManyToOne(optional = false)
    private Ocupacion ocupacionPrevia;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, Date fechaNacimiento, int cantHijos, int motivoRetorno) {
        this.idPersona = idPersona;
        this.fechaNacimiento = fechaNacimiento;
        this.cantHijos = cantHijos;
        this.motivoRetorno = motivoRetorno;
    }

    public Formulario getFormulario() {
		return Formulario;
	}

	public void setFormulario(Formulario formulario) {
		Formulario = formulario;
	}


    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(Integer telFijo) {
        this.telFijo = telFijo;
    }

    public Integer getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(Integer telMovil) {
        this.telMovil = telMovil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(int cantHijos) {
        this.cantHijos = cantHijos;
    }

    public int getMotivoRetorno() {
        return motivoRetorno;
    }

    public void setMotivoRetorno(int motivoRetorno) {
        this.motivoRetorno = motivoRetorno;
    }

    public String getTituloObtenido() {
        return tituloObtenido;
    }

    public void setTituloObtenido(String tituloObtenido) {
        this.tituloObtenido = tituloObtenido;
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

    public Character getEstudioFinalizadoUruguay() {
        return estudioFinalizadoUruguay;
    }

    public void setEstudioFinalizadoUruguay(Character estudioFinalizadoUruguay) {
        this.estudioFinalizadoUruguay = estudioFinalizadoUruguay;
    }

    public Character getEstudioFinalizadoExterior() {
        return estudioFinalizadoExterior;
    }

    public void setEstudioFinalizadoExterior(Character estudioFinalizadoExterior) {
        this.estudioFinalizadoExterior = estudioFinalizadoExterior;
    }

    public String getTituloObtenidoExterior() {
        return tituloObtenidoExterior;
    }

    public void setTituloObtenidoExterior(String tituloObtenidoExterior) {
        this.tituloObtenidoExterior = tituloObtenidoExterior;
    }

    @XmlTransient
    public Collection<PaisesVisitados> getPaisesVisitadosCollection() {
        return paisesVisitadosCollection;
    }

    public void setPaisesVisitadosCollection(Collection<PaisesVisitados> paisesVisitadosCollection) {
        this.paisesVisitadosCollection = paisesVisitadosCollection;
    }

    public SituacionLaboral getSituacionLaboral() {
        return situacionLaboral;
    }

    public void setSituacionLaboral(SituacionLaboral situacionLaboral) {
        this.situacionLaboral = situacionLaboral;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public CoberturaSalud getCoberturaSalud() {
        return coberturaSalud;
    }

    public void setCoberturaSalud(CoberturaSalud coberturaSalud) {
        this.coberturaSalud = coberturaSalud;
    }

    public Parentezco getParentezco() {
        return parentezco;
    }

    public void setParentezco(Parentezco parentezco) {
        this.parentezco = parentezco;
    }

    public Nacionalidad getOtraNacionalidad() {
        return otraNacionalidad;
    }

    public void setOtraNacionalidad(Nacionalidad otraNacionalidad) {
        this.otraNacionalidad = otraNacionalidad;
    }

    public Oficio getOficioExterior() {
        return oficioExterior;
    }

    public void setOficioExterior(Oficio oficioExterior) {
        this.oficioExterior = oficioExterior;
    }

    public Oficio getOficioUruguay() {
        return oficioUruguay;
    }

    public void setOficioUruguay(Oficio oficioUruguay) {
        this.oficioUruguay = oficioUruguay;
    }

    public Ocupacion getOcupacionExterior() {
        return ocupacionExterior;
    }

    public void setOcupacionExterior(Ocupacion ocupacionExterior) {
        this.ocupacionExterior = ocupacionExterior;
    }

    public CodicionesResidencia getCondResidExterior() {
        return condResidExterior;
    }

    public void setCondResidExterior(CodicionesResidencia condResidExterior) {
        this.condResidExterior = condResidExterior;
    }

    public DemandaInicial getDemandaInicial() {
        return demandaInicial;
    }

    public void setDemandaInicial(DemandaInicial demandaInicial) {
        this.demandaInicial = demandaInicial;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public NivelEducativo getNivelEducativoUruguay() {
        return nivelEducativoUruguay;
    }

    public void setNivelEducativoUruguay(NivelEducativo nivelEducativoUruguay) {
        this.nivelEducativoUruguay = nivelEducativoUruguay;
    }

    public EnseresVehiculos getEnseresVehiculos() {
        return enseresVehiculos;
    }

    public void setEnseresVehiculos(EnseresVehiculos enseresVehiculos) {
        this.enseresVehiculos = enseresVehiculos;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public FormaRetorno getFormaRetorno() {
        return formaRetorno;
    }

    public void setFormaRetorno(FormaRetorno formaRetorno) {
        this.formaRetorno = formaRetorno;
    }

    public SituacionHabitacional getSolucionHabitacional() {
        return solucionHabitacional;
    }

    public void setSolucionHabitacional(SituacionHabitacional solucionHabitacional) {
        this.solucionHabitacional = solucionHabitacional;
    }

    public MotivoPartida getMotivoPartida() {
        return motivoPartida;
    }

    public void setMotivoPartida(MotivoPartida motivoPartida) {
        this.motivoPartida = motivoPartida;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public NivelEducativo getNivelEducativoExterior() {
        return nivelEducativoExterior;
    }

    public void setNivelEducativoExterior(NivelEducativo nivelEducativoExterior) {
        this.nivelEducativoExterior = nivelEducativoExterior;
    }

    public Ocupacion getOcupacionPrevia() {
        return ocupacionPrevia;
    }

    public void setOcupacionPrevia(Ocupacion ocupacionPrevia) {
        this.ocupacionPrevia = ocupacionPrevia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Persona[ idPersona=" + idPersona + " ]";
    }

}
