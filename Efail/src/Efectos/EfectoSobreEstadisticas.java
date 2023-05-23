package Efectos;

public class EfectoSobreEstadisticas extends Efecto{
	
	protected double multiplicador;
	protected int sumador;
	protected int duracion;
	
	
	public EfectoSobreEstadisticas(double multiplicador, int sumador, int duracion) {
		this.multiplicador = multiplicador;
		this.sumador = sumador;
		this.duracion = duracion;
	}
	
	public EfectoSobreEstadisticas(int sumador, int duracion) {
		this.sumador = sumador;
		this.duracion = duracion;
	}
	
	public EfectoSobreEstadisticas(double multiplicador, int duracion) {
		this.multiplicador = multiplicador;
		this.duracion = duracion;
	}
	
	//TO DO Programar más efectos y sus consecuencias una vez sea posible su comprobación.
	
}
