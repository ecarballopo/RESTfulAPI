package cr.ac.tec.ce2103.Estructuras.Matriz;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;

public class CreadorM {
	
	String[][] MatrizEnemigos;
	
	public String[][] convierteM(GenLista<int[]> lista){
		
		MatrizEnemigos = new String [lista.tama�o()][lista.RetornarNodo(0).get_Atrib().length];
		System.out.println(lista.tama�o()+"filas");
		System.out.println(lista.RetornarNodo(0).get_Atrib().length+"columnas");
		System.out.println((lista.RetornarNodo(0).get_Atrib())[0]);
		for (int i=0; i<lista.tama�o();i++){
			for (int j=0; j<lista.RetornarNodo(0).get_Atrib().length;j++){
				int dato = (lista.RetornarNodo(i).get_Atrib())[j];
				String Dato = Integer.toString(dato);
				MatrizEnemigos[i][j]= Dato;
			}
		}
		ImprimeMatriz();
		return MatrizEnemigos;
	}
	
	private void ImprimeMatriz(){
		for (int i=0; i<MatrizEnemigos.length;i++){
				
				System.out.println("["+MatrizEnemigos[i][0]+"]"+"["+MatrizEnemigos[i][1]+"]"+"["+MatrizEnemigos[i][2]+"]"+
						"["+MatrizEnemigos[i][3]+"]"+"["+MatrizEnemigos[i][4]+"]"+"["+MatrizEnemigos[i][5]+"]");
		}
	}
}
