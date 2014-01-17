package uy.com.antel.formmrree.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "condiciones_residencia")
public class CodicionesResidencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6104234969983897562L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
