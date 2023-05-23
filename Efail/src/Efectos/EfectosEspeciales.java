package Efectos;

public class EfectosEspeciales {

	//Descripcion y efectos en lineas separadas
	
	//SLIMES
	public EfectoEspecial babaSlimeRB = new EfectoEspecial("Baba de Slime pegajosa que te vuelve más torpe al atacar.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new CambioAtaque(0.9,2, false, 0)});
	
	public EfectoEspecial babaSlimeRA = new EfectoEspecial("Pese a haberte vuelto más fuerte, sientes que los enemigos tambien lo hicieron.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new CambioAtaque(0.8,2, false, 0)});
	
	public EfectoEspecial babaSlimeRM = new EfectoEspecial("Una baba más fuerte a la que el héroe no le tiene miedo.\nDura 3 turnos", 
			new EfectoSobreEstadisticas[] {new CambioAtaque(0.75,3, false, 0)});
	
	
	//JUEGO CON TURNOS
	
	public EfectoEspecial cargaAtaque = new EfectoEspecial("El enemigo está cargando un ataque poderoso. Su concentración le hace resistir mejor el turno que pierde cargando.",
			new EfectoSobreEstadisticas[] {new CambioDefensa(1.5, 1, true, 1)});
	
}
