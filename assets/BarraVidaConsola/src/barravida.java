package vidaporcent;

import java.util.Scanner;

public class barravida {
	
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
		
		double vida = 0;
		double vidaporcent;
		double vidamax = 50;

		
		while (vida>vidamax | vida == 0){
			
			System.out.println("Introduce la vida que tiene el personaje");
			System.out.print("> ");
			vida = sc.nextDouble();
			if (vida > vidamax | vida <= 0) {
				System.out.println("No has introducido una cifra correcta, vuelve a intentarlo");
			}
		}

		System.out.println("\n");
		
		vidaporcent = (vida/vidamax)*100;
		
		//System.out.println(vidaporcent);
		
		if(vidaporcent>0 & vidaporcent<20){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████                 "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
		else if(vidaporcent>20 & vidaporcent<=40){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████████             "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}

		else if(vidaporcent>40 & vidaporcent<=60){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████████████         "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}

		else if(vidaporcent>60 & vidaporcent<=80){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████████████████     "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}

		else if(vidaporcent>80 & vidaporcent<=100){

			System.out.print("     ┌─────────────────────┐\n     │"+red+"████████████████████ "+reset+"║     "+negrita+"HP: "+reset + vida + "/50\n     └─────────────────────┘");
		}
		
	}
}
