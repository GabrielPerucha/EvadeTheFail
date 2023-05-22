package ClasesEntidades;

import javax.swing.Icon;

import Movimientos.Ataque;

public class Enemigo  extends Entidad{

	protected String elemento;
	protected String descripcion;
	protected Ataque[] ataques;
	protected Icon iconoEnemigo;
	protected Ataque siguienteAccion;
	protected int vidaRestante;
	
	
	public int getVidaRestante() {
		return vidaRestante;
	}

	public void setVidaRestante(int vidaRestante) {
		this.vidaRestante = vidaRestante;
	}

	public Ataque getSiguienteAccion() {
		return siguienteAccion;
	}

	public void setSiguienteAccion(Ataque siguienteAccion) {
		this.siguienteAccion = siguienteAccion;
	}

	public Icon getIconoEnemigo() {
		return iconoEnemigo;
	}

	public void setIconoEnemigo(Icon iconoEnemigo) {
		this.iconoEnemigo = iconoEnemigo;
	}

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

	public Enemigo(String nombre, int nivel, int vida, int vidaRestante, int ataque, int defensa, int velocidad, int probCritico,
			int dañoCritico, int bloqueo, String elemento, String descripcion, Ataque[] ataques, Icon iconoEnemigo,
			Ataque siguienteAccion) {
		super(nombre, vida, velocidad, ataque, defensa, bloqueo, probCritico, dañoCritico, nivel);
		this.vidaRestante = vidaRestante;
		this.elemento = elemento;
		this.descripcion = descripcion;
		this.ataques = ataques;
		this.iconoEnemigo = iconoEnemigo;
		this.siguienteAccion = siguienteAccion;
	}
	
	//Falta la creación de enemigos y ver dónde se crean.
	
}
