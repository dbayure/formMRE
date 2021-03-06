/*

FORMMRREEANTEL - Formulario Ministerio Relaciones Exteriores
Copyright (C) 2009  ANTEL - MRREE

This file is part of FORMMRREEANTEL.

FORMMRREEANTEL is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 
*/
package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn ( name = "formulario_id", referencedColumnName = "id" )
    private Formulario formulario;
    
    @OneToOne(optional = false, cascade = CascadeType.ALL,  orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "documento_id")
    private Documento documento;
    
    private String nombre;
    private String apellido;
    private String direccion;
    
    @Column(name="telefono_fijo")
    private String telefonoFijo;
    
    @Column(name="telefono_movil")
    private String tellefonoMovil;
    private String correo;

    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name="estado_civil_id", unique = false)
    private EstadoCivil estadoCivil;
    
    @Column(name = "cantidad_hijos")
    private int cantidadHijos;
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentezco_id", unique = false)
    private Parentezco parentezco;
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "sexo_id", unique = false)
    private Sexo sexo;    
    
    @ManyToMany (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "persona_nacionalidad", 
    		joinColumns = {@JoinColumn(name = "persona_id", referencedColumnName = "id")},
    		inverseJoinColumns = {@JoinColumn(name = "nacionalidades_id", referencedColumnName = "id")})
    private Set<Nacionalidad> nacionalidades;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinTable(name = "nivel_educativo_uruguay",
    		joinColumns = @JoinColumn(name="persona_id", referencedColumnName="id"),
    		inverseJoinColumns = @JoinColumn(name="nivel_educativo_persona_id", referencedColumnName="id"))
    private NivelEducativoPersona nivelEducativoUruguay;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "persona_titulo_uruguay",
    		joinColumns = {@JoinColumn(name="persona_id", referencedColumnName="id")},
    		inverseJoinColumns = {@JoinColumn(name="titulo_obtenido_uruguay_id", referencedColumnName="id")})
    private Set<Titulo> tituloObtenidoUruguay;
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinTable(name = "oficio_uruguay",
		joinColumns = @JoinColumn(name="persona_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="oficio_uruguay_id", referencedColumnName="id"))
    private Oficio oficioUruguay;
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinTable(name = "ocupacion_uruguay",
		joinColumns = @JoinColumn(name="persona_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="ocupacion_uruguay_id", referencedColumnName="id"))
    private Ocupacion ocupacionUruguay;
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name="motivo_partida_id")
    private MotivoPartida motivoPartida;
    
    @Column(name = "fecha_partida")
    @Temporal(TemporalType.DATE)
    private Date fechaPartida;
    
    @OneToOne( mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)    
    private PaisResidencia paisResidencia;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinTable(name = "nivel_educativo_exterior",
		joinColumns = @JoinColumn(name="persona_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="nivel_educativo_persona_id", referencedColumnName="id"))
    private NivelEducativoPersona nivelEducativoExterior;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "persona_titulo_exterior",
			joinColumns = {@JoinColumn(name="persona_id", referencedColumnName="id")},
			inverseJoinColumns = {@JoinColumn(name="titulo_obtenido_exterior_id", referencedColumnName="id")})
    private Set<Titulo> tituloObtenidoExterior;    
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinTable(name = "oficio_exterior",
		joinColumns = @JoinColumn(name="persona_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="oficio_exterior_id", referencedColumnName="id"))
    private Oficio oficioExterior; 
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinTable(name = "ocupacion_exterior",
		joinColumns = @JoinColumn(name="persona_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="ocupacion_exterior_id", referencedColumnName="id"))
    private Ocupacion ocupacionExterior; 
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name="forma_retorno_id")
    private FormaRetorno formaRetorno;
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name="motivo_retorno_id")
    private MotivoRetorno motivoRetorno;    
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name="situacion_habitacional_actual_id", unique = false)
    private SituacionHabitacional situacionHabitacionalActual;
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name="cobertura_salud_id", unique = false)
    private CoberturaSalud coberturaSalud;    
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name="situacion_laboral_id", unique = false)
    private SituacionLaboral situacionLaboral;
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name="enseres_vehiculos_id", unique = false)
    private EnseresVehiculos enseresVehiculos;   
    
    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name="demanda_inicial_id", unique = false)
    private DemandaInicial demandaInicial;
    
    
    public Persona() {
    	super();
    	documento = new Documento();
    	paisResidencia = new PaisResidencia();
    	nivelEducativoUruguay = new NivelEducativoPersona();
    	nivelEducativoExterior = new NivelEducativoPersona();
    	nacionalidades =  new HashSet<Nacionalidad>();
    	tituloObtenidoUruguay = new HashSet<Titulo>();
    	tituloObtenidoExterior = new HashSet<Titulo>();
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

	
	public List<Nacionalidad> getListNacionalidades (){
		return (new ArrayList<Nacionalidad>(nacionalidades));
	}

	public void setListNacionalidades(List<Nacionalidad> nac){
		this.nacionalidades = new HashSet<Nacionalidad>(nac);
	}
	
	public NivelEducativoPersona getNivelEducativoUruguay() {
		return nivelEducativoUruguay;
	}


	public void setNivelEducativoUruguay(NivelEducativoPersona nivelEducativoUruguay) {
		this.nivelEducativoUruguay = nivelEducativoUruguay;
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


	public Date getFechaPartida() {
		return fechaPartida;
	}


	public void setFechaPartida(Date fechaPartida) {
		this.fechaPartida = fechaPartida;
	}


	public PaisResidencia getPaisResidencia() {
		return paisResidencia;
	}


	public void setPaisResidencia(PaisResidencia paisResidencia) {
		this.paisResidencia = paisResidencia;
	}

	public NivelEducativoPersona getNivelEducativoExterior() {
		return nivelEducativoExterior;
	}


	public void setNivelEducativoExterior(NivelEducativoPersona nivelEducativoExterior) {
		this.nivelEducativoExterior = nivelEducativoExterior;
	}

	public Set<Titulo> getTituloObtenidoUruguay() {
		return tituloObtenidoUruguay;
	}

	public Set<Titulo> getTituloObtenidoExterior() {
		return tituloObtenidoExterior;
	}
	
	public void setTituloObtenidoUruguay(Set<Titulo> tituloObtenidoUruguay) {
		this.tituloObtenidoUruguay = tituloObtenidoUruguay;
	}

	public void setTituloObtenidoExterior(Set<Titulo> tituloObtenidoExterior) {
		this.tituloObtenidoExterior = tituloObtenidoExterior;
	}
	
	
	
	
	public List<Titulo> getListTituloObtenidoUruguay(){
		return (new ArrayList<Titulo>(this.tituloObtenidoUruguay));
	}
	
	public List<Titulo> getListTituloObtenidoExterior (){
		return (new ArrayList<Titulo>(this.tituloObtenidoExterior));
	}
	
	public void setListTituloObtenidoUruguay(List<Titulo> titulo){
		this.tituloObtenidoUruguay =  new HashSet<Titulo>(titulo);
	}
	
	public void setListTituloObtenidoExterior (List<Titulo> titulo){
		this.tituloObtenidoExterior = new HashSet<Titulo>(titulo);
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
				+ ", fechaPartida=" + fechaPartida + ", paisResidencia="
				+ paisResidencia + ", nivelEducativoExterior="
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