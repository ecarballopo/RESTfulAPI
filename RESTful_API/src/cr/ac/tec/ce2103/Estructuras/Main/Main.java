package cr.ac.tec.ce2103.Estructuras.Main;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;
import cr.ac.tec.ce2103.Xml.EscritorArchivoXML;
import cr.ac.tec.ce2103.Xml.LectorArchivoXML;

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
		Lista.Insertar("Ogro",Enemigo1, 0);
		Lista.Insertar("Elfo",Enemigo2, 0);
		Lista.Insertar("Arpia",Enemigo3, 0);
		Lista.Insertar("Artillero",Enemigo4, 0);
		Lista.Insertar("Arpia",Enemigo5, 0);
		Lista.Insertar("Elfo",Enemigo6, 0);
		XML.WriteXML(Lista);
		
		GenLista <String []> Lista2 = new Simple<>();
		String[] Enemigo7 = {"Ogro","14","24","6","8","10"};
		String[] Enemigo8 = {"Elfo","14","4","6","8","10"};
		String[] Enemigo9 = {"Arpia","14","4","6","8","10"};
		String[] Enemigo10 = {"Artillero","14","4","6","8","10"};
		String[] Enemigo11 = {"Arpia","14","4","6","8","10"};
		String[] Enemigo12 = {"Elfo","14","4","6","8","10"};
		Lista2.Insertar("Ogro",Enemigo7, 0);
		Lista2.Insertar("Elfo",Enemigo8, 0);
		Lista2.Insertar("Arpia",Enemigo9, 0);
		Lista2.Insertar("Artillero",Enemigo10, 0);
		Lista2.Insertar("Arpia",Enemigo11, 0);
		Lista2.Insertar("Elfo",Enemigo12, 0);
		XML.WriteXML(Lista2);
		
		
		
		/*GenLista <String []> prueba = new Simple<>();
		prueba = lXML.ReadXML(0,1);
		prueba.Imprimir();*/
	}

}