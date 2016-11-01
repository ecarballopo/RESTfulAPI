package cr.ac.tec.ce2103.Estructuras.Main;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;
import cr.ac.tec.ce2103.Genetico.Genetico;
import cr.ac.tec.ce2103.Xml.EscritorArchivoXML;

public class MainGenetico {
	
	public static void main(String[] args) {
		
		Genetico G = new Genetico();
		EscritorArchivoXML XML = new EscritorArchivoXML();
		GenLista<int[]> L = new Simple<>();
		L = G.PrimeraGeneracion();
		System.out.println("\n"+ "Primera Oleada" + " ");
		for(int i = 0; i < L.tamaño(); i++){
			System.out.print("\nCriatura " + Integer.toString(i)+ ": " + L.RetornarNodo(i).get_Criatura() + " ");
			for(int j = 0; j < 6; j++){
				int[] a = L.Retornar(i);
				System.out.print(a[j] + " ");
			}
		}
		XML.WriteXML(L);
		System.out.println("\n"+ "###################################################################################");

		System.out.println("\n"+ "Oleada Genetica" + " ");
		GenLista<int[]> N = new Simple<>();
		N = G.GenOleada();
		for(int i = 0; i < N.tamaño(); i++){
			System.out.print("\nCriatura " + Integer.toString(i)+ ": " + N.RetornarNodo(i).get_Criatura() + " ");
			for(int j = 0; j < 6; j++){
				int[] a = N.Retornar(i);
				System.out.print(a[j] + " ");
			}
		}
		
		G.fitness();
		System.out.println("\n"+ "###################################################################################");

		System.out.println("\n"+ "Oleada Genetica2" + " ");
		GenLista<int[]> N2 = new Simple<>();
		N2 = G.GenOleada();
		for(int i = 0; i < N2.tamaño(); i++){
			System.out.print("\nCriatura " + Integer.toString(i)+ ": " + N2.RetornarNodo(i).get_Criatura() + " ");
			for(int j = 0; j < 6; j++){
				int[] a = N2.Retornar(i);
				System.out.print(a[j] + " ");
			}
		}
		
		G.fitness();
		System.out.println("\n"+ "###################################################################################");

		System.out.println("\n"+ "Oleada Genetica3" + " ");
		GenLista<int[]> N3 = new Simple<>();
		N3 = G.GenOleada();
		for(int i = 0; i < N3.tamaño(); i++){
			System.out.print("\nCriatura " + Integer.toString(i)+ ": " + N3.RetornarNodo(i).get_Criatura() + " ");
			for(int j = 0; j < 6; j++){
				int[] a = N3.Retornar(i);
				System.out.print(a[j] + " ");
			}
		}
		
		G.fitness();
	}
	
}
