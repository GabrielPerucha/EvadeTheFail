package ClasesEntidades;

public class Jugable extends Entidad {

	/*
	 * TO DO Creación de clases hijas con diferentes estilos de personajes
	 */
	
	protected int mana;
	
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Jugable(String nombre, int vida, int nivel, int velocidad, int ataque, int defensa, int bloqueo, int probCritico,
			int dañoCritico, int mana) {
		super(nombre, vida, nivel, velocidad, ataque, defensa, bloqueo, probCritico, dañoCritico);
		this.mana = mana;
	}

}
