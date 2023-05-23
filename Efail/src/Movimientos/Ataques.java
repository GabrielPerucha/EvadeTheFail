package Movimientos;

import ClasesEntidades.Enemigo;
import ClasesEntidades.Jugable;
import Combate.*;
import Efectos.EfectoSobreEstadisticas;
import Efectos.dano;

public class Ataques {

	Enemigo enemigo = new Enemigo("Default", 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
	Jugable jugador = new Jugable("Default", 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null);
	
	
	
	Ataque Golpe = new Ataque("Un golpe con la mano abierta, siempre confiable", "Golpe", 20, new EfectoSobreEstadisticas[]{new dano(Combate.formulaDanoRival(enemigo, jugador), 1)});
	
	Ataque Baba = new Ataque("Ataque propio de Slimes que baja la velocidad si acierta. Por suerte el moco aunque incómodo está bastante calentito", "Baba de Slime", 30, new EfectoSobreEstadisticas[]{new dano(Combate.formulaDanoRival(enemigo, jugador), 1)});
	
	
}
