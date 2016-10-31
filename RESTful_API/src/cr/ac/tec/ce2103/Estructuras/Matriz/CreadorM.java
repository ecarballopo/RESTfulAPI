package cr.ac.tec.ce2103.Estructuras.Matriz;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;

public class CreadorM {
	
	int[][] MatrizEnemigos;
	
	public int[][] convierteM(GenLista<int[]> lista){
		
		MatrizEnemigos = new int [lista.tamaño()][lista.RetornarNodo(0).get_Atrib().length];
		System.out.println(lista.tamaño()+"filas");
		System.out.println(lista.RetornarNodo(0).get_Atrib().length+"columnas");
		System.out.println((lista.RetornarNodo(0).get_Atrib())[0]);
		for (int i=0; i<lista.tamaño();i++){
			for (int j=0; j<lista.RetornarNodo(0).get_Atrib().length;j++){
				MatrizEnemigos[i][j]= (lista.RetornarNodo(i).get_Atrib())[j];
			}
		}
		ImprimeMatriz();
		return MatrizEnemigos;
		
	}
	
	private void ImprimeMatriz(){
		for (int i=0; i<MatrizEnemigos.length;i++){
			//for (int j=0; j<(MatrizEnemigos[0].length);j++){
				
				System.out.println("["+MatrizEnemigos[i][0]+"]"+"["+MatrizEnemigos[i][1]+"]"+"["+MatrizEnemigos[i][2]+"]"+
						"["+MatrizEnemigos[i][3]+"]"+"["+MatrizEnemigos[i][4]+"]"+"["+MatrizEnemigos[i][5]+"]");
		
			//}


		}
	}
}


/*
Ogro 1
elfo 2
arpia 3
mercenario 4
*/
