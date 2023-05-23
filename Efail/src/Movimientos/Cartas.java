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
	Jugable jugador = new Jugable("Default", 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null);
	Enemigo enemigo = new Enemigo("Default", 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
	Combate combate = new Combate();
	
	int id=0;

	
	//Cartas de ejemplo, una de ataque y una de defensa.
	
	protected Carta ofensa = new Carta(id++, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + 1, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Dano(Combate.formulaDano(jugador, enemigo), 1, false)});
	protected Carta ofensa1 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + 1, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Dano(Combate.formulaDano(jugador, enemigo), 1, false)});
	protected Carta ofensa2 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + 1, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Dano(Combate.formulaDano(jugador, enemigo), 1, false)});
	protected Carta ofensa3 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + 1, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Dano(Combate.formulaDano(jugador, enemigo), 1, false)});
	protected Carta ofensa4 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nDano: " + Combate.formulaDano(jugador, enemigo) + 1, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Dano(Combate.formulaDano(jugador, enemigo), 1, false)});
	
	
	protected Carta defensa = new Carta(id++, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Bloqueo((jugador.getDefensa()/5 + 2),1, true)});
	protected Carta defensa1 = new Carta(id, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Bloqueo((jugador.getDefensa()/5 + 2),1, true)});
	protected Carta defensa2 = new Carta(id, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Bloqueo((jugador.getDefensa()/5 + 2),1, true)});
	protected Carta defensa3 = new Carta(id, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Bloqueo((jugador.getDefensa()/5 + 2),1, true)});
	protected Carta defensa4 = new Carta(id, "Defensa", "Defiende la fiereza del rival\nBloqueo: " + jugador.getDefensa()/5 + 2, "Neutro", 1, "Neutro", new EfectoSobreEstadisticas[]{new Bloqueo((jugador.getDefensa()/5 + 2),1, true)});
	
	//Anadir más cartas
	//Pasable a otra clase si es necesario
	
	
	
}