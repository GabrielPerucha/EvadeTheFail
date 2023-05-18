package Movimientos;

public class Ataque extends Movimiento{

	protected int probabilidad;

	public int getProbabilidad() {
		return probabilidad;
	}

	public Ataque(String descripcion, String nombre, int daño, int duracion, int probabilidad) {
		super(descripcion, nombre, daño, duracion);
		this.probabilidad = probabilidad;
	}
	
	
}
