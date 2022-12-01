package pcktriqui;


import java.util.Scanner;

public class TriquiMejorado2 {
	
	static String simboloJugador1;
	static String simboloJugador2;
	static final String marcaVacio = " ";
	static String nombreJugador1;
	static String nombreJugador2;
	static int opcionSimbolo;
	static int contadorJugador1 = 0;
	static int contadorJugador2 = 0;
	static int opcContinuarJuego;
	static int rondasJuego = 0;
	static int x ;
	

	public static void solicitarDatos() {
		System.out.println("Ingrese el nombre del jugador 1");
		nombreJugador1 = ingresarDatos().next();

		do {
			System.out.println(nombreJugador1 + " ingrese el numero de la opcion con la cual desea jugar "
					+ "\n Opcion 1: X \n Opcion 2: O");
			try {
				opcionSimbolo = ingresarDatos().nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo el numero de la opcion");
			}
			if (opcionSimbolo == 1) {
				simboloJugador1 = "X";
			} else {
				simboloJugador1 = "O";
			}
		} while (opcionSimbolo != 1 && opcionSimbolo != 2);

		System.out.println("Ingrese el nombre del jugador 2");
		nombreJugador2 = ingresarDatos().next();

		if (simboloJugador1 == "X") {
			System.out.println(nombreJugador2 + " su simbolo para jugar es el (O) ");
			simboloJugador2 = "O";
		} else {
			System.out.println(nombreJugador2 + " su simbolo para jugar es el (X) ");
			simboloJugador2 = "X";

		}

	}

	public static Scanner ingresarDatos() {
		Scanner teclado = new Scanner(System.in);
		return teclado;
	}

	public static void main(String[] args) {

		String T[][] = new String[3][3];
		boolean hayGanador = false;
		int jugadas = 0;
		int f = 0;
		int c = 0;
		rondasJuego++;
		if (rondasJuego == 1) {
			solicitarDatos();
		}

		limpiarTablero(T);

		while (hayGanador == false) {
			// Jugador1
			do {
				try {
					System.out.println("Jugada de " + nombreJugador1);
					System.out.print("Indique la Fila =  ");
					f = ingresarDatos().nextInt();
					System.out.print("Indique la Columna =  ");
					c = ingresarDatos().nextInt();
					T[f - 1][c - 1] = simboloJugador1;
				} catch (java.lang.ArrayIndexOutOfBoundsException | java.util.InputMismatchException e) {
					System.out.println("Jugada invalida, ingrese un valor valido");

				}
			} while ((f != 1 && f != 2 && f != 3) || (c != 1 && c != 2 && c != 3));

			mostrarTablero(T);
			if (esGanador(T, simboloJugador1)) {
				System.out.println("Gano: " + nombreJugador1);
				hayGanador = true;
				contadorJugador1++;
				preguntaJuego();
			}
			jugadas++; // jugadas = jagadas + 1;
			if (jugadas == 9) {
				System.out.print("Hubo empate");
				preguntaJuego();
			}
			// Jugador2
			do {
				try {
					System.out.println("Jugada de " + nombreJugador2);
					System.out.print("Indique la Fila =  ");
					f = ingresarDatos().nextInt();
					System.out.print("Indique la Columna =  ");
					c = ingresarDatos().nextInt();
					T[f - 1][c - 1] = simboloJugador2;
				} catch (java.lang.ArrayIndexOutOfBoundsException | java.util.InputMismatchException e) {
					System.out.println("Jugada invalida, ingrese un valor valido");

				}
			} while ((f != 1 && f != 2 && f != 3) || (c != 1 && c != 2 && c != 3));
			mostrarTablero(T);
			if (esGanador(T, simboloJugador2)) {
				System.out.println("Gano: " + nombreJugador2);
				hayGanador = true;
				contadorJugador2++;
				preguntaJuego();
			}

			jugadas++; // jugadas = jugadas + 1;

		}
	}

