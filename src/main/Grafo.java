package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Grafo {
	
	//Declaro todas las variables que necesito
	private Scanner sc;
	private int cantNodos;
	private int cantAristas;
	private int[][] matrizAdy;
	private int[] vectorAdy;
	private Arco[] arcos;
	private int tamVectorAdy;
	private HashMap<Integer, ArrayList<Integer>> mapAdy;
	private static int INF = 999;
	//Constructor
	public Grafo (String pathIn, String pathOut) throws IOException {
		
		sc = new Scanner(new File(pathIn));
		
		cantNodos = sc.nextInt();
		cantAristas = sc.nextInt();
		
		int tam = cantNodos+1;
		
		arcos = new Arco[cantAristas];
		matrizAdy = new int[tam][tam];
		tamVectorAdy = (int) ((Math.pow(tam, 2)-(tam))/2);
		vectorAdy = new int[tamVectorAdy];
		mapAdy = new HashMap<Integer, ArrayList<Integer>>();
		//Inicializo vector adyacente
		for (int i = 0; i < vectorAdy.length; i++) {
			vectorAdy[i] = INF;
		}
		//Inicializo Arrays del mapa
		
		for (int i = 0; i < cantNodos+1; i++) {
			mapAdy.put(i, new ArrayList<Integer>(cantNodos+1));
		}
		
		//Cargo la matriz y vector adyacente
		
		for (int i = 0; i < cantAristas; i++) {
			
			int nodo1 = sc.nextInt();
			int nodo2 = sc.nextInt();
			int peso = sc.nextInt();
			
			matrizAdy[nodo1][nodo2] = peso;
			matrizAdy[nodo2][nodo1]	= peso;
			
			mapAdy.get(nodo1).add(nodo2);
			mapAdy.get(nodo2).add(nodo1);
			
			vectorAdy[this.matAVec(nodo1, nodo2)] = peso;
			
			arcos[i] = new Arco(nodo1, nodo2, peso);
			
		}
		
		for (int i = 0; i < matrizAdy.length; i++) {
			for (int j = 0; j < matrizAdy.length; j++) {
				if(matrizAdy[i][j] == 0)
					matrizAdy[i][j] = 999;
			}
		}
		
		this.mostrarMatrizAdy();
		System.out.println();
		this.mostrarVectorAdy();
		
		sc.close();
	}
	
	public void mostrarMatrizAdy() {
		for (int i = 0; i < matrizAdy.length; i++) {
			for (int j = 0; j < matrizAdy.length; j++) {
				System.out.print(matrizAdy[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public void mostrarVectorAdy() {
		for (int i = 0; i < vectorAdy.length; i++) {
			System.out.print(vectorAdy[i]+ " ");
		}
		System.out.println(vectorAdy.length);
	}
	
	public int matAVec(int fila, int col) {
		
		int valor;
		if(fila>col)
			valor = (int) (col*(cantNodos+1) + fila - ( Math.pow(col, 2) + 3*col + 2) /2);
		else
			valor = (int) (fila*(cantNodos+1) + col - ( Math.pow(fila, 2) + 3*fila + 2) /2);
		return valor ;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public int getTamVectorAdy() {
		return tamVectorAdy;
	}

	public int[] getVectorAdy() {
		return vectorAdy;
	}

	public HashMap<Integer, ArrayList<Integer>> getMapAdy() {
		return mapAdy;
	}

	public int[][] getMatrizAdy() {
		return matrizAdy;
	}
	
	
}
