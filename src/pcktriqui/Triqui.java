package pcktriqui;

import java.util.Scanner;

public class Triqui {
	//marcas de los jugadores en el tablero
	static final char marcaO = 'O';
	static final char marcaX = 'X';
	static final char marcaVacio = ' ';

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		char T[][] = new char [3][3];
		boolean hayGanador = false;
		int jugadas = 0;
		int f, c;
		limpiarTablero(T);
		System.out.println("Juego de triki V1");
		while (hayGanador == false) {
			//Jugador O
			System.out.println("Jugada de jugador O");
			System.out.print("Fila =  " );
			f = teclado.nextInt();
			System.out.print("Columna =  " );
			c = teclado.nextInt();
			T[f-1][c-1]= marcaO;
			mostrarTablero(T);
			if(esGanador(T, marcaO)) {
				System.out.println("Gana el jugador O");
				hayGanador = true;
				break;
			}
			jugadas ++; //jugadas = jagadas + 1;
			if(jugadas == 9) {
				break;				
			}
			//Jugador X
			System.out.println("Jugada de jugador X");
			System.out.print("Fila =  " );
			f = teclado.nextInt();
			System.out.print("Columna =  " );
			c = teclado.nextInt();
			T[f-1][c-1]= marcaX;
			mostrarTablero(T);
			if(esGanador(T, marcaX)) {
				System.out.println("Gana el jugador X");
				hayGanador = true;
				break;
			}
			jugadas ++; //jugadas = jagadas + 1;
		}
		if(hayGanador == false) {
			System.out.print("Hubo empate");
		}
	}
	

	private static boolean esGanador(char[][] t, char mj) {
		boolean sw = false;
		//verificar las tres filas
		if(t[0][0] == mj && t[0][1] == mj && t[0][2] == mj ) {
			sw= true;
		}else if(t[1][0] == mj && t[1][1] == mj && t[1][2] == mj ) {
			sw= true;
		}else if(t[2][0] == mj && t[2][1] == mj && t[2][2] == mj ) {
			sw= true;
			//verificar las tres columnas
		}else if(t[0][0] == mj && t[1][0] == mj && t[2][0] == mj ) {
			sw= true;
		}else if(t[0][1] == mj && t[1][1] == mj && t[2][1] == mj ) {
			sw= true;
		}else if(t[0][2] == mj && t[1][2] == mj && t[2][2] == mj ) {
			sw= true;
			//Verificar diagonal principal
		}else if(t[0][0] == mj && t[1][1] == mj && t[2][2] == mj ) {
			sw= true;
			//Verificar diagonal secundaria
		}else if(t[2][0] == mj && t[1][1] == mj && t[0][2] == mj ) {
			sw= true;
		}
		
		
		return sw;
	
	}

	private static void mostrarTablero(char t[][]) {
		int f,c;
		for(f=0; f<3; f++) {
			for(c=0; c<3; c++) {
				System.out.print("|" + t[f][c]);
				
				}
			System.out.println("|");
		}
		
	}


	private static void limpiarTablero(char[][] t ) {
		int f,c;
		for(f=0; f<3; f++) {
			for(c=0; c<3; c++) {
				t[f][c]= marcaVacio;
				}
		}
	}
	
	
	
	
}
