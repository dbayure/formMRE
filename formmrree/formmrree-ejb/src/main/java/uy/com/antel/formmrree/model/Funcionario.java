package uy.com.antel.formmrree.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

public class Funcionario implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "idFuncionario", nullable = false)
	    private Integer idFuncionario;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(name = "nombre", nullable = false, length = 45)
	    private String nombre;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(name = "usuario", nullable = false, length = 45)
	    private String usuario;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(name = "password", nullable = false, length = 45)
	    private String password;
	    @Column(name = "telefono")
	    private Integer telefono;
	    @Size(max = 45)
	    @Column(name = "correo", length = 45)
	    private String correo;
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
	    private Collection<Formulario> formularioCollection;

	    public Funcionario() {
	    }

	    public Funcionario(Integer idFuncionario) {
	        this.idFuncionario = idFuncionario;
	    }

	    public Funcionario(Integer idFuncionario, String nombre, String usuario, String password) {
	        this.idFuncionario = idFuncionario;
	        this.nombre = nombre;
	        this.usuario = usuario;
	        this.password = password;
	    }

	    public Integer getIdFuncionario() {
	        return idFuncionario;
	    }

	    public void setIdFuncionario(Integer idFuncionario) {
	        this.idFuncionario = idFuncionario;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(String usuario) {
	        this.usuario = usuario;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public Integer getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(Integer telefono) {
	        this.telefono = telefono;
	    }

	    public String getCorreo() {
	        return correo;
	    }

	    public void setCorreo(String correo) {
	        this.correo = correo;
	    }

	    @XmlTransient
	    public Collection<Formulario> getFormularioCollection() {
	        return formularioCollection;
	    }

	    public void setFormularioCollection(Collection<Formulario> formularioCollection) {
	        this.formularioCollection = formularioCollection;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Funcionario)) {
	            return false;
	        }
	        Funcionario other = (Funcionario) object;
	        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "jpa.entities.Funcionario[ idFuncionario=" + idFuncionario + " ]";
	    }
	    

}
