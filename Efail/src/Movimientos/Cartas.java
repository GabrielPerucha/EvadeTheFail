package Movimientos;

import javax.swing.Icon;

import ClasesEntidades.*;
import Efectos.*;
import Combate.*;
import Partida.*;


public class Cartas {

	//	public Carta(int ID, String nombre, String descripcion, String elemento, int coste, String clase,
	//	EfectoSobreEstadisticas efecto1) 
	
	
	/*
	 * public Jugable(String nombre, int nivel, int vida, int vidaRestante, int ataque, int defensa, int velocidad, int probCritico,
			int danoCritico, int bloqueo, int mana, String clase, Icon iconoJugador, Carta[] mazo) {
	 */
	Jugable jugador = new Jugable("Default", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null);
	Enemigo enemigo = new Enemigo("Default", 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
	Combate combate = new Combate();
	
	int id=0;

	
	//Cartas de ejemplo, una de ataque y una de defensa.
	
	public Carta ofensa = new Carta(id++, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + "+ 3", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("vidaRestante", 1, -(Combate.formulaDano(jugador, enemigo) + 3), 1, 0, false)});
	
	public Carta ofensa1 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + "+ 3", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("vidaRestante", 1, -(Combate.formulaDano(jugador, enemigo) + 3), 1, 0, false)});
	
	public Carta ofensa2 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + "+ 3", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("vidaRestante", 1, -(Combate.formulaDano(jugador, enemigo) + 3), 1, 0, false)});
	
	public Carta ofensa3 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + "+ 3", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("vidaRestante", 1, -(Combate.formulaDano(jugador, enemigo) + 3), 1, 0, false)});
	
	public Carta ofensa4 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + "+ 3", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("vidaRestante", 1, -(Combate.formulaDano(jugador, enemigo) + 3), 1, 0, false)});

	
	public Carta defensa = new Carta(id++, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, jugador.getDefensa()/5 + 2, 1, 0, true)});
	
	public Carta defensa1 = new Carta(id++, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, jugador.getDefensa()/5 + 2, 1, 0, true)});
	
	public Carta defensa2 = new Carta(id++, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, jugador.getDefensa()/5 + 2, 1, 0, true)});
	
	public Carta defensa3 = new Carta(id++, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, jugador.getDefensa()/5 + 2, 1, 0, true)});
	
	public Carta defensa4 = new Carta(id++, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, jugador.getDefensa()/5 + 2, 1, 0, true)});
	
	
	
	
	//Anadir más cartas
	//Pasable a otra clase si es necesario

}