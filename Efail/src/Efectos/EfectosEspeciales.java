package Efectos;

public class EfectosEspeciales {

	//Descripcion y efectos en lineas separadas
	
	public EfectoEspecial babaSlimeRB = new EfectoEspecial("Baba de Slime pegajosa que te vuelve más torpe al atacar.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new CambioAtaque(0.9,2, false)});
	
	public EfectoEspecial babaSlimeRA = new EfectoEspecial("Pese a haberte vuelto más fuerte, sientes que los enemigos tambien lo hicieron.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new CambioAtaque(0.8,2, false)});
	
	public EfectoEspecial babaSlimeRM = new EfectoEspecial("Una baba más fuerte a la que el héroe no le tiene miedo.\nDura 3 turnos", 
			new EfectoSobreEstadisticas[] {new CambioAtaque(0.75,3, false)});
	
}
