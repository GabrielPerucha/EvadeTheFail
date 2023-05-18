package ClasesEntidades;

public class Entidad {

	protected String Nombre;
	protected int vida;
	
	protected int nivel;
	
	protected int velocidad;
	protected int ataque;
	
	protected int defensa;
	protected int bloqueo;
	
	protected int probCritico;
	protected int dañoCritico;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getBloqueo() {
		return bloqueo;
	}
	public void setBloqueo(int bloqueo) {
		this.bloqueo = bloqueo;
	}
	public int getProbCritico() {
		return probCritico;
	}
	public void setProbCritico(int probCritico) {
		this.probCritico = probCritico;
	}
	public int getDañoCritico() {
		return dañoCritico;
	}
	public void setDañoCritico(int dañoCritico) {
		this.dañoCritico = dañoCritico;
	}
	
	public Entidad(String nombre, int vida, int velocidad, int ataque, int defensa, int bloqueo, int probCritico,
			int dañoCritico, int nivel) {
		super();
		Nombre = nombre;
		this.vida = vida;
		this.velocidad = velocidad;
		this.ataque = ataque;
		this.defensa = defensa;
		this.bloqueo = bloqueo;
		this.probCritico = probCritico;
		this.dañoCritico = dañoCritico;
		this.nivel = nivel;
	}
	
}
