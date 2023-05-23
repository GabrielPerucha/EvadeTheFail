package ClasesEntidades;

import Movimientos.*;

public class Enemigos {
	
	//Existen tres tipos de enemigos distintos por cada enemigo, marcando los stats de dicho enemigo a lo largo del juego.
	Ataques at = new Ataques ();
	
	Enemigo SlimeRB = new Enemigo("Slime", 1, 5, 3, 2, 1, 1, 5, 0, "Neutro", "Una pegajosa y poco amigable bola de moco que intenta matarte", 
			new Ataque[] {at.golpeRB, at.endurecerRB, at.rugidoRB, at.descansoRB}, null, null);
	
	Enemigo SlimeRA = new Enemigo("Slime", 1, 7, 3, 2, 1, 2, 5, 0, "Neutro", "Una pegajosa y poco amigable bola de moco que intenta matarte", 
			new Ataque[] {at.golpeRA, at.endurecerRA, at.rugidoRA, at.descansoRB}, null, null);
	
	Enemigo SlimeRM = new Enemigo("Slime", 1, 9, 4, 3, 1, 2, 5, 0, "Neutro", "Una pegajosa y poco amigable bola de moco que intenta matarte", 
			new Ataque[] {at.rugidoRM, at.descansoRM}, null, null);
	
	
	Enemigo Goblin = new Enemigo("Goblin", 1, 3, 3, 3, 3, 2, 7, 0, "Neutro", "Un enemigo típico que nunca falta en las mazmorras",
			new Ataque[] {}, null, null);
	
	
	
	Enemigo GoblinHacha = new Enemigo("Goblin con Hacha", 1, 4, 4, 4, 2, 1, 10, 0, "Neutro", "Un enemigo típico que nunca falta en las mazmorras, pero tiene un hacha",
			null, null, null);
	
	
	
	Enemigo GoblinEspada = new Enemigo("Goblin con Espada", 1, 2, 2, 4, 2, 5, 7, 0, "Neutro", "Un enemigo típico que nunca falta en las mazmorras, pero tiene una espada",
			null, null, null);
	
	
	
}