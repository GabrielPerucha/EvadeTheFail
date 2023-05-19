package Partida;

import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Combate.*;

public class MainPrueba {
	
	
	static Enemigo NPC = new Enemigo(null, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
	
	public static void main(String[] args) {
		
		
		Combate.inicioCombate(NPC);
		Combate.inicioCombate(NPC);
		// "\n\n\n\nNv:" + espacios1 + jugador.getNivel() + " " + jugador.getNombre() + espacios2 + "          " + "Nv: "+NPC2.getNivel()+ " " +NPC2.getNombre() +"\n"
		
		JOptionPane.showMessageDialog(null, "¡Ha aparecido un " +NPC.getNombre()+ " de nivel " +NPC.getNivel() +"!", "¡Encuentro!", 0, NPC.getIconoEnemigo());
		
	}
	
}