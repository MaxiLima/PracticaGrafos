package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {
	
	//Declaro todas las variables que necesito
	private Scanner sc;
	private int cantNodos;
	private int cantAristas;
	private int[][] matrizAdy;
	private int[] vectorAdy;
	private int tamVectorAdy;
	private ArrayList<ArrayList<Integer>> listaAdy;

	//Constructor
	public Grafo (String pathIn, String pathOut) throws IOException {
		
		sc = new Scanner(new File(pathIn));
		
		cantNodos = sc.nextInt();
		cantAristas = sc.nextInt();
		
		matrizAdy = new int[cantNodos+1][cantNodos+1];
		tamVectorAdy = (int) ((Math.pow(cantNodos, 2)+cantNodos)/2);
		vectorAdy = new int[tamVectorAdy];
		listaAdy = new ArrayList<ArrayList<Integer>>(cantNodos);
		
		//Cargo la matriz adyacente
		
		for (int i = 0; i < cantAristas; i++) {
			
			int nodo1 = sc.nextInt();
			int nodo2 = sc.nextInt();
			int peso = sc.nextInt();
			
			matrizAdy[nodo1][nodo2] = peso;
			matrizAdy[nodo2][nodo1]	= peso;
			
		}
		
		this.mostrarMatrizAdy();
		
		
	}
	
	public void mostrarMatrizAdy() {
		for (int i = 0; i < matrizAdy.length; i++) {
			for (int j = 0; j < matrizAdy.length; j++) {
				System.out.print(matrizAdy[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
