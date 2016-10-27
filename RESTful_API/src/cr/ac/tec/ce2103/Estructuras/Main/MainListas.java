package cr.ac.tec.ce2103.Estructuras.Main;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;

public class MainListas {

	public static void main(String[] args) {
		
		 GenLista<String> Lista = new Simple<>();
		 
		 Lista.Insertar("H", Lista.tamaño());
		 Lista.Insertar("o", Lista.tamaño());
		 Lista.Insertar("l", Lista.tamaño());
		 Lista.Insertar("a", Lista.tamaño());
		 Lista.Insertar("M", Lista.tamaño());
		 Lista.Insertar("u", Lista.tamaño());
		 Lista.Insertar("n", Lista.tamaño());
		 Lista.Insertar("d", Lista.tamaño());
		 Lista.Insertar("o", Lista.tamaño());
		 
		 Lista.RetornarNodo(2).set_Free(true);
		 Lista.RetornarNodo(3).set_Free(true);
		 Lista.RetornarNodo(5).set_Free(true);
		 Lista.RetornarNodo(6).set_Free(true);
		 Lista.RetornarNodo(7).set_Free(true);
	
		 Lista.Imprimir();
		 
	}

}
