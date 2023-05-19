package Combate;

import Movimientos.Carta;

public class Terreno {

	protected Carta[] Mano;
	protected Carta[] Destierro;
	protected Carta[] Descartes;
	protected Carta[] MazoRestante;
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
	public Terreno(Carta[] mano, Carta[] destierro, Carta[] descartes, Carta[] mazoRestante) {
		super();
		Mano = mano;
		Destierro = destierro;
		Descartes = descartes;
		MazoRestante = mazoRestante;
	}
	
	
	
	
}
