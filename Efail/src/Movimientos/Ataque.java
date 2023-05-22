package Movimientos;

import Efectos.EfectoEspecial;
import Efectos.EfectoSobreEstadisticas;

public class Ataque extends Movimiento{

	protected int probabilidad;
	protected EfectoSobreEstadisticas[] efectos;
	protected EfectoEspecial efectoEspecial;
	
	public int getProbabilidad() {
		return probabilidad;
	}
	
	public EfectoSobreEstadisticas[] getEfectos() {
		return efectos;
	}

	public void setEfectos(EfectoSobreEstadisticas[] efectos) {
		this.efectos = efectos;
	}

	public EfectoEspecial getEfectoEspecial() {
		return efectoEspecial;
	}

	public void setEfectoEspecial(EfectoEspecial efectoEspecial) {
		this.efectoEspecial = efectoEspecial;
	}

	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}

	
	/**
	 * 
	 * @param descripcion
	 * @param nombre
	 * @param probabilidad
	 * @param efectos
	 * @param efectoEspecial
	 */
	public Ataque(String descripcion, String nombre, int probabilidad, EfectoSobreEstadisticas[] efectos,
			EfectoEspecial efectoEspecial) {
		super(descripcion, nombre);
		this.probabilidad = probabilidad;
		this.efectos = efectos;
		this.efectoEspecial = efectoEspecial;
	}

	/**
	 * 
	 * @param descripcion
	 * @param nombre
	 * @param probabilidad
	 * @param efectos
	 */
	public Ataque(String descripcion, String nombre, int probabilidad, EfectoSobreEstadisticas[] efectos) {
		super(descripcion, nombre);
		this.probabilidad = probabilidad;
		this.efectos = efectos;
	}
	
	//Falta la creación de ataques y ver dónde se crean.
}
