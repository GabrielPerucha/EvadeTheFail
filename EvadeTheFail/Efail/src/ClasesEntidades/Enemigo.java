package ClasesEntidades;

import Movimientos.Ataque;

public class Enemigo  extends Entidad{

	protected String elemento;
	protected String descripcion;
	protected Ataque[] ataques;
	
	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Ataque[] getAtaques() {
		return ataques;
	}

	public void setAtaques(Ataque[] ataques) {
		this.ataques = ataques;
	}

	public Enemigo(String nombre, int vida, int nivel, int velocidad, int ataque, int defensa, int bloqueo, int probCritico,
			int dañoCritico,String elemento, String descripcion, Ataque[] ataques) {
		super(nombre, vida, nivel, velocidad, ataque, defensa, bloqueo, probCritico, dañoCritico);
		this.descripcion = descripcion;
		this.ataque = ataque;
	}
	
}
