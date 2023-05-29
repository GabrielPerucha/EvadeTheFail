package Combate;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Efectos.*;
import Movimientos.*;
import Partida.Interfaz;

//String[] opciones = new String[] {};

//int eleccion = JOptionPane.showOptionDialog(null, "Contenido", "Título", 0, 0, null, opciones, "Preseleccionado");

public class Combate {

	/*
	 * Hay dos metodos de dano, uno para cuando el jugador ataca y otro para cuando
	 * defiende. Esto se debe al equilibrio entre el jugador y los enemigos, para
	 * poder utilizar una escala de estadisticas lógica y reducir el dano que hace
	 * el enemigo al jugador.
	 */

	/**
	 * 
	 * @param objetivo
	 * @param atacante
	 * @return
	 */
	public static int formulaDano(Jugable atacante, Enemigo objetivo) {

		int total;

		total = atacante.getAtaque() * (atacante.getNivel() / (2 * objetivo.getNivel() + 1))
				+ (atacante.getAtaque() * (atacante.getAtaque() + 1) / (objetivo.getDefensa() + 1))
				- objetivo.getBloqueo();

		System.out.println(total + " " +atacante.getAtaque());
		
		return total;

	}

	/**
	 * 
	 * @param atacante
	 * @param objetivo
	 * @return
	 */
	public static int formulaDanoRival(Enemigo atacante, Jugable objetivo) {

		int total;

		total = atacante.getAtaque() * (atacante.getNivel() / (3 * objetivo.getNivel() + 1))
				+ (atacante.getAtaque() * (atacante.getAtaque() + 1) / (objetivo.getDefensa() + 1))
				- objetivo.getBloqueo();

		return total;

	}

	/**
	 * 
	 * @param mazo
	 * @return
	 */
	public static Carta[] barajeo(Carta[] mazo) {

		Carta[] mazoAux = new Carta[mazo.length];
		int[] comprobados = new int[mazo.length];
		boolean estaRepartido = false;

		for (int i = 0; i < mazoAux.length; i++) {

			estaRepartido = false;

			int num = (int) (Math.random() * (mazo.length + 0.99));

			for (int j = 0; j < comprobados.length; j++) {

				if (num == comprobados[j]) {
					estaRepartido = true;

				}
			}

			if (!estaRepartido) {

				mazoAux[i] = mazo[num - 1];
				comprobados[i] = num;

			} else {

				i--;
			}

		}
		return mazoAux;

	}

	/**
	 * 
	 * @param efectos
	 * @return
	 */

	public static EfectoSobreEstadisticas[] castEfectos(Efecto[] efectos) {

		// nfx = normal effects
		ArrayList<EfectoSobreEstadisticas> nfx = new ArrayList<EfectoSobreEstadisticas>();

		// spfx = special effects
		ArrayList<EfectoEspecial> spfx = new ArrayList<EfectoEspecial>();

		for (int i = 0; i < efectos.length; i++) {

			/*
			 * El array de efectos de la carta almacena "Efecto", no
			 * "EfectoSobreEstadisticas" ni "EfectoEspecial". para poder llamarlos y ver su
			 * efecto real hubo que hacer dos arrayList y utilizar el try catch de if else.
			 * Si lanza una excepción es porque el cast no funcionó, por lo que no se trata
			 * de un EfectoSobreEstadisticas, sino de uno especial
			 */
			try {

				nfx.add((EfectoSobreEstadisticas) efectos[i]);

			} catch (Exception e) {

				spfx.add((EfectoEspecial) efectos[i]);

			}

		}

		for (int i = 0; i < spfx.size(); i++) {

			Efecto efectosAux[] = spfx.get(i).getEfectos();

			for (int j = 0; j < spfx.get(i).getEfectos().length; j++) {

				nfx.add(castEfectos(efectosAux)[j]);
			}
		}

		EfectoSobreEstadisticas[] efectosTotales = new EfectoSobreEstadisticas[nfx.size()];

		for (int i = 0; i < nfx.size(); i++) {

			efectosTotales[i] = nfx.get(i);

		}

		return efectosTotales;

	}

