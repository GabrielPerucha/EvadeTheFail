package ClasesEntidades;

import Movimientos.*;

public class Enemigos {
	
	//Existen tres tipos de enemigos distintos por cada enemigo, marcando los stats de dicho enemigo a lo largo del juego.
	Ataques at = new Ataques ();
	
	public Enemigo SlimeRB = new Enemigo("Slime", 1, 5, 5, 2, 1, 5, 50, 0, "Neutro", "Una pegajosa y poco amigable bola de moco que intenta matarte", 
			new Ataque[] {at.golpeRB, at.endurecerRB, at.rugidoRB, at.descansoRB}, null, null);
	
	public Enemigo SlimeRA = new Enemigo("Slime", 1, 7, 7, 3, 1, 5, 50, 0, "Neutro", "Una pegajosa y poco amigable bola de moco que intenta matarte", 
			new Ataque[] {at.golpeRA, at.endurecerRA, at.rugidoRA, at.descansoRB}, null, null);
	
	public Enemigo SlimeRM = new Enemigo("Slime", 1, 9, 9, 4, 1, 5, 50, 0, "Neutro", "Una pegajosa y poco amigable bola de moco que intenta matarte", 
			new Ataque[] {at.rugidoRM, at.descansoRM}, null, null);
	
	
	public Enemigo Goblin = new Enemigo("Goblin", 1, 3, 3, 3, 3, 8, 70, 0, "Neutro", "Un enemigo típico que nunca falta en las mazmorras",
			new Ataque[] {at.golpeRB, at.rugidoRB, at.fortalecerRB ,at.desarmeRB}, null, null);
	
	public Enemigo GoblinHacha = new Enemigo("Goblin con Hacha", 1, 4, 4, 4, 2, 4, 50, 0, "Neutro", "Un enemigo típico que nunca falta en las mazmorras, pero tiene un hacha",
			new Ataque[] {at.golpeRB, at.rugidoRB, at.fortalecerRB ,at.hachazoRB}, null, null);
	
	public Enemigo GoblinEspada = new Enemigo("Goblin con Espada", 1, 2, 2, 4, 2, 10, 90, 0, "Neutro", "Un enemigo típico que nunca falta en las mazmorras, pero tiene una espada",
			new Ataque[] {at.golpeRB, at.rugidoRB, at.fortalecerRB ,at.espadazoRB}, null, null);
	
	
	
}