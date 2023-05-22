package Movimientos;

import Efectos.EfectoSobreEstadisticas;

public class Carta extends Movimiento {

	// TO DO Creacion de cartas y establecer cuántas habrá y de que clase

	protected String elemento;
	protected int coste;
	protected String clase;
	protected int ID;
	protected EfectoSobreEstadisticas[] efectos;
	
	

	public EfectoSobreEstadisticas[] getEfectos() {
		return efectos;
	}

	public void setEfectos(EfectoSobreEstadisticas[] efectos) {
		this.efectos = efectos;
	}

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

	/**
	 * 
	 * @param ID
	 * @param nombre
	 * @param descripcion
	 * @param elemento
	 * @param coste
	 * @param clase
	 * @param efectos
	 */
	public Carta(int ID, String nombre, String descripcion, String elemento, int coste, String clase,
			EfectoSobreEstadisticas[] efectos) {
		super(descripcion, nombre);
		this.ID = ID;
		this.efectos = efectos;
		this.elemento = elemento;
		this.coste = coste;
		this.clase = clase;
	}

	public static void ejecutarCarta(Carta carta) {

	}

	// Falta la creación de las cartas y ver dónde se crean.

}