	/**
	 * 
	 * @param carta
	 * @return
	 */
	public static boolean puedeElegirRival(Carta carta) {

		boolean sePuedeElegirRival = false;

		// nfx = normal effects
		ArrayList<EfectoSobreEstadisticas> nfx = new ArrayList<EfectoSobreEstadisticas>();

		// spfx = special effects
		ArrayList<EfectoEspecial> spfx = new ArrayList<EfectoEspecial>();

		for (int i = 0; i < carta.getEfectos().length; i++) {

			/*
			 * El array de efectos de la carta almacena "Efecto", no
			 * "EfectoSobreEstadisticas" ni "EfectoEspecial". para poder llamarlos y ver su
			 * efecto real hubo que hacer dos arrayList y utilizar el try catch de if else.
			 * Si lanza una excepción es porque el cast no funcionó, por lo que no se trata
			 * de un EfectoSobreEstadisticas, sino de uno especial
			 */
			try {

				nfx.add((EfectoSobreEstadisticas) carta.getEfectos()[i]);

			} catch (Exception e) {

				spfx.add((EfectoEspecial) carta.getEfectos()[i]);

			}

		}

		for (int i = 0; i < spfx.size(); i++) {

			Efecto efectosAux[] = spfx.get(i).getEfectos();

			Carta cartaAux = new Carta(-1, "CartaAuxiliar", spfx.get(i).getDescripcion(), carta.getElemento(), 0,
					carta.getClase(), efectosAux);

			/*
			 * Esta sentencia recursiva vuelve a llamar al metodo de ejecutar carta, que al
			 * principio separa los efectos especiales de los normales
			 */

			if (puedeElegirRival(cartaAux))
				sePuedeElegirRival = true;

		}

		for (int i = 0; i < nfx.size(); i++) {

			if (!nfx.get(i).isObjetivo())
				sePuedeElegirRival = true;

		}

		return sePuedeElegirRival;

	}

	/**
	 * 
	 * @param Terreno.terreno
	 * @param enemigoAtacante
	 * @return
	 */
	public static Ataque eleccionSiguienteAccion(int enemigoAtacante) {

		int ataqueEnemigo;
		int[] probabilidades = new int[100];

		ataqueEnemigo = (int) (Math.random() * 99.99);

		Ataque ataqueEjecutado = new Ataque(null, null, ataqueEnemigo, ataqueEnemigo, null);

		switch (enemigoAtacante) {

		case 1:
			for (int i = 0, k = 0; i < Terreno.terreno.getE1().getAtaques().length; i++) {

				for (int j = 0; j < Terreno.terreno.getE1().getAtaques()[i].getProbabilidad(); j++, k++) {

					probabilidades[k] = i;

				}

			}
			ataqueEjecutado = Terreno.terreno.getE1().getAtaques()[probabilidades[ataqueEnemigo]];
			break;

		case 2:
			for (int i = 0, k = 0; i < Terreno.terreno.getE1().getAtaques().length; i++, k++) {

				for (int j = 0; j < Terreno.terreno.getE1().getAtaques()[i].getProbabilidad(); j++, k++) {

					probabilidades[k] = j;

				}

			}
			ataqueEjecutado = Terreno.terreno.getE1().getAtaques()[probabilidades[ataqueEnemigo]];
			break;

		case 3:
			for (int i = 0, k = 0; i < Terreno.terreno.getE1().getAtaques().length; i++, k++) {

				for (int j = 0; j < Terreno.terreno.getE1().getAtaques()[i].getProbabilidad(); j++, k++) {

					probabilidades[k] = j;

				}

			}
			ataqueEjecutado = Terreno.terreno.getE1().getAtaques()[probabilidades[ataqueEnemigo]];
			break;

		}

		return ataqueEjecutado;

	}

	/**
	 * 
	 * @param NPC
	 */
	public static void inicioCombate(Enemigo NPC) {

		JOptionPane.showMessageDialog(null, "¡Ha aparecido un " + NPC.getNombre() + " de nivel " + NPC.getNivel() + "!",
				"¡Encuentro!", 0, NPC.getIconoEnemigo());

	}

