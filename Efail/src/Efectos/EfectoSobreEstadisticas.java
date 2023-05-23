package Efectos;

public class EfectoSobreEstadisticas extends Efecto{
	
	/*
	 * Los efectos pueden aplicar un multiplicador, un sumador o ambas, por eso tienen tres constructores	
	 */
	
	protected double multiplicador;
	protected int sumador;
	protected int duracion;
	protected boolean objetivo;
	protected int retardo;
	
	
	
	public int getRetardo() {
		return retardo;
	}

	public void setRetardo(int retardo) {
		this.retardo = retardo;
	}

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
	 * @param retardo
	 */
	public EfectoSobreEstadisticas(double multiplicador, int sumador, int duracion, boolean objetivo, int retardo) {
		super();
		this.multiplicador = multiplicador;
		this.sumador = sumador;
		this.duracion = duracion;
		this.objetivo = objetivo;
		this.retardo = retardo;
	}

	/**
	 * 
	 * @param multiplicador
	 * @param duracion
	 * @param objetivo
	 * @param retardo
	 */
	public EfectoSobreEstadisticas(double multiplicador, int duracion, boolean objetivo, int retardo) {
		super();
		this.multiplicador = multiplicador;
		this.duracion = duracion;
		this.objetivo = objetivo;
		this.retardo = retardo;
	}

	/**
	 * 
	 * @param sumador
	 * @param duracion
	 * @param objetivo
	 * @param retardo
	 */
	public EfectoSobreEstadisticas(int sumador, int duracion, boolean objetivo, int retardo) {
		super();
		this.sumador = sumador;
		this.duracion = duracion;
		this.objetivo = objetivo;
		this.retardo = retardo;
	}

	
	
	
	//TO DO Programar más efectos y sus consecuencias una vez sea posible su comprobación.
	
}
