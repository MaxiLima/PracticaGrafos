package algoritmos;

import main.Grafo;

public class Dijkstra {
	private int[] distancias;
	private boolean[] vistos;
	private int nodosVistos;
	private int posMin;
	private int[] recorrido;
	private int nodoSig;
	
	public int[] resolver(Grafo grafo, int nodoInicial) {
		
		this.inicializar(grafo, nodoInicial);
		posMin = this.getPosMenor(this.distancias);
		int min;
		
		
		for (int i = 0; i < distancias.length; i++) {
			 
			min = 999;
			
			for (int j = 0; j < distancias.length; j++) {
				
				if(min > this.distancias[i] && this.vistos[i] == false) {
					nodoSig = i;
					min = this.distancias[i];
				}
			}
			
			this.vistos[nodoSig] = true;
			
			for (int j = 0; j < distancias.length; j++) {
				
				if(this.vistos[i] != true) {
					
					if(min + grafo.getVectorAdy()[grafo.indicesMatAVec(nodoSig, i)] < this.distancias[i]) {
						
						this.distancias[i] = min + grafo.getVectorAdy()[grafo.indicesMatAVec(nodoSig, i)];
						recorrido[i] = nodoSig;
					}
				}
			}
			
		}
		
		
		return this.distancias;
	}
	
	public void inicializar(Grafo grafo, int nodoInicial) {
		
		distancias = new int[grafo.getCantNodos()+1];
		
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = grafo.getVectorAdy()[grafo.indicesMatAVec(nodoInicial, i)];
		}
		
		vistos = new boolean[grafo.getCantNodos()+1];
		
		for (int i = 0; i < vistos.length; i++) {
			vistos[i] = false;
		}
		
		this.distancias[nodoInicial] = 0;
		this.vistos[nodoInicial] = true;
		this.nodosVistos = 1;
		
		recorrido = new int[grafo.getCantNodos()+1];
		for (int i = 0; i < recorrido.length; i++) {
			recorrido[i] = 0;
		}
	}
	
	public int getPosMenor(int[]vector) {
		
		int min = 0;
		int pos = 0;
		boolean flag = true;
		
		for (int i = 1; i < vector.length; i++) {
			if(this.vistos[i]==false &&flag) {
				min = this.distancias[i];
				pos = i;
				flag = false;
			}
			else
				if(this.vistos[i] == false && this.distancias[i]<min) {
					min = this.distancias[i];
					pos = i;
				}
		}
		
		return pos;
	}
}
