package vidaporcent;

import java.util.Scanner;

public class BarraVidaEspecifica {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);

		//int hp = (int)vida;
		
		String black="\033[30m"; 
		String red="\033[31m"; 
		String green="\033[32m"; 
		String yellow="\033[33m"; 
		String blue="\033[34m"; 
		String purple="\033[35m"; 
		String cyan="\033[36m"; 
		String white="\033[37m";
		String reset="\u001B[0m";
		String negrita="\033[0;1m";
		
		int vida1 = -1;//vida que introduce el usuario por la pantalla
		int vida; //valor final que sale por la pantalla, reconvertido de double a int
		double vidaporcent;
		double vidamax = 50;
		double vidad;//vida convertida de double a int para poder operar con la vida max
		
		while (vida1>vidamax | vida1 < 0){
			
			System.out.println("Introduce la vida que tiene el personaje");
			System.out.print("> ");
			vida1 = sc.nextInt();
			if (vida1 > vidamax | vida1 < 0) {
				System.out.println("No has introducido una cifra correcta, vuelve a intentarlo");
			}
		}
		
		System.out.println("\n");


		
		vidad = (double)vida1;
		vidaporcent = (vidad/vidamax)*100;
		vida = (int)vidad;
		
		//System.out.println(vidaporcent);
		
		if(vida == 0){
			System.out.println("Que pena, te muriste...\n");
			System.out.println(""+negrita+"       _____\r\n"
					+ "      /     \\\r\n"
					+ "     | () () |\r\n"
					+ "      \\  ^  /\r\n"
					+ "       |||||"+reset+"");
		}
		
		if(vidaporcent>0 & vidaporcent<=5){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"█                    "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>5 & vidaporcent<=10){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"██                   "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>10 & vidaporcent<=15){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"███                  "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>15 & vidaporcent<=20){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████                 "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>20 & vidaporcent<=25){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"█████                "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>25 & vidaporcent<=30){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"██████               "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>30 & vidaporcent<=35){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"███████              "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>35 & vidaporcent<=40){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████████             "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}

		else if(vidaporcent>40 & vidaporcent<=45){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"█████████            "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>45 & vidaporcent<=50){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"██████████           "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>50 & vidaporcent<=55){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"███████████          "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>55 & vidaporcent<=60){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████████████         "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}

		else if(vidaporcent>60 & vidaporcent<=65){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"█████████████        "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>65 & vidaporcent<=70){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"██████████████       "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>70 & vidaporcent<=75){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"███████████████      "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>75 & vidaporcent<=80){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████████████████     "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}

		else if(vidaporcent>80 & vidaporcent<=85){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"█████████████████    "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>85 & vidaporcent<=90){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"██████████████████   "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>90 & vidaporcent<=95){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"███████████████████  "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>95 & vidaporcent<=100){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████████████████████ "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
	}
}
