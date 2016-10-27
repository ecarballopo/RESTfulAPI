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
	public int count =0;
    
        public StreamResult WriteXML(GenLista lista){
        
        try{
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            Document doc = docBuilder.newDocument();
            
            
            Element rootElement = doc.createElement("GeneticKingdom");
            doc.appendChild(rootElement);
            
            
            
            while(lista.tama�o()!=0){
            
                Element datos = doc.createElement("datos");
                rootElement.appendChild(datos);
                    
                    String[] arregloDatos = (String[]) (lista.Retornar(0));
                    
                    Element nodo0 = doc.createElement("TipoEnemigo");
                    nodo0.appendChild(doc.createTextNode(arregloDatos[0]));
                    datos.appendChild(nodo0);
                    
                    Element nodo1 = doc.createElement("Vida");
                    nodo1.appendChild(doc.createTextNode(arregloDatos[1]));
                    datos.appendChild(nodo1);
                    
                    Element nodo2 = doc.createElement("Velocidad");
                    nodo2.appendChild(doc.createTextNode(arregloDatos[2]));
                    datos.appendChild(nodo2);
                    
                    Element nodo3 = doc.createElement("ResF");
                    nodo3.appendChild(doc.createTextNode(arregloDatos[3]));
                    datos.appendChild(nodo3);
                    
                    Element nodo4 = doc.createElement("ResM");
                    nodo4.appendChild(doc.createTextNode(arregloDatos[4]));
                    datos.appendChild(nodo4);
                    
                    Element nodo5 = doc.createElement("ResA");
                    nodo5.appendChild(doc.createTextNode(arregloDatos[5]));
                    datos.appendChild(nodo5);
                    
                    lista.Borrar(0);    
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