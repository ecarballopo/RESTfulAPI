package cr.ac.tec.ce2103.Rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;
import cr.ac.tec.ce2103.Estructuras.Matriz.CreadorM;
import cr.ac.tec.ce2103.Genetico.Genetico;
import cr.ac.tec.ce2103.Xml.LectorArchivoXML;

@Path("/GET")
public class Get {
	
	private Genetico G = new Genetico();
	private CreadorM N = new CreadorM();
	private LectorArchivoXML L = new LectorArchivoXML();
	
	@Path("/Oleadas")
	@GET
	@Produces({"text/plain"})
	public String Primera(){
		G.GetOleada();
		return "Creadas";
	}
	
	@Path("/GenOleada/{numOleada}")
	@GET
	@Produces({"text/plain"})
	public String Oleada(@PathParam("numOleada") int numOleada){
		return N.convierteM(L.ReadXML(numOleada, numOleada));
	}
	
	@Path("/Estadisticas/{numOleadaI}/{numOleadaF}")
	@GET
	@Produces({"text/plain"})
	public String Estadisticas(@PathParam("numOleadaI") int numOleadaI,@PathParam("numOleadaF") int numOleadaF){
		return N.convierteM(L.ReadXML(numOleadaI, numOleadaF));
	}
}
