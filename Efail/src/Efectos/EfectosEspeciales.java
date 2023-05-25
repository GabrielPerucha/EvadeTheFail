package Efectos;

import ClasesEntidades.*;
import Efectos.*;
import Combate.*;

public class EfectosEspeciales {

	
	//Descripcion y efectos en lineas separadas
	
	public EfectoEspecial tesonDeGerrero = new EfectoEspecial("Un guerrero nunca se cansa. Todos los turnos recarga tu maná", new EfectoSobreEstadisticas [] {new EfectoSobreEstadisticas("manaRestante", 1, 4, 100, 0, true)});
	
	public EfectoEspecial tensionDeEnemigo = new EfectoEspecial("Te pones nervioso al ver a un enemigo, quién sabe si él será quien acabe con tu vida", new EfectoSobreEstadisticas [] {new EfectoSobreEstadisticas("vida", 1, 0, 100, 0, true)});
	
	
	//SLIMES
	public EfectoEspecial babaSlimeRB = new EfectoEspecial("Baba de Slime pegajosa que te vuelve más torpe al atacar.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("ataque", 0.9, 0, 2, 0, false)});
	
	public EfectoEspecial babaSlimeRA = new EfectoEspecial("Pese a haberte vuelto más fuerte, sientes que los enemigos tambien lo hicieron.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("ataque", 0.8, 0, 2, 0, false)});
	
	public EfectoEspecial babaSlimeRM = new EfectoEspecial("Una baba más fuerte a la que el héroe no le tiene miedo.\nDura 3 turnos", 
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("ataque", 0.75, 0, 3, 0, false)});
	
	
	//JUEGO CON TURNOS
	

	
}