	public static void dañarEnemigo(int objetivo) {

		Enemigo enemigoAux = null;
		
		switch (objetivo) {
		
		case 1:
			enemigoAux = Terreno.terreno.getE1();
			break;
		case 2: 
			enemigoAux = Terreno.terreno.getE2();
			break;
		case 3:
			enemigoAux = Terreno.terreno.getE3();
			break;
		}
		
		enemigoAux.setVidaRestante(enemigoAux.getVidaRestante() - Combate.formulaDano(Terreno.terreno.getJugador(), enemigoAux));
		
		switch (objetivo) {
		
		case 1:
			Terreno.terreno.setE1(enemigoAux);
			break;
		case 2: 
			Terreno.terreno.setE2(enemigoAux);
			break;
		case 3:
			Terreno.terreno.setE3(enemigoAux);
			break;
		}
	}

	public static void dañarJugador(Enemigo atacante) {
		
		Terreno.terreno.getJugador().setVidaRestante(Terreno.terreno.getJugador().getVidaRestante() - Combate.formulaDanoRival(atacante, Terreno.terreno.getJugador()));

	}
	
	public static void revisaEfectos() {
		
		EfectoSobreEstadisticas[] efectosAux = castEfectos(Terreno.terreno.getEfectosEnJugador());
		EfectoSobreEstadisticas[] efectosAux2 = new EfectoSobreEstadisticas [efectosAux.length];
		
		for (int i = 0; i < efectosAux.length; i++) {
			
			if (efectosAux[i].getDuracion() == 0) {
				
				/*
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * TRABAJANDO AQUI LA ULTIMA VEZ
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 */
				
			}
			
		}
		
	}
	
	

