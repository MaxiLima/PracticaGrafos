package main;

import java.io.IOException;

import algoritmos.Dijkstra;
import algoritmos.Floyd;
import algoritmos.Prim;

public class App {

	private static String pathIn = "grafoConPeso.in";
	private static String pathOut = "grafoConPeso.out";
	
	public static void main(String[] args) throws IOException {
		
		
		Grafo grafo = new Grafo(pathIn, pathOut);
		Dijkstra dijkstra = new Dijkstra();
		Floyd floyd = new Floyd();
		Prim prim = new Prim();
		
		int[] distDijkstra = new int[10];
		int[][] distFloyd = new int [10][10];
		
		
		distDijkstra = dijkstra.resolver(grafo, 2);
		distFloyd = floyd.resolver(grafo);
		
		for (int i = 0; i < distDijkstra.length; i++) {
			System.out.print(distDijkstra[i]+" ");
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < distFloyd.length; i++) {
			for (int j = 0; j < distFloyd.length; j++) {
				System.out.print(distFloyd[i][j]+ "	");
			}
			System.out.println();
		}
		
		prim.resolver(grafo);
		prim.imprimirPrim(grafo.getMatrizAdy());
	}

}
