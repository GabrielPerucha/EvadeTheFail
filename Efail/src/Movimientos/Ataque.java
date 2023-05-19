package Movimientos;

public class Ataque extends Movimiento{

	protected int probabilidad;

	public int getProbabilidad() {
		return probabilidad;
	}

	public Ataque(String descripcion, String nombre, int daño, int curacion, int probabilidad) {
		super(descripcion, nombre, daño, curacion);
		this.probabilidad = probabilidad;
	}
	
	//Falta la creación de ataques y ver dónde se crean.
}
