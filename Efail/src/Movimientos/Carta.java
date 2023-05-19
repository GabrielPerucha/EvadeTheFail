package Movimientos;

public class Carta extends Movimiento{

	//TO DO Creacion de cartas y establecer cuántas habrá y de que clase

	protected String elemento;
	protected String coste;
	protected String clase;
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

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

	public Carta(String descripcion, String nombre, String elemento, String coste, String clase) {
		super(descripcion, nombre);
		this.elemento = elemento;
		this.coste = coste;
		this.clase = clase;
	}
	
	//Falta la creación de las cartas y ver dónde se crean.

}