	// Falta duplicar el método para que sea tolerable a dos o tres enemigos.
	/**
	 * 
	 * @param jugador
	 * @param NPC
	 */
	public static void menuCombate(Jugable jugador, String nombreEnemigo, int nivelEnemigo) {

		EfectosEspeciales sp = new EfectosEspeciales();
		boolean finTurno = false, tiroCarta = false, finCombate = false;
		Carta[] mazoAux = null, mano;

		Enemigos ens = new Enemigos();
		Enemigo NPC = ens.SlimeRB;
		NPC.setNivel(nivelEnemigo);

		Enemigo.ajustaParametros(NPC, ens.SlimeRB);

		Terreno.terreno = new Terreno(null, new Carta[0], new Carta[0], barajeo(jugador.getMazo()),
						jugador.getPasivas(), new Efecto[] { sp.tensionDeEnemigo }, jugador, NPC);

		int numCartas = 5;

		mano = new Carta[numCartas];

		do {

			/*
			 * Este complicado if-else se encarga de dos cosas. Repartir cartas que tiene el
			 * jugador y definir el mazo restante del turno. Para ello, si la longitud es
			 * mayor del numero de cartas que se roban el siguiente mazo se crea con esa
			 * longitud restada y sin las cartas robadas. En caso contrario se reciclan las
			 * cartas descartadas ya barajadas, se repone el mazo y la mano con las cartas
			 * restantes del mazo con el paso intermedio de eliminar de descartes las cartas
			 * "recicladas".
			 */

			if (Terreno.terreno.getMazoRestante().length <= numCartas) {

				if (Terreno.terreno.getDescartes().length >= Terreno.terreno.getMazoRestante().length)
					mazoAux = new Carta[Terreno.terreno.getDescartes().length
							- Terreno.terreno.getMazoRestante().length];

				for (int i = 0; i < Terreno.terreno.getMazoRestante().length; i++) {
					mano[i] = Terreno.terreno.getMazoRestante()[i];

				}

				for (int i = Terreno.terreno.getMazoRestante().length; i < numCartas
						- Terreno.terreno.getMazoRestante().length; i++) {
					mano[i] = Terreno.terreno.getDescartes()[i];
				}

				if (Terreno.terreno.getDescartes().length >= Terreno.terreno.getMazoRestante().length)
					for (int i = 0; i < mazoAux.length; i++) {
						mazoAux[i] = Terreno.terreno.getDescartes()[i + Terreno.terreno.getMazoRestante().length];
					}

				if (Terreno.terreno.getDescartes().length >= Terreno.terreno.getMazoRestante().length)
					Terreno.terreno.setDescartes(mazoAux);
				Terreno.terreno.setMazoRestante(Terreno.terreno.getDescartes());
				Terreno.terreno.setDescartes(new Carta[] {});

			} else {

				mazoAux = new Carta[Terreno.terreno.getMazoRestante().length - 5];

				for (int i = 0; i < mazoAux.length; i++) {
					mazoAux[i] = Terreno.terreno.getMazoRestante()[i + 5];
					mano[i] = Terreno.terreno.getMazoRestante()[i + 5];

				}

				Terreno.terreno.setMazoRestante(mazoAux);

			}

			Terreno.terreno.setMano(mano);
			// Reparto completado en este punto

			do {

				String opciones[] = new String[Terreno.terreno.getMano().length + 2];
				ArrayList<Carta> cartasMano = new ArrayList<Carta>();

				for (int i = 0; i < opciones.length - 2; i++) {

					opciones[i] = Terreno.terreno.getMano()[i].getNombre();
					cartasMano.add(Terreno.terreno.getMano()[i]);

				}

				opciones[opciones.length - 2] = "Finalizar turno";
				opciones[opciones.length - 1] = "?";

				do {

					int eleccionCarta = JOptionPane.showOptionDialog(null, Interfaz.creaInterfazBatalla(jugador, NPC),
							"Combate contra " + NPC.getNombre(), 0, 0, null, opciones, "?");

					int eleccionObjetivo;

					if (eleccionCarta == opciones.length - 2) {

						finTurno = true;
						tiroCarta = true;

					} else if (eleccionCarta == opciones.length - 1) {

						Interfaz.informacionGeneral();

					} else {

						if (puedeElegirRival(cartasMano.get(eleccionCarta))) {

							eleccionObjetivo = JOptionPane.showOptionDialog(null, "Elige un objetivo para tu carta",
									"Combate contra " + NPC.getNombre(), 0, 0, null,
									new String[] { "Atrás", NPC.getNombre() }, "Atrás");
							if (eleccionObjetivo != 0)
								Carta.ejecutarCarta(cartasMano.get(eleccionCarta), eleccionObjetivo);

						} else {

							eleccionObjetivo = JOptionPane.showOptionDialog(null, "Elige un objetivo para tu carta",
									"Combate contra " + NPC.getNombre(), 0, 0, null, new String[] { "Atrás", "Tú" },
									"Atrás");

							if (eleccionObjetivo != 0) {
								Carta.ejecutarCarta(cartasMano.get(eleccionCarta), -1);
							}

						}

						// Este if se encarga de mandar a descartes las cartas según las vayas usando
						if (eleccionObjetivo != 0) {

							Carta[] descartesAux = new Carta[Terreno.terreno.getDescartes().length + 1];

							for (int j = 0; j < Terreno.terreno.getDescartes().length; j++) {

								descartesAux[j] = Terreno.terreno.getDescartes()[j];

							}
							descartesAux[Terreno.terreno.getDescartes().length] = cartasMano.get(eleccionCarta);
							Terreno.terreno.setDescartes(descartesAux);

							cartasMano.remove(eleccionCarta);
							tiroCarta = true;
						}

					}

				} while (!tiroCarta);
				tiroCarta = false;

				mano = new Carta[cartasMano.size()];

				for (int i = 0; i < cartasMano.size(); i++) {

					mano[i] = cartasMano.get(i);

				}

				Terreno.terreno.setMano(mano);

				Terreno.terreno.setDescartes(barajeo(Terreno.terreno.getDescartes()));

			} while (!finTurno);
			finTurno = false;

			Carta[] descartesAux = new Carta[Terreno.terreno.getDescartes().length + Terreno.terreno.getMano().length];

			for (int j = 0; j < Terreno.terreno.getDescartes().length; j++) {

				descartesAux[j] = Terreno.terreno.getDescartes()[j];

			}

			for (int j = 0; j < Terreno.terreno.getMano().length; j++) {

				descartesAux[j + Terreno.terreno.getDescartes().length] = Terreno.terreno.getMano()[j];

			}

			Terreno.terreno.setMano(new Carta[0]);
			Terreno.terreno.setDescartes(descartesAux);
			Terreno.terreno.setDescartes(barajeo(Terreno.terreno.getDescartes()));

			Enemigo.ejecutarAtaque(1);

			Terreno.terreno.getE1().setSiguienteAccion(eleccionSiguienteAccion(1));
		} while (!finCombate);
	}

}
