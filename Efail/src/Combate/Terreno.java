package Combate;

import ClasesEntidades.Enemigo;
import ClasesEntidades.Jugable;
import Movimientos.Carta;

public class Terreno {

	protected Carta[] Mano;
	protected Carta[] Destierro;
	protected Carta[] Descartes;
	protected Carta[] MazoRestante;
	
	protected Jugable jugador;
	protected Enemigo e1, e2, e3;
	
	
	
	public Jugable getJugador() {
		return jugador;
	}
	public void setJugador(Jugable jugador) {
		this.jugador = jugador;
	}
	public Enemigo getE1() {
		return e1;
	}
	public void setE1(Enemigo e1) {
		this.e1 = e1;
	}
	public Enemigo getE2() {
		return e2;
	}
	public void setE2(Enemigo e2) {
		this.e2 = e2;
	}
	public Enemigo getE3() {
		return e3;
	}
	public void setE3(Enemigo e3) {
		this.e3 = e3;
	}
	public Carta[] getMano() {
		return Mano;
	}
	public void setMano(Carta[] mano) {
		Mano = mano;
	}
	public Carta[] getDestierro() {
		return Destierro;
	}
	public void setDestierro(Carta[] destierro) {
		Destierro = destierro;
	}
	public Carta[] getDescartes() {
		return Descartes;
	}
	public void setDescartes(Carta[] descartes) {
		Descartes = descartes;
	}
	public Carta[] getMazoRestante() {
		return MazoRestante;
	}
	public void setMazoRestante(Carta[] mazoRestante) {
		MazoRestante = mazoRestante;
	}
	
	public Terreno(Carta[] mano, Carta[] destierro, Carta[] descartes, Carta[] mazoRestante, Jugable jugador,
			Enemigo e1) {
		super();
		Mano = mano;
		Destierro = destierro;
		Descartes = descartes;
		MazoRestante = mazoRestante;
		this.jugador = jugador;
		this.e1 = e1;
	}
	
	public Terreno(Carta[] mano, Carta[] destierro, Carta[] descartes, Carta[] mazoRestante, Jugable jugador,
			Enemigo e1, Enemigo e2) {
		super();
		Mano = mano;
		Destierro = destierro;
		Descartes = descartes;
		MazoRestante = mazoRestante;
		this.jugador = jugador;
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public Terreno(Carta[] mano, Carta[] destierro, Carta[] descartes, Carta[] mazoRestante, Jugable jugador,
			Enemigo e1, Enemigo e2, Enemigo e3) {
		super();
		Mano = mano;
		Destierro = destierro;
		Descartes = descartes;
		MazoRestante = mazoRestante;
		this.jugador = jugador;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
	}
	
	
}
