package algoritmos;

import main.Grafo;

public class Dijkstra {
	private int[] distancias;
	private boolean[] vistos;
	private int nodosVistos;
	private int[] recorrido;
	private int nodoAct;
	
	public int[] resolver(Grafo grafo, int nodoInicial) {
		
		this.inicializar(grafo, nodoInicial);
		
		nodoAct = this.getPosMenor(this.distancias);
		this.vistos[nodoAct] = true;
		this.nodosVistos++;
		
		while(this.nodosVistos != grafo.getCantNodos()+1){
			
			for (int i = 0; i < grafo.getMapAdy().get(nodoAct).size() ; i++) {
				
				int indice = grafo.getMapAdy().get(nodoAct).get(i);
				int pesoEnVec = grafo.getVectorAdy()[grafo.matAVec(nodoAct, indice)];
				int comp = this.distancias[nodoAct] + pesoEnVec;
				int distIndice = this.distancias[indice];
				if ( comp < distIndice){
					
					this.distancias[indice] = comp;
					this.recorrido[indice] = nodoAct;
				}
			}
			
			nodoAct = this.getPosMenor(this.distancias);
			this.vistos[nodoAct] = true;
			this.nodosVistos++;
		}
		
		
		return this.distancias;
	}
	
	public void inicializar(Grafo grafo, int nodoInicial) {
		
		distancias = new int[grafo.getCantNodos()+1];
		
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = grafo.getVectorAdy()[grafo.matAVec(nodoInicial, i)];
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
