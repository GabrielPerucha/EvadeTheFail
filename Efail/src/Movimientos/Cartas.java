package Movimientos;

import ClasesEntidades.Jugable;

public class Cartas {

	//public Carta(int ID, String descripcion, String nombre, String elemento, int coste, String clase)
	
	Jugable jugador = new Jugable("Default", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null);
	
	int id=0;
	
	Carta ofensa = new Carta(id++, "Ataca al enemigo con fiereza\nDaño: " +jugador.getAtaque()/3 + "+1", "Ofensa", "Neutro", 1, "Neutro");
	Carta defensa = new Carta(id++, "Defiende la fiereza del rival\nBloqueo: " +jugador.getDefensa()/5 + "+2", "Defensa", "Neutro", 1, "Neutro");
	
	//Añadir más cartas
	//Pasable a otra clase si es necesario
	
}
