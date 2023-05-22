package Movimientos;

public class Carta extends Movimiento{

	//TO DO Creacion de cartas y establecer cuántas habrá y de que clase

	protected String elemento;
	protected int coste;
	protected String clase;
	protected int ID;
	
	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

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

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public Carta(int ID, String descripcion, String nombre, String elemento, int coste, String clase) {
		super(descripcion, nombre);
		this.ID = ID;
		this.elemento = elemento;
		this.coste = coste;
		this.clase = clase;
	}
	
	
	public static void ejecutarCarta(Carta carta) {
		
		Cartas c = new Cartas();
		
		
		
	}
	
	
	
	
	//Falta la creación de las cartas y ver dónde se crean.

}
