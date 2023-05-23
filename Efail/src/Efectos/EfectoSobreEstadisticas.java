package Efectos;

public class EfectoSobreEstadisticas extends Efecto{
	
	protected double multiplicador;
	protected int sumador;
	protected int duracion;
	protected boolean objetivo;
	
	public double getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}

	public int getSumador() {
		return sumador;
	}

	public void setSumador(int sumador) {
		this.sumador = sumador;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isObjetivo() {
		return objetivo;
	}

	public void setObjetivo(boolean objetivo) {
		this.objetivo = objetivo;
	}

	/**
	 * 
	 * @param multiplicador
	 * @param sumador
	 * @param duracion
	 * @param objetivo
	 */
	public EfectoSobreEstadisticas(double multiplicador, int sumador, int duracion, boolean objetivo) {
		this.multiplicador = multiplicador;
		this.sumador = sumador;
		this.duracion = duracion;
		this.objetivo = objetivo;
	}
	
	/**
	 * 
	 * @param sumador
	 * @param duracion
	 * @param objetivo
	 */
	public EfectoSobreEstadisticas(int sumador, int duracion, boolean objetivo) {
		this.sumador = sumador;
		this.duracion = duracion;
		this.objetivo = objetivo;
	}
	
	/**
	 * 
	 * @param multiplicador
	 * @param duracion
	 * @param objetivo
	 */
	public EfectoSobreEstadisticas(double multiplicador, int duracion, boolean objetivo) {
		this.multiplicador = multiplicador;
		this.duracion = duracion;
		this.objetivo = objetivo;
	}
	
	//TO DO Programar más efectos y sus consecuencias una vez sea posible su comprobación.
	
}
