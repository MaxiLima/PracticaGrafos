package algoritmos;

import main.Grafo;

public class Floyd {
	
	private int[][] distancias;
	private int tam;
	
	public int[][] resolver (Grafo grafo){
		
		this.inicializar(grafo);
		
		for (int k = 0; k < distancias.length; k++) {
			for (int i = 0; i < distancias.length; i++) {
				for (int j = 0; j < distancias.length; j++) {
					if (this.distancias[i][k] + this.distancias[k][j] < this.distancias[i][j])
                        this.distancias[i][j] = this.distancias[i][k] + this.distancias[k][j];
				}
			}
		}
		
		
		
		return this.distancias;
	}

	private void inicializar(Grafo grafo) {
		
		this.tam = grafo.getCantNodos()+1;
		distancias = new int[tam][tam];
		
		for (int i = 0; i < distancias.length; i++) {
			for (int j = 0; j < distancias.length; j++) {
				
				if(i == j)
					this.distancias[i][j] = 0;
				else{
					if(grafo.getMatrizAdy()[i][j] == 0)
						this.distancias[i][j] = 999;
					else
						this.distancias[i][j] = grafo.getMatrizAdy()[i][j];
				}
			}
		}
		
	}
}
