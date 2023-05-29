package Partida;

import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Combate.*;
import Efectos.*;
import Movimientos.*;

public class MainPrueba {

	public static void main(String[] args) {
		
		
		System.out.println(Jugable.class.arrayType());
		
		Cartas crs = new Cartas();
		
		Enemigos ens = new Enemigos();
		
		EfectosEspeciales spfx = new EfectosEspeciales();
		
		Enemigo Slime = ens.SlimeRB;
		
		Jugable jugador = new Jugable("Héroe", 20, 65, 65, 11, 13, 12, 15, 18, 0, 0, null, null,
				new Carta[] {crs.ofensa1, crs.defensa1, crs.defensa2, crs.ofensa4, crs.defensa4},
				new Efecto[]{spfx.tesonDeGerrero, spfx.tesonDeGerrero, spfx.tesonDeGerrero, spfx.tesonDeGerrero, spfx.tesonDeGerrero});
		
		Slime.setNivel(15);
		
		Enemigo.ajustaParametros(Slime, ens.SlimeRB);
		
		Combate.inicioCombate(Slime);
		Combate.menuCombate(jugador, Slime);
		
		
	}

}