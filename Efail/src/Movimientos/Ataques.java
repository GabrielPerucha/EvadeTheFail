package Movimientos;

import ClasesEntidades.Enemigo;
import ClasesEntidades.Jugable;
import Combate.*;
import Efectos.*;

public class Ataques {

	Enemigo enemigo = new Enemigo("Default", 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
	Jugable jugador = new Jugable("Default", 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null);
	EfectosEspeciales ef = new EfectosEspeciales(); 
	
	//Sintaxis de efectos: Salto de linea cuando no cabe en pantalla y la declaracion de efectos en una linea aparte
	
	//Golpe genérico
	public Ataque golpeRB = new Ataque("Un golpe con la mano abierta, siempre confiable.\nPotencia: 100\nProbabilidad: 20", "Golpe", 20, 100, 
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador), 1, false, 0)});
	
	public Ataque golpeRA = new Ataque("Es un golpe tan simple que cada vez lo ves menos.\nPotencia: 100\nProbabilidad: 10", "Golpe", 10, 100,
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador), 1, false, 0)});

	//En RM no hay "Golpe"
	
	
	//Debuff genérico
	public Ataque rugidoRB = new Ataque("Grito de monstruo capaz de aterrorizar a cualquiera.\nBaja un 10% tu ataque y defensa\nProbabilidad: 15\nDuración: 1 turnos", "Rugido", 15, 0,
			new Efecto[] {new CambioDefensa(0.9, 1, false, 0), new CambioAtaque(0.9,1, false, 0)});
	
	public Ataque rugidoRA = new Ataque("Grito de monstruo capaz de aterrorizar a cualquiera que no haya explorado antes.\nBaja un 10% tu ataque y defensa\nProbabilidad: 15\nDuracion: 1 turno", "Rugido", 15, 0,
			new Efecto[] {new CambioDefensa(0.9, 1, false, 0), new CambioAtaque(0.9,1, false, 0)});
	
	public Ataque rugidoRM = new Ataque("Grito de monstruo que has oido tantas veces que ahora hace que te emociones.\nBaja un 10% tu ataque y defensa y baja tu bloqueo en 2\nProbabilidad: 15\nDuracion 1 turno", "Rugido", 15, 0,
			new Efecto[] {new CambioDefensa(0.9, 1, false, 0), new CambioAtaque(0.9,1, false, 0), new Bloqueo(1, -2, 1, false, 0)});
	
	
	//Curacion genérica
	public Ataque descansoRB = new Ataque("Una siestecita nunca viene mal.\nCura al rival 10 puntos de vida\nProbabilidad: 15", "Descanso", 15, 0,
			new Efecto[] {new Curacion(1, 10, 1, true, 0)});
	
	//No hay de rango alto
	
	public Ataque descansoRM = new Ataque("Sueño reparador que tú no puedes disfrutar.\nCura al rival 20 puntos de vida y un 5% de su total\nProbabilidad: 15", "Descanso", 15, 0,
			new Efecto[] {new Curacion(1.05, 10, 1, true, 0)});
	
	
	//Buff genérico
	public Ataque fortalecerRB = new Ataque("Es como una semana de gimnasio, pero en 1 minuto y contra ti.\nAumenta el ataque un 33%\nProbabilidad: 15", "Fortalecer", 15, 0,
			new Efecto[] {new CambioAtaque(1.33, 1, true, 0)});
	
	public Ataque fortalecerRA = new Ataque("Los monstruos de este lugar tan peligroso logran tensar sus músculos a un nuevo nivel si se sienten en peligro.\nAumenta el ataque un 50%\nProbabilidad: 15", "Fortalecer", 15, 0,
			new Efecto[] {new CambioAtaque(1.5, 1, true, 0)});

	//No hay versión de rango maestro
	
	//TO DO version mejorada de fortalecer para goblins o algun monstruo
	
	
																																																		/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	
	
	//Ataques ESPECIALES de ciertos enemigos
	
	
	/*
	 * SLIMES
	 */
	
	//Ataque básico de Slimes
	public Ataque babaRB = new Ataque("Ataque propio de Slimes, curiosamente pese a desprenderse de parte de su cuerpo, no parece dolerles."
			+ "\nPor suerte el moco aunque incómodo está bastante calentito"
			+ "\nGolpea y baja un 10% el ataque\nPotencia: 120\nProbabilidad: 30.", "Baba de Slime", 30, 120, 
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador)*120/100, 1, false, 0), ef.babaSlimeRB});
	
	public Ataque babaRA = new Ataque("Ataque propio de Slimes, curiosamente pese a desprenderse de parte de su cuerpo, no parece dolerles."
			+ ". Poco a poco te vaas cansando de la textura de la baba, mas incluso que antes"
			+ "\nGolpea y baja un 20% el ataque\nPotencia: 130\nProbabilidad: 20", "Baba de Slime", 20, 130, 
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador)*130/100, 1, false, 0), ef.babaSlimeRA});
	
	public Ataque babaRM = new Ataque("Ataque propio de Slimes, curiosamente pese a desprenderse de parte de su cuerpo.", "Baba de Slime"
			+ "\nGolpea y baja un 25% el ataque\nPotencia: 130\nProbabilidad: 10", 10, 130, 
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador)*130/100, 1, false, 0), ef.babaSlimeRM});
	
	//Buff basico de slimes
	public Ataque endurecerRB = new Ataque("La blanda bola de gelatina trata de aumentar su defensa endureciendose, pero reduce su movilidad"
			+ "\nBaja ataque un 15% y sube defensa un 33% durante un turno\nProbabilidad: 20", "Endurecer", 20, 0,
			new Efecto[]{new CambioDefensa(1.33,1, true, 0), new CambioAtaque(0.85, 1, true, 0)});
	
	public Ataque endurecerRA = new Ataque("La blanda bola de gelatina trata de aumentar su defensa endureciendose, pero reduce su movilidad"
			+ "\nBaja ataque un 15% y sube defensa un 50% durante un turno\nProbabilidad: 20", "Endurecer", 20, 0,
			new Efecto[]{new CambioDefensa(1.5,1, true, 0), new CambioAtaque(0.85, 1, true, 0)});
	
	//El endurecer de RM depende del elemento.
	
	
	/*
	 * GOBLINS
	 */
	
	//Goblin desarmado
	public Ataque desarmeRB = new Ataque("¡Un duende desarmado te ataca y te tira el arma!\nBaja el ataque un 30% un turno\nPotencia: 70\nProbabilidad 35", "Desarme", 35, 70,
			new Efecto[] {new Dano(Combate.formulaDanoRival(enemigo, jugador)*70/100, 1, false, 0), new CambioAtaque(0.7, 1, false, 0)});
	
	public Ataque desarmeRA = new Ataque("¡Un duende desarmado te ataca y te tira el arma!\nBaja el ataque un 50% un turno\nPotencia: 90\nProbabilidad 35", "Desarme", 35, 90,
			new Efecto[] {new Dano(Combate.formulaDanoRival(enemigo, jugador)*90/100, 1, false, 0), new CambioAtaque(0.5, 1, false, 0)});
	
	public Ataque desarmeRM= new Ataque("¡Un duende desarmado te ataca y te tira el arma!\nBaja el ataque un 50% un turno\nPotencia: 110\nProbabilidad 35", "Desarme", 35, 110,
			new Efecto[] {new Dano(Combate.formulaDanoRival(enemigo, jugador)*110/100, 1, false, 0), new CambioAtaque(0.5, 1, false, 0)});
	
	
	//Goblin con hacha
	public Ataque hachazo = new Ataque("El duende con su portentosa arma te ataca sin piedad\n", "Hachazo", 35, 200, null);
	
	
}
