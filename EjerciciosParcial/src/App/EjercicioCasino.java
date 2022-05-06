package App;

import java.util.Scanner;

public class EjercicioCasino {
	
	static Scanner input = new Scanner(System.in);
	
	//inicializacion de constatntes
	static final double PRECIO_RUL = 100;
	static final double PRECIO_BJK = 200;
	static final double PRECIO_PKR = 500;
	
	static final int RUL = 1;
	static final int BJK = 2;
	static final int PKR = 3;
	static final int SALIR = 4;
	
	static final int GANO = 2;
	static final int NO_PERDIO = 1;
	static final int PERDIO = 0;

	public static void main(String[] args) {
		
		
		// Inicializacion de variables
		String nombre;
		String nombreJuego = "";
		double dineroInicial, dinero; 
		double costoDelJuego = 0;
		int juegoElegido, suerte, contPkr=0, contRul=0, contBjk=0, totalJugado;
		boolean seguirJugando = true;
		boolean apuestaRealizada;
		
		
		// inicio y entrada de datos del usuario
		System.out.println("------------------------------");
		System.out.println("   Bienvenido Al Casino ETC   ");
		System.out.println("------------------------------\n");
		
		System.out.print("Ingresa su Nombre: ");
		nombre = input.nextLine();		
		do {System.out.print("Ingresa su dinero inicial (mas de 500$): ");
			dinero = Double.parseDouble(input.nextLine());		
		} while (dinero < 500);
		dineroInicial = dinero;
		
		// inicio del ciclo
		
		while ((dinero>=(dineroInicial*0.20)) && dinero<5000  && seguirJugando) {
			System.out.println("Bienvenido " + nombre + ", su dinero actual es de $" + dinero);
			System.out.println("--------------- que desea jugar: ---------------");
			System.out.print("Ruleta (1) | BlackJack (2) | Poker (3) | SALIR (4): ");
			juegoElegido = Integer.parseInt(input.nextLine());
			
			apuestaRealizada=true;
			
			switch (juegoElegido) {
			case RUL:
				dinero = dinero - PRECIO_RUL;
				costoDelJuego = PRECIO_RUL;
				nombreJuego = "Ruleta";
				contRul++;
				break;
			case BJK:
				if (dinero >= PRECIO_BJK) {
					dinero = dinero - PRECIO_BJK;
					costoDelJuego = PRECIO_BJK;
					nombreJuego = "BlackJack";
					contBjk++;
				} else {
					System.out.println("Dinero Insuficiente, elija otro Juego");
					apuestaRealizada=false;
				}
				break;
			case PKR:
				if (dinero >= PRECIO_PKR) {
					dinero = dinero - PRECIO_PKR;
					costoDelJuego = PRECIO_PKR;
					nombreJuego = "Poker";
					contPkr++;
				} else {
					System.out.println("Dinero Insuficiente, elija otro Juego");
					apuestaRealizada=false;
				}
				break;
			case SALIR:
				seguirJugando = false;
				break;
				
				// DEBUGGGGGG
			case 5:  
				System.out.print("Ingresa su dinero inicial (mas de 500$): ");
				dinero = Double.parseDouble(input.nextLine());	
				continue;
				
				
				//DEBUGGGGGG
			}
			if (seguirJugando && apuestaRealizada) {
				
				suerte = (int) (Math.random() * 3);
				switch (suerte) {
				case GANO:
					System.out.println("\n-------------------------------------------");
					System.out.println("USTED GANO EN " + nombreJuego.toUpperCase() + ", FELICITACIONES");
					System.out.println("-------------------------------------------");
					dinero = dinero + (costoDelJuego*2);
					break;
				case NO_PERDIO:
					System.out.println("\n-------------------------------------------");
					System.out.println("     usted no perdio en " + nombreJuego);
					System.out.println("-------------------------------------------");
					dinero = dinero + (costoDelJuego);
					break;
				case PERDIO:
					System.out.println("\n-------------------------------------------------");
					System.out.println("usted perdio en " + nombreJuego + ", mejor suerte la proxima");
					System.out.println("-------------------------------------------------");
					break;
				
				
				}
			}
		}
		
		System.out.println("");
		if (dinero<100 || (dinero<(dineroInicial*0.20))) {
			System.out.println("Usted tiene muy poco dinero como para seguir jugando ");
		} else if (dinero>5000) {
			System.out.println("Usted tiene demasiado dinero como para seguir jugando ");
		} else {
			System.out.println("Saliendo...");
		}
		
		totalJugado = contRul + contBjk + contPkr;
		System.out.println("\nSu saldo restante es $" + dinero);
		System.out.println("Usted jugo " + contRul + " Ruletas, " + contBjk + " BlackJacks y " + contPkr + " Pokers");
		System.out.println("un " + (contRul*100)/totalJugado + "% de las partidas fueron Ruleta");
		System.out.println("un " + (contBjk*100)/totalJugado + "% de las partidas fueron BlackJack");
		System.out.println("un " + (contPkr*100)/totalJugado + "% de las partidas fueron Poker");
	}

}
