package cr.ac.tec.ce2103.Rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;

@Path("/POST")
public class Post {
	
	@SuppressWarnings("rawtypes")
	GenLista p = new Simple();
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String estadoServidor(){
		return "<p>Entro POST</p>";
	}
	
	@SuppressWarnings("unchecked")
	@Path("/Insertar/{param}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public String datoOleada(@PathParam("param") String nuevo){
		p.Insertar(nuevo, 0);
		p.Imprimir();
		return "<p>"+ "Entradas Oleada " + nuevo + "</p>";
	}
	
	@POST
	@Path("/p")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateUser(@FormParam("id") int id,
			@FormParam("name") String name,
			@FormParam("profession") String profession) throws IOException{
		return "<p>"+ "Entradas Oleada " + name + "</p>" + profession +"</p>";
   }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@POST
	@Path("/P")
	public void addPersona(@FormParam("nombre") String nombre) {
		GenLista p = new Simple();
		p.Insertar(nombre, 0);
	}
	
}
