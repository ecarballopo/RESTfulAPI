package cr.ac.tec.ce2103.Xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;


public class EscritorArchivoXML {
	private int count =0;
	
    
		public StreamResult WriteXML(GenLista<int[]> Lista){
			int contador =0;
			GenLista<int[]> lista = Lista;
        
        try{
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            Document doc = docBuilder.newDocument();
            
            
            Element rootElement = doc.createElement("GeneticKingdom");
            doc.appendChild(rootElement);
            
            
            
            while(contador<lista.tamaño()){
            
                Element datos = doc.createElement("datos");
                rootElement.appendChild(datos);
                    
                    int[] arregloDatos =  (int[]) (lista.RetornarNodo(contador).get_Atrib());
                    
                    Element nodo0 = doc.createElement("TipoEnemigo");
                    nodo0.appendChild(doc.createTextNode(lista.RetornarNodo(contador).get_Criatura()));
                    datos.appendChild(nodo0);
                    
                    Element nodo1 = doc.createElement("TipoEnemigo_ID");
                    nodo1.appendChild(doc.createTextNode(Integer.toString(arregloDatos[0])));
                    datos.appendChild(nodo1);
                    
                    Element nodo2 = doc.createElement("Vida");
                    nodo2.appendChild(doc.createTextNode(Integer.toString(arregloDatos[1])));
                    datos.appendChild(nodo2);
                    
                    Element nodo3 = doc.createElement("Velocidad");
                    nodo3.appendChild(doc.createTextNode(Integer.toString(arregloDatos[2])));
                    datos.appendChild(nodo3);
                    
                    Element nodo4 = doc.createElement("ResF");
                    nodo4.appendChild(doc.createTextNode(Integer.toString(arregloDatos[3])));
                    datos.appendChild(nodo4);
                    
                    Element nodo5 = doc.createElement("ResM");
                    nodo5.appendChild(doc.createTextNode(Integer.toString(arregloDatos[4])));
                    datos.appendChild(nodo5);
                    
                    Element nodo6 = doc.createElement("ResA");
                    nodo6.appendChild(doc.createTextNode(Integer.toString(arregloDatos[5])));
                    datos.appendChild(nodo6);
                    contador++;
                       
            }   
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Oleada"+ count + ".xml");
            count++;
            transformer.transform(source, result);
            
            
        }catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }catch(TransformerException tfe){
            tfe.printStackTrace();
        }
        return null;
    }
    
}
