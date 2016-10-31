package cr.ac.tec.ce2103.Json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;

public class Json {
	
	@SuppressWarnings("rawtypes")
	GenLista p = new Simple<>();
	
	 public void Lector(String MensajeEn){
		 System.out.println("Mensaje entrando "+ MensajeEn);
	
		JSONParser parse = new JSONParser();
		 
		try{
		    
		    String json = MensajeEn;
		    Object obj = parse.parse(json);
		    JSONObject jsonObject = (JSONObject) obj;
		    String Accion = (String) jsonObject.get("ID");
		    Accion(Accion, jsonObject);
		    
		}catch(ParseException e){
		    System.out.println("Type no especificado");
		    }
		        
	 }
	    

	private void Accion (String Accion, JSONObject json){
	     System.out.println("Json recibido");
	 
	 if (Accion.equals("Agregar")){
//		 p.Insertar("1", 0);
	 }
	 
	 else{
	     System.out.println("Formato del mensaje erroneo");
	     }
	 }

}
