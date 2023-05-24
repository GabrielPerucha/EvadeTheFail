package Efectos;

import ClasesEntidades.*;
import Efectos.*;
import Combate.*;

public class EfectosEspeciales {

	
	//Descripcion y efectos en lineas separadas
	
	//SLIMES
	public EfectoEspecial babaSlimeRB = new EfectoEspecial("Baba de Slime pegajosa que te vuelve más torpe al atacar.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("ataque", 0.9, 0, 2, 0, false)});
	
	public EfectoEspecial babaSlimeRA = new EfectoEspecial("Pese a haberte vuelto más fuerte, sientes que los enemigos tambien lo hicieron.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("ataque", 0.8, 0, 2, 0, false)});
	
	public EfectoEspecial babaSlimeRM = new EfectoEspecial("Una baba más fuerte a la que el héroe no le tiene miedo.\nDura 3 turnos", 
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("ataque", 0.75, 0, 3, 0, false)});
	
	
	//JUEGO CON TURNOS
	

	
}
