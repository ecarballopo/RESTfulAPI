package cr.ac.tec.ce2103.Genetico;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;
import cr.ac.tec.ce2103.Xml.EscritorArchivoXML;

public class Genetico {
		
	private GenLista<int[]> Oleada = new Simple<>();
	private int Inicial = 5;
	private int Vida = 100;
	private GenLista<Integer> fitness = new Simple<>();
	private EscritorArchivoXML XML = new EscritorArchivoXML();
	private double porcentajefit = 0.2;
	private double porcentajeMut = 0.08;
	private double porcentajeAumentoMut = 1.5;
	private String[] Criaturas = {"Ogro","Arpia","Elfo","Mercenario"};
	private Random rnd = new Random();
	
	public void GetOleada(){
		PrimeraGeneracion();
		System.out.println("Inicial "+fit());
		while(fit() < 300){
			System.out.println("While "+fit());
			GenOleada();
		}
	}
	
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
			}
		}
		XML.WriteXML(Oleada);
		return Oleada;
	}
	
	public GenLista<int[]> GenOleada(){
		double porcentaje = RandomAtrib(0,20)/100.000;
		if(porcentaje < porcentajeMut){
			System.out.println("MUTACIÓN "+porcentaje);
//			Cross();
			Mutation();
			XML.WriteXML(Oleada);
		}else{
			Cross();
			XML.WriteXML(Oleada);
		}
		return Oleada;
	}
	
	public int[] fitness() {
		int fit = 0;
		for(int i = 0; i < Oleada.tamaño(); i++){
			for(int j = 3; j < 6; j++){
				int[] a = Oleada.Retornar(i);
				fit += a[j];
			}
			fitness.Insertar(fit, -1);
			fit = 0;
		}
		int tamaño = (int) (fitness.tamaño()*porcentajefit);
		int[] PosFit = mejores(tamaño);
		
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
				if(Primo(j)){
					for(int k = 0; k < 6; k++){
						if(k < 3){
							Atrib[k] = Oleada.RetornarNodo(j).get_Atrib()[k];
						}else{
							if(Atrib[k] < 100){
								Atrib[k] = Oleada.RetornarNodo(PosMejores[i]).get_Atrib()[k] + 15;
							}else{
								Atrib[k] = Oleada.RetornarNodo(PosMejores[i]).get_Atrib()[k];
							}
							
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
				for(int j = 3; j < nAtrib.length; j++){
					if (nAtrib[j] < 100){
						double mut = RandomAtrib(0,100)/100.000;
						if(mut < 0.05){
							nAtrib[j] = nAtrib[j] + (100 - nAtrib[j]);
						}else{
							nAtrib[j] = (int) (nAtrib[j]*porcentajeAumentoMut);
						}
					}
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
	
	private int[] mejores(int tamaño){
		int[] maximos = new int[tamaño];
		for(int i = 0; i < tamaño ; i++){
			maximos[i] = posmax();
		}
		return maximos;
	}
	
	private int posmax(){
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
	
	private int fit() {
		int fit = 0;
		for(int i = 0; i < Oleada.tamaño(); i++){
			for(int j = 3; j < 6; j++){
				int[] a = Oleada.Retornar(i);
				fit += a[j];
			}
			fitness.Insertar(fit, -1);
			fit = 0;
		}
		int max = 0;
        for (int i = 0; i < fitness.tamaño(); i++) {
            if (fitness.RetornarNodo(i).get_Dato() > max) {
                max = fitness.RetornarNodo(i).get_Dato();
            }
        }
		fitness.Eliminar();
		return max;
	}
	
	private boolean Primo(int num){
		int a = 0;
		for(int i = 1; i < (num+1); i++){
			if(num % i == 0){
				a++;
				}
			}
	         if(a!=2){
	              return false;
	         }else{
	        	 return true;
	         }
	}
	
}
