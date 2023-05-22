package Movimientos;

public class Movimiento {

	protected String descripcion;
	protected String nombre;
	
	protected int daño;
	protected int curacion;
	
	
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getCuracion() {
		return curacion;
	}

	public void setCuracion(int curacion) {
		this.curacion = curacion;
	}

	public Movimiento(String descripcion, String nombre) {
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public Movimiento(String descripcion, String nombre, int daño, int curacion) {
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.daño = daño;
		this.curacion = curacion;
	}
	
	
}
