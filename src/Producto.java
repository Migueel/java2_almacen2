
public abstract class Producto {
	
	private String procedencia;
	private Distribuidor distribuidor;
	
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	public Distribuidor getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}
}
