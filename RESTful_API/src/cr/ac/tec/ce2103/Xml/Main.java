package cr.ac.tec.ce2103.Xml;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;

public class Main {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		GenLista <String []> Lista = new Simple<>();
		EscritorArchivoXML XML = new EscritorArchivoXML();
		LectorArchivoXML lXML = new LectorArchivoXML();
		
		String[] Enemigo1 = {"Ogro","14","24","6","8","10"};
		String[] Enemigo2 = {"Elfo","14","4","6","8","10"};
		String[] Enemigo3 = {"Arpia","14","4","6","8","10"};
		String[] Enemigo4 = {"Artillero","14","4","6","8","10"};
		String[] Enemigo5 = {"Arpia","14","4","6","8","10"};
		String[] Enemigo6 = {"Elfo","14","4","6","8","10"};
		Lista.Insertar(Enemigo1, 0);
		Lista.Insertar(Enemigo2, 0);
		Lista.Insertar(Enemigo3, 0);
		Lista.Insertar(Enemigo4, 0);
		Lista.Insertar(Enemigo5, 0);
		Lista.Insertar(Enemigo6, 0);
		XML.WriteXML(Lista);
		
		GenLista <String []> Lista2 = new Simple<>();
		String[] Enemigo7 = {"Ogro","14","24","6","8","10"};
		String[] Enemigo8 = {"Elfo","14","4","6","8","10"};
		String[] Enemigo9 = {"Arpia","14","4","6","8","10"};
		String[] Enemigo10 = {"Artillero","14","4","6","8","10"};
		String[] Enemigo11 = {"Arpia","14","4","6","8","10"};
		String[] Enemigo12 = {"Elfo","14","4","6","8","10"};
		Lista2.Insertar(Enemigo7, 0);
		Lista2.Insertar(Enemigo8, 0);
		Lista2.Insertar(Enemigo9, 0);
		Lista2.Insertar(Enemigo10, 0);
		Lista2.Insertar(Enemigo11, 0);
		Lista2.Insertar(Enemigo12, 0);
		XML.WriteXML(Lista2);
		
		
		
		/*GenLista <String []> prueba = new Simple<>();
		prueba = lXML.ReadXML(0,1);
		prueba.Imprimir();*/
	}

}
