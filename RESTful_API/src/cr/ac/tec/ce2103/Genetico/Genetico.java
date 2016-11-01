package cr.ac.tec.ce2103.Genetico;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;
import cr.ac.tec.ce2103.Xml.EscritorArchivoXML;

public class Genetico {
		
	private GenLista<int[]> Oleada = new Simple<>();
	private GenLista<int[]> Copia;
	private int Inicial = 3;
	private int Vida = 100;
	private GenLista<Integer> fitness = new Simple<>();
	private EscritorArchivoXML XML = new EscritorArchivoXML();
	private double porcentajefit = 0.2;
	private double porcentajeMut = 0.08;
	private double porcentajeAumentoMut = 1.5;
	private String[] Criaturas = {"Ogro","Arpia","Elfo","Mercenario"};
	private Random rnd = new Random();
	
	public GenLista<int[]> PrimeraGeneracion(){
		while(Inicial > 0){
			String Criatura = RandomCriat();
			if(Criatura == "Ogro"){
				int[] Enemigo = {1,Vida,RandomAtrib(1,1),RandomAtrib(10,15),RandomAtrib(2,5),RandomAtrib(2,5)};
				Oleada.Insertar(Criatura,Enemigo, -1);
				Inicial--;
			}else if(Criatura == "Arpia"){
				int[] Enemigo = {3,Vida,RandomAtrib(1,1),RandomAtrib(6,8),RandomAtrib(6,8),RandomAtrib(100,100)};
				Oleada.Insertar(Criatura,Enemigo, -1);
				Inicial--;
			}else if(Criatura == "Elfo"){
				int[] Enemigo = {2,Vida,RandomAtrib(1,1),RandomAtrib(2,5),RandomAtrib(10,15),RandomAtrib(2,5)};
				Oleada.Insertar(Criatura,Enemigo, -1);
				Inicial--;
			}else if(Criatura == "Mercenario"){
				int[] Enemigo = {4,Vida,RandomAtrib(1,1),RandomAtrib(10,15),RandomAtrib(2,5),RandomAtrib(10,15)};
				Oleada.Insertar(Criatura,Enemigo, -1);
				Inicial--;
			}else{
				Copia = Oleada;
//				XML.WriteXML(Copia);
				return Oleada;
			}
		}
//		XML.WriteXML(Oleada);
		return Oleada;
	}
	
	public GenLista<int[]> GenOleada(){
		double porcentaje = RandomAtrib(0,20)/100.000;
		if(porcentaje < porcentajeMut){
			System.out.println("MUTACIÓN "+porcentaje);
			Cross();
			Mutation();
		}else{
			Cross();
		}
		Copia = Oleada;
//		XML.WriteXML(Copia);
		return Oleada;
	}
	
	public int[] fitness() {
		int fit = 0;
		for(int i = 0; i < Oleada.tamaño(); i++){
			for(int j = 1; j < 6; j++){
				int[] a = Oleada.Retornar(i);
				fit += a[j];
			}
			fitness.Insertar(fit, -1);
			fit = 0;
		}
		
		int[] PosFit = mejores(fitness,(int) (fitness.tamaño()*porcentajefit));
		
		int cont2 = 0;
		System.out.println("\nPosiciones Mejores Fitness" + " ");
		while(PosFit.length > cont2){
			System.out.print(PosFit[cont2] + " ");
			cont2++;
		}
		
		fitness.Eliminar();
		return PosFit;
	}

	public void Cross() {
		int[] PosMejores = fitness();
		int Combinar = Oleada.tamaño();
		for(int i = 0; i < PosMejores.length; i++){
			for(int j = 0; j < Combinar; j++){
				int[] Atrib = new int[6];
				if(j%2 == 0){
					for(int k = 0; k < 6; k++){
						if(k < 3){
							Atrib[k] = Oleada.RetornarNodo(j).get_Atrib()[k];
						}else{
							Atrib[k] = Oleada.RetornarNodo(PosMejores[i]).get_Atrib()[k];
						}
					}
					if(Atrib[0] == 1){
						Oleada.Insertar("Ogro",Atrib, -1);
					}else if(Atrib[0] == 2){
						Oleada.Insertar("Elfo",Atrib, -1);
					}else if(Atrib[0] == 3){
						Oleada.Insertar("Arpia",Atrib, -1);
					}else{
						Oleada.Insertar("Mercenario",Atrib, -1);
					}
				}
			}
		}
	}
	
	public void Mutation() {
		for(int i = 0; i < Oleada.tamaño(); i++){
			if(i%2 != 0){
				int[] nAtrib = Oleada.RetornarNodo(i).get_Atrib();
				for(int j = 2; j < nAtrib.length; j++){
					nAtrib[j] = (int) (nAtrib[j]*porcentajeAumentoMut);
				}
				Oleada.RetornarNodo(i).set_Atrib(nAtrib);
			}
		}
	}
	
//##########################################################################################################################################
	private int RandomAtrib(int inf,int sup){
		return ThreadLocalRandom.current().nextInt(inf, sup + 1);
	}
	
	private String RandomCriat(){
		return Criaturas[rnd.nextInt(4)];
	}
	
	private int[] mejores(GenLista<Integer> fitness, int tamaño){
		int[] maximos = new int[tamaño];
		for(int i = 0; i < tamaño ; i++){
			maximos[i] = max();
		}
		return maximos;
	}
	
	private int max(){
		int max = 0;
		int posMax = 0;
        for (int i = 0; i < fitness.tamaño(); i++) {
            if (fitness.RetornarNodo(i).get_Dato() > max) {
                max = fitness.RetornarNodo(i).get_Dato();
            }
        }
        posMax = fitness.RetornarPos(max);
        fitness.RetornarNodo(posMax).set_Dato(0);
		return posMax;
	}
	
}
