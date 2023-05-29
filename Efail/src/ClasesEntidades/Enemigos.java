package ClasesEntidades;

import Movimientos.Ataque;
import Movimientos.Ataques;

public class Enemigos {

	//Existen tres tipos de enemigos distintos por cada enemigo, marcando los stats de dicho enemigo a lo largo del juego.
	Ataques at = new Ataques ();

	public Enemigo SlimeRB = new Enemigo("Slime", 1, 5, 5, 2, 1, 5, 50, 0, "Neutro", "Una pegajosa y poco amigable bola de moco que intenta matarte",
			new Ataque[] {at.golpeRB, at.endurecerRB, at.babaRB, at.rugidoRB, at.descansoRB}, null, at.babaRB);

	public Enemigo SlimeRA = new Enemigo("Slime", 1, 7, 7, 3, 1, 5, 50, 0, "Neutro", "Una pegajosa y poco amigable bola de moco que intenta matarte",
			new Ataque[] {at.golpeRA, at.endurecerRA, at.babaRA, at.rugidoRA, at.descansoRB}, null, at.babaRA);

	public Enemigo SlimeRM = new Enemigo("Slime", 1, 9, 9, 4, 1, 5, 50, 0, "Neutro", "Una pegajosa y poco amigable bola de moco que intenta matarte",
			new Ataque[] {at.rugidoRM, at.descansoRM, at.babaRM}, null, at.babaRM);

	

	public Enemigo getSlimeRB() {
		return SlimeRB;
	}


	public void setSlimeRB(Enemigo slimeRB) {
		SlimeRB = slimeRB;
	}


	public Enemigo GoblinRB = new Enemigo("Goblin", 1, 3, 3, 3, 3, 8, 70, 0, "Neutro", "Un enemigo típico que nunca falta en las mazmorras",
			new Ataque[] {at.golpeRB, at.rugidoRB, at.fortalecerRB, at.descansoRB, at.desarmeRB}, null, at.desarmeRB);

	public Enemigo GoblinRA = new Enemigo("Goblin", 1, 4, 4, 4, 4, 8, 70, 0, "Neutro", "Son muy molestos. no tienen algo que los haga destacar pero tampoco flaquean en nada",
			new Ataque[] {at.golpeRA, at.rugidoRA, at.fortalecerRA, at.descansoRB, at.desarmeRA}, null, at.desarmeRA);

	public Enemigo GoblinHachaRB = new Enemigo("Goblin con Hacha", 1, 4, 4, 4, 2, 4, 50, 0, "Neutro", "Un enemigo típico que nunca falta en las mazmorras, pero tiene un hacha",
			new Ataque[] {at.golpeRB, at.rugidoRB, at.fortalecerRB, at.descansoRB, at.hachazoRB}, null, at.hachazoRB);

	public Enemigo GoblinHachaRA = new Enemigo("Goblin con Hacha", 1, 6, 6, 6, 3, 4, 50, 5, "Neutro", "Carga hachas tan pesadas que desarrolló una defensa natural",
			new Ataque[] {at.golpeRA, at.rugidoRA, at.fortalecerRA, at.descansoRB, at.hachazoRA}, null, at.hachazoRA);

	public Enemigo GoblinEspadaRB = new Enemigo("Goblin con Espada", 1, 2, 2, 4, 2, 10, 90, 0, "Neutro", "Un enemigo típico que nunca falta en las mazmorras, pero tiene una espada",
			new Ataque[] {at.golpeRB, at.rugidoRB, at.fortalecerRB, at.descansoRB, at.espadazoRB}, null, at.espadazoRB);

	public Enemigo GoblinEspadaRA = new Enemigo("Goblin con Espada", 1, 3, 3, 7, 2, 20, 90, 0, "Neutro", "El para nada horrible goblin con espada está de vuelta y con más golpes críticos que nunca",
			new Ataque[] {at.golpeRA, at.rugidoRA, at.fortalecerRA, at.descansoRB, at.espadazoRA}, null, at.espadazoRA);


}