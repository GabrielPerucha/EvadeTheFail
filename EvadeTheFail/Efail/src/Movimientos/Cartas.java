package Movimientos;

public class Cartas extends Movimiento{

	//TO DO Creacion de cartas y establecer cuántas habrá y de que clase
	
	protected String elemento;
	protected String coste;
	public String getElemento() {
		return elemento;
	}
	
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	
	public String getCoste() {
		return coste;
	}
	
	public void setCoste(String coste) {
		this.coste = coste;
	}
	
	public Cartas(String descripcion, String nombre, String elemento, String coste) {
		super(descripcion, nombre);
		this.elemento = elemento;
		this.coste = coste;
	}
	
	
	
}
