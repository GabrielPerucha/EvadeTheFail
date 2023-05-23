package Efectos;

public class EfectoEspecial {
	
	protected String descripcion;
	protected EfectoSobreEstadisticas[] efectos;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public EfectoSobreEstadisticas[] getEfectos() {
		return efectos;
	}
	public void setEfectos(EfectoSobreEstadisticas[] efectos) {
		this.efectos = efectos;
	}
	public EfectoEspecial(String descripcion, EfectoSobreEstadisticas[] efectos) {
		super();
		this.descripcion = descripcion;
		this.efectos = efectos;
	}
	
}
