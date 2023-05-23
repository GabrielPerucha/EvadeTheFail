package Movimientos;

public class Movimiento {

	protected String descripcion;
	protected String nombre;
	
	protected int dano;
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

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getCuracion() {
		return curacion;
	}

	public void setCuracion(int curacion) {
		this.curacion = curacion;
	}
	/**
	 * 
	 * @param descripcion
	 * @param nombre
	 */
	public Movimiento(String descripcion, String nombre) {
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
	}
	/**
	 * 
	 * @param descripcion
	 * @param nombre
	 * @param dano
	 * @param curacion
	 */
	public Movimiento(String descripcion, String nombre, int dano, int curacion) {
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.dano = dano;
		this.curacion = curacion;
	}
	
	
}
