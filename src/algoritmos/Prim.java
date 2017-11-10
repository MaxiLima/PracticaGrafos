package algoritmos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import main.Grafo;

public class Prim {
	
	private int tam;
	private boolean [] vistos;
	private HashMap<Integer, Integer> camino;
	private int[] pesos;
	
	public void resolver (Grafo grafo){
		
		this.inicializar(grafo);
		
		pesos[0] = 0;
		//padre[0] = -1;
		
		for (int i = 0; i < pesos.length; i++) {
			
			int minInd = minimaKey(pesos, vistos);
			
			vistos[minInd] = true;
			for (int j = 0; j < tam; j++)
				 
                if (grafo.getMatrizAdy()[minInd][j]!=0 && vistos[j] == false &&
                    grafo.getMatrizAdy()[minInd][j] <  pesos[j])
                {
                    camino.put(minInd, j);
                    pesos[j] = grafo.getMatrizAdy()[minInd][j];
                }
		}
	}
	
	

	public void inicializar (Grafo grafo){
		
		this.tam = grafo.getCantNodos()+1;
		//padre = new int[this.tam];
		pesos = new int[this.tam];
		vistos = new boolean[tam];
		camino = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < pesos.length; i++) {
			pesos[i] = 999;
			vistos[i] = false;
		}
		
		
	}
	
	private int minimaKey(int[] key, boolean[] vistos) {
		
		int min = 0;
		int pos = 0;
		boolean flag = true;
		
		for (int i = 1; i < tam; i++) {
			if(this.vistos[i]==false && flag) {
				min = key[i];
				pos = i;
				flag = false;
			}
			else
				if(this.vistos[i] == false && key[i]<min) {
					min = key[i];
					pos = i;
				}
		}
		
		return pos;
	}
	
	public void imprimirPrim(int grafo[][])
    {
		Iterator it = this.camino.entrySet().iterator();
        System.out.println("Arista   Peso");
        while(it.hasNext()){
        	Map.Entry par = (Map.Entry) it.next();
        	int key =(int) par.getKey();
        	int valor = (int) par.getValue();
        	int peso = grafo[key][valor];
        	System.out.println(key+"-"+valor+"   "+peso);
        }
       // for (int i = 1; i < tam; i++)
//            System.out.println(this.padre[i]+" - "+ i+"    "+
//                               grafo[i][this.padre[i]]);
    }




	
	
}
