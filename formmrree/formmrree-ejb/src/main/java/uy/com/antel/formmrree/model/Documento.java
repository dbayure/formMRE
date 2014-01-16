package uy.com.antel.formmrree.model;

public class Documento implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDocumento", nullable = false)
    private Integer idDocumento;
    @JoinColumn (name = "tipodocumento", referencedColumnname = "idTipo")
    @ManyToOne(optional = false)
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

}