	private static boolean esGanador(String[][] t, String mj) {
		boolean sw = false;
		// verificar las tres filas
		if (t[0][0] == mj && t[0][1] == mj && t[0][2] == mj) {
			sw = true;
		} else if (t[1][0] == mj && t[1][1] == mj && t[1][2] == mj) {
			sw = true;
		} else if (t[2][0] == mj && t[2][1] == mj && t[2][2] == mj) {
			sw = true;
			// verificar las tres columnas
		} else if (t[0][0] == mj && t[1][0] == mj && t[2][0] == mj) {
			sw = true;
		} else if (t[0][1] == mj && t[1][1] == mj && t[2][1] == mj) {
			sw = true;
		} else if (t[0][2] == mj && t[1][2] == mj && t[2][2] == mj) {
			sw = true;
			// Verificar diagonal principal
		} else if (t[0][0] == mj && t[1][1] == mj && t[2][2] == mj) {
			sw = true;
			// Verificar diagonal secundaria
		} else if (t[2][0] == mj && t[1][1] == mj && t[0][2] == mj) {
			sw = true;
		}

		return sw;

	}

	private static void mostrarTablero(String[][] t) {
		int f, c;
		for (f = 0; f < 3; f++) {
			for (c = 0; c < 3; c++) {
				System.out.print("|" + t[f][c]);

			}
			System.out.println("|");
		}

	}

	private static void limpiarTablero(String[][] t) {
		int f, c;
		for (f = 0; f < 3; f++) {
			for (c = 0; c < 3; c++) {
				t[f][c] = marcaVacio;
			}
		}
	}

	private static void preguntaJuego() {
		

		System.out.println("");
		System.out.println(nombreJugador1 + " indique si desea continuar el juego marcando 1"
				+ " o cualquier otro numero para terminar");
		do {
		try {
			opcContinuarJuego = ingresarDatos().nextInt();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Ingrese solo numeros");
		}
		}while(opcContinuarJuego == x);
		
		
		if (opcContinuarJuego == 1) {
			System.out.println(nombreJugador2 + " indique si desea continuar el juego marcando 1"
					+ " o cualquier otro numero para terminar");
			int opcContinuarJuego = 0;
			do {
				try {
			opcContinuarJuego = ingresarDatos().nextInt();
				} catch (java.util.InputMismatchException e) {
					System.out.println("Ingrese solo numeros");
				}
				}while(opcContinuarJuego == x);
			
			if (opcContinuarJuego == 1) {
				System.out.println("----------------------Nuevo Juego----------------------");
				main(null);

			} else {
				System.out.println("Juego terminado");
				System.out.println("El resultado final es: " + "\n " + nombreJugador1 + " gano " + contadorJugador1
						+ " partidas" + "\n " + nombreJugador2 + " gano " + contadorJugador2 + " partidas");
				if (contadorJugador1 > contadorJugador2) {
					System.out.println("El ganador general es: " + nombreJugador1);
					System.exit(0);
				} else if (contadorJugador1 < contadorJugador2) {
					System.out.println("El ganador general es: " + nombreJugador2);
					System.exit(0);
				} else {
					System.out.println("En el resultado general hubo empate");
					System.exit(0);
				}

			}

		} else {
			System.out.println("Juego terminado");
			System.out.println("El resultado final es: " + "\n " + nombreJugador1 + " gano " + contadorJugador1
					+ " partidas" + "\n " + nombreJugador2 + " gano " + contadorJugador2 + " partidas");
			if (contadorJugador1 > contadorJugador2) {
				System.out.println("El ganador general es: " + nombreJugador1);
				System.exit(0);
			} else if (contadorJugador1 < contadorJugador2) {
				System.out.println("El ganador general es: " + nombreJugador2);
				System.exit(0);
			} else {
				System.out.println("En el resultado general hubo empate");
				System.exit(0);

			}
		}
	}

}
