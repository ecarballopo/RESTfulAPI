package cr.ac.tec.ce2103.Estructuras.Matriz;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;

public class CreadorM {
	
	String[][] MatrizEnemigos;
	int fila = 0;
	int columna = 0;
	
	public String convierteM(GenLista<int[]> lista){
		
		fila = lista.tama�o();
		columna = lista.RetornarNodo(0).get_Atrib().length;
		MatrizEnemigos = new String [fila][columna];
		for (int i=0; i<lista.tama�o();i++){
			for (int j=0; j<lista.RetornarNodo(0).get_Atrib().length;j++){
				int dato = (lista.RetornarNodo(i).get_Atrib())[j];
				String Dato = Integer.toString(dato);
				MatrizEnemigos[i][j]= Dato;
			}
		}
//		ImprimeMatriz();
		return Integer.toString(fila) + "/" +ImprimeMatriz();
	}
	
	private String ImprimeMatriz(){
		String A="";
		for (int i=0; i<MatrizEnemigos.length;i++){
				A = A + MatrizEnemigos[i][0]+","+MatrizEnemigos[i][1]+","+MatrizEnemigos[i][2]+","+
						MatrizEnemigos[i][3]+","+MatrizEnemigos[i][4]+","+MatrizEnemigos[i][5]+"/";
		}
		return A;
	}
}
