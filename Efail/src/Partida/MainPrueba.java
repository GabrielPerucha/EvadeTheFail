package Partida;

import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Combate.*;

public class MainPrueba {
	
	
	static Enemigo NPC = new Enemigo("Slime", null, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null);
	
	public static void main(String[] args) {
		
		
		Combate.inicioCombate(NPC);
		Combate.inicioCombate(NPC);
		
		
		
		
	}
	
}