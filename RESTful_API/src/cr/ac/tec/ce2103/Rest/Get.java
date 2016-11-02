package cr.ac.tec.ce2103.Rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;
import cr.ac.tec.ce2103.Estructuras.Matriz.CreadorM;
import cr.ac.tec.ce2103.Genetico.Genetico;

@Path("/GET")
public class Get {
	
	private Genetico G = new Genetico();
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String estadoServidor(){
		return "<p>Entro GET</p>";
	}
	
	@Path("/PrimeraOleada/{type}")
	@GET
	@Produces({"text/plain","text/xml", 
		"application/json"})
	public String Primera(@PathParam("type") String tipo){

//		if(tipo.equalsIgnoreCase("texto")){
//			G.PrimeraGeneracion();
//			return "Creada";
//
//		}
//		else if(tipo.equalsIgnoreCase("xml")){
//			String[][] a = {{"a","b"}};
//			return a;
//		}
//		else if(tipo.equalsIgnoreCase("json")){
//			G.GetOleada();
//			return "{Oleada:Id}";
//		}
//		else{
//			return "Tipo no soportado";
//		}
		CreadorM A = new CreadorM();
		return A.convierteM(G.PrimeraGeneracion());
	}
	
	@Path("/GenOleada/{type}")
	@GET
	@Produces({"text/plain","text/xml", 
		"application/json"})
	public String Moficada(@PathParam("type") String tipo){

		if(tipo.equalsIgnoreCase("texto")){
			
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
			return "Oleada Modificada";
		}
		else if(tipo.equalsIgnoreCase("xml")){
			return "<Oleada>Id</Oleada>";
		}
		else if(tipo.equalsIgnoreCase("json")){
			return "{Oleada:Id}";
		}
		else{
			return "Tipo no soportado";
		}
	}
}
