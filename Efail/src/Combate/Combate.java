package Combate;

import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Movimientos.*;

//String[] opciones = new String[] {};

//int eleccion = JOptionPane.showOptionDialog(null, "Contenido", "Título", 0, 0, null, opciones, "Preseleccionado");


public class Combate {

	//Método terminado
	public static void inicioCombate(Enemigo NPC) {
		
		JOptionPane.showMessageDialog(null, "¡Ha aparecido un " +NPC.getNombre()+ " de nivel " +NPC.getNivel() +"!", "¡Encuentro!", 0, NPC.getIconoEnemigo());
		
	}
	
	//Falta duplicar el método para que sea tolerable a dos o tres enemigos.
	public static void menuCombate(Jugable jugador, Enemigo NPC) {
		
		boolean finCombate=false;
		
		Terreno terreno = new Terreno(null, null, null, jugador.getMazo());
		
		terreno.setDescartes(new Carta[jugador.getMazo().length]);
		terreno.setDestierro(new Carta[jugador.getMazo().length]);
		
	
		do {
			
			int numCartas = 5;
			
			terreno.setMano(new Carta[numCartas]);
			
			String opciones[] = new String [terreno.getMano().length];
			
			for(int i = 0; i < opciones.length; i++) {
				
				opciones[i] = terreno.getMano()[i].getNombre();
			}
			
			int eleccion = JOptionPane.showOptionDialog(null, "Contenido", "Combate contra " +NPC.getNombre(), 0, 0, null, opciones, "Preseleccionado");
			
			//Falta llevar a un JOption Pane de la información de cada carta
			//Falta crear un metodo de creación de menús de batalla
			
			
		} while (finCombate);
		
	}

}
