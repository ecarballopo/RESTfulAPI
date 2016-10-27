package cr.ac.tec.ce2103.Estructuras.Main;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;

public class MainListas {

	public static void main(String[] args) {
		
		 GenLista<String> Lista = new Simple<>();
		 
		 Lista.Insertar("H", Lista.tama�o());
		 Lista.Insertar("o", Lista.tama�o());
		 Lista.Insertar("l", Lista.tama�o());
		 Lista.Insertar("a", Lista.tama�o());
		 Lista.Insertar("M", Lista.tama�o());
		 Lista.Insertar("u", Lista.tama�o());
		 Lista.Insertar("n", Lista.tama�o());
		 Lista.Insertar("d", Lista.tama�o());
		 Lista.Insertar("o", Lista.tama�o());
		 
		 Lista.RetornarNodo(2).set_Free(true);
		 Lista.RetornarNodo(3).set_Free(true);
		 Lista.RetornarNodo(5).set_Free(true);
		 Lista.RetornarNodo(6).set_Free(true);
		 Lista.RetornarNodo(7).set_Free(true);
	
		 Lista.Imprimir();
		 
	}

}
