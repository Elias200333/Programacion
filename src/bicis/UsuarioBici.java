package bicis;

public class UsuarioBici {
	private String usuario;
	private int traslados;
	private int circular;
	private int total;
	
	public UsuarioBici(String usuario) {
		this.usuario = usuario;
		this.traslados = 0;
		this.circular = 0;
		this.total = 0;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getTraslados() {
		return traslados;
	}

	public void setTraslados(int traslados) {
		this.traslados = traslados;
	}

	public int getCircular() {
		return circular;
	}

	public void setCircular(int circular) {
		this.circular = circular;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
