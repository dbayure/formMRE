package uy.com.antel.formmrree.enums;

public enum Estado {
	
	ALTA("A"),
	BAJA("B");
	
	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private Estado(String estado) {
		this.estado = estado;
	}
	
}
