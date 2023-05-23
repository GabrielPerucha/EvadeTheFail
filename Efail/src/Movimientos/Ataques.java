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
	Ataque golpeRB = new Ataque("Un golpe con la mano abierta, siempre confiable.\nPotencia: 100\nProbabilidad: 20", "Golpe", 20, 100, 
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador), 1)});
	
	Ataque golpeRA = new Ataque("Es un golpe tan simple que cada vez lo ves menos.\nPotencia: 100\nProbabilidad: 10", "Golpe", 10, 100,
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador), 1)});

	//En RM no hay "Golpe"
	
	
	//Debuff genérico
	Ataque rugidoRB = new Ataque("Grito de monstruo capaz de aterrorizar a cualquiera.\nBaja un 10% tu ataque y defensa\nProbabilidad: 15\nDuración: 1 turnos", "Rugido", 15, 0,
			new Efecto[] {new CambioDefensa(0.9, 1), new CambioAtaque(0.9,1)});
	
	Ataque rugidoRA = new Ataque("Grito de monstruo capaz de aterrorizar a cualquiera que no haya explorado antes.\nBaja un 10% tu ataque y defensa\nProbabilidad: 15\nDuracion: 1 turno", "Rugido", 15, 0,
			new Efecto[] {new CambioDefensa(0.9, 1), new CambioAtaque(0.9,1)});
	
	Ataque rugidoRM = new Ataque("Grito de monstruo que has oido tantas veces que ahora hace que te emociones.\nBaja un 10% tu ataque y defensa y baja tu bloqueo en 2\nProbabilidad: 15\nDuracion 1 turno", "Rugido", 15, 0,
			new Efecto[] {new CambioDefensa(0.9, 1), new CambioAtaque(0.9,1), new Bloqueo(-2, 1)});
	
	
	//Curacion genérica
	Ataque descansoRB = new Ataque("Una siestecita nunca viene mal.\nCura al rival 10 puntos de vida\nProbabilidad: 15", "Descanso", 15, 0,
			new Efecto[] {new Curacion(1, 10, 1)});
	
	//No hay de rango alto
	
	Ataque descansoRM = new Ataque("Sueño reparador que tú no puedes disfrutar.\nCura al rival 20 puntos de vida y un 5% de su total\nProbabilidad: 15", "Descanso", 15, 0,
			new Efecto[] {new Curacion(1.05, 10, 1)});
	
	
	//Buff genérico
	Ataque fortalecerRB = new Ataque("Es como una semana de gimnasio, pero en 1 minuto y contra ti.\nAumenta el ataque un 33%\nProbabilidad: 15", "Fortalecer", 15, 0,
			new Efecto[] {new CambioAtaque(1.33, 1)});
	
	Ataque fortalecerRA = new Ataque("Los monstruos de este lugar tan peligroso logran tensar sus músculos a un nuevo nivel si se sienten en peligro.\nAumenta el ataque un 50%\nProbabilidad: 15", "Fortalecer", 15, 0,
			new Efecto[] {new CambioAtaque(1.5, 1)});

	//No hay versión de rango maestro
	
	//TO DO version mejorada de fortalecer para goblins o algun monstruo
	
	
																																																		/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	
	
	//Ataques ESPECIALES de ciertos enemigos
	
	//Ataque básico de Slimes
	Ataque babaRB = new Ataque("Ataque propio de Slimes, curiosamente pese a desprenderse de parte de su cuerpo, no parece dolerles"
			+ ". Por suerte el moco aunque incómodo está bastante calentito", "Baba de Slime", 30, 120, 
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador)*120/100, 1), ef.babaSlimeRB});
	
	Ataque babaRA = new Ataque("Ataque propio de Slimes, curiosamente pese a desprenderse de parte de su cuerpo, no parece dolerles"
			+ ". Poco a poco te vaas cansando de la textura de la baba, mas incluso que antes", "Baba de Slime", 30, 130, 
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador)*130/100, 1), ef.babaSlimeRA});
	
	Ataque babaRM = new Ataque("Ataque propio de Slimes, curiosamente pese a desprenderse de parte de su cuerpo.", "Baba de Slime", 20, 130, 
			new Efecto[]{new Dano(Combate.formulaDanoRival(enemigo, jugador)*130/100, 1), ef.babaSlimeRM});
	
	
	
	
	
	
	
}
