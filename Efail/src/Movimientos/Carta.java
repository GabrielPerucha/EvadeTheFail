package Movimientos;

import Efectos.EfectoSobreEstadisticas;

public class Carta extends Movimiento {

	// TO DO Creacion de cartas y establecer cuántas habrá y de que clase

	protected String elemento;
	protected int coste;
	protected String clase;
	protected int ID;
	protected EfectoSobreEstadisticas efecto1;
	protected EfectoSobreEstadisticas efecto2;
	protected EfectoSobreEstadisticas efecto3;

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

	public Carta(int ID, String nombre, String descripcion, String elemento, int coste, String clase,
			EfectoSobreEstadisticas efecto1) {
		super(descripcion, nombre);
		this.ID = ID;
		this.efecto1 = efecto1;
		this.elemento = elemento;
		this.coste = coste;
		this.clase = clase;
	}

	public Carta(int ID, String nombre, String descripcion, String elemento, int coste, String clase,
			EfectoSobreEstadisticas efecto1, EfectoSobreEstadisticas efecto2) {
		super(descripcion, nombre);
		this.ID = ID;
		this.efecto1 = efecto1;
		this.elemento = elemento;
		this.coste = coste;
		this.clase = clase;
		this.efecto2 = efecto2;
	}

	public Carta(int ID, String nombre, String descripcion, String elemento, int coste, String clase,
			EfectoSobreEstadisticas efecto1, EfectoSobreEstadisticas efecto2, EfectoSobreEstadisticas efecto3) {
		super(descripcion, nombre);
		this.ID = ID;
		this.efecto1 = efecto1;
		this.elemento = elemento;
		this.coste = coste;
		this.clase = clase;
		this.efecto2 = efecto2;
		this.efecto3 = efecto3;
	}

	public static void ejecutarCarta(Carta carta) {

	}

	// Falta la creación de las cartas y ver dónde se crean.

}
