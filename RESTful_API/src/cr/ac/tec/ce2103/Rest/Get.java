package cr.ac.tec.ce2103.Rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/GET")
public class Get {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String estadoServidor(){
		return "<p>Entro GET</p>";
	}
	
	@Path("/Oleada/{type}")
	@GET
	@Produces({"text/plain","text/xml", 
		"application/json"})
	public String Mensaje(@PathParam("type") String tipo){

		if(tipo.equalsIgnoreCase("texto")){
			return "Este es mi primer servicio RESTful con Java";
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
