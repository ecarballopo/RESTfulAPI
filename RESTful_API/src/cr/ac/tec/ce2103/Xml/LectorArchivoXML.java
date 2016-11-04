package cr.ac.tec.ce2103.Xml;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Lista.Simple;

import javax.swing.JOptionPane;


public class LectorArchivoXML {

    GenLista <int[]> ListaOleada = new Simple<>();
    
    @SuppressWarnings({ "unused", "rawtypes" })
	public GenLista<int[]> ReadXML(int oleadaI, int oleadaF){
        
    	while(oleadaI <= oleadaF){
    		
    		String _Pruta = "E:/Proyectos_JavaEE/Repositorios/REST/RESTful_API/Oleadas/Oleada"+oleadaI+".xml";
    		File xmlFile = new java.io.File(_Pruta);
    		SAXBuilder builder = new SAXBuilder();
        
    		try{
            
    			Document document = (Document) builder.build(_Pruta);
    			Element rootNode = document.getRootElement();
    			List list = rootNode.getChildren();
            
    			if (list.equals(rootNode.getChildren("datos"))) {
                    
    					for (int j =0; j < list.size();j++){
    						
    						Element campo = (Element)list.get(j);
    						
    						String TipoEnemigo = campo.getChildText("TipoEnemigo");
    						String TipoEnemigo_ID = campo.getChildText("TipoEnemigo_ID");
    						String Vida = campo.getChildText("Vida");
    						String Velocidad = campo.getChildText("Velocidad");
    						String ResF = campo.getChildText("ResF");
    						String ResM = campo.getChildText("ResM");
    						String ResA = campo.getChildText("ResA");
                        
    						
    						int[] DatoOleada = new int[6];
    						DatoOleada[0]= Integer.parseInt(TipoEnemigo_ID);
    						DatoOleada[1]= Integer.parseInt(Vida);
    						DatoOleada[2]= Integer.parseInt(Velocidad);
    						DatoOleada[3]= Integer.parseInt(ResF);
    						DatoOleada[4]= Integer.parseInt(ResM);
    						DatoOleada[5]= Integer.parseInt(ResA);
    						ListaOleada.Insertar(TipoEnemigo,DatoOleada,-1);                           
    					}
    					
    				System.out.println("Termina Oleada: "+oleadaI);
    				oleadaI++;
                
    			}else {
    				JOptionPane.showMessageDialog(null,"Error al leer XML");
    			}
            
        
    		}catch (IOException io){
    			System.out.println(io.getMessage());
    			JOptionPane.showMessageDialog(null, _Pruta + " no existe");
            
       
    		}catch (JDOMException jdomex){
    			System.out.println(jdomex.getMessage());
            
    		}
    		//return ListaOleada;
        }
		return ListaOleada;
    
    }
    
}
