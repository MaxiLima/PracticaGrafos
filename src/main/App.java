package main;

import java.io.IOException;

import algoritmos.Dijkstra;

public class App {

	private static String pathIn = "grafoConPeso.in";
	private static String pathOut = "grafoConPeso.out";
	
	public static void main(String[] args) throws IOException {
		
		
		Grafo grafo = new Grafo(pathIn, pathOut);
		Dijkstra dijkstra = new Dijkstra();
		int[] dist = new int[10];
		dist = dijkstra.resolver(grafo, 2);
		
		for (int i = 0; i < dist.length; i++) {
			System.out.print(dist[i]+" ");
		}
	}

}
