/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import static model.Tools.*;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author PC
 */
public class Utilidad {

    public static boolean crearArchivoXML(LinkedList<Figura> figuras) {
        boolean t = false;

        Document doc = new Document();
        doc.setRootElement(new Element("Figuras"));
        int i = 1;
        for (Figura obj : figuras) {
            Element e = new Element("figura");
            e.setAttribute("nombre", obj.getNombre() + "");
            e.setAttribute("nPuntos", obj.getnPuntos() + "");
            e.setAttribute("radio", obj.getRadio() + "");
            e.setAttribute("lineWidth", obj.getLineWidth() + "");
            e.setAttribute("fillColor", obj.getFillColor() + "");
            e.setAttribute("lineColor", obj.getLineColor() + "");
            for (Punto2D punto : obj.getPuntos()) {
                e.addContent(new Element("punto").setAttribute("x", punto.getX() + "").setAttribute("y", punto.getY() + ""));
            }
            doc.getRootElement().addContent(e);
        }
        Element oMayor = new Element("numeroFiguras").setText("" + figuras.size());
        doc.getRootElement().addContent(oMayor);

        XMLOutputter xmlOutputter = new XMLOutputter();
        try {
            File fileN = saveFileChooser();
            FileOutputStream file = new FileOutputStream(fileN);
            xmlOutputter.setFormat(Format.getCompactFormat().getPrettyFormat());
            xmlOutputter.output(doc, file);

            t = true;
        } catch (IOException e) {
            System.out.println("no se guardo");
        }

        return t;
    }

    public static void leerArchivoXML(LinkedList<Figura> figuras) {
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("archivo.xml");
        try {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);

            //Se obtiene la raiz 'tables'
            Element rootNode = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'tables'
            List list = rootNode.getChildren("tabla");

            //Se recorre la lista de hijos de 'tables'
            for (int i = 0; i < list.size(); i++) {
                //Se obtiene el elemento 'tabla'
                Element tabla = (Element) list.get(i);

                //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
                String nombreTabla = tabla.getAttributeValue("nombre");

                System.out.println("Tabla: " + nombreTabla);

                //Se obtiene la lista de hijos del tag 'tabla'
                List lista_campos = tabla.getChildren();

                System.out.println("\tNombre\t\tTipo\t\tValor");

                //Se recorre la lista de campos
                for (int j = 0; j < lista_campos.size(); j++) {
                    //Se obtiene el elemento 'campo'
                    Element campo = (Element) lista_campos.get(j);

                    //Se obtienen los valores que estan entre los tags '<campo></campo>'
                    //Se obtiene el valor que esta entre los tags '<nombre></nombre>'
                    String nombre = campo.getChildTextTrim("nombre");

                    //Se obtiene el valor que esta entre los tags '<tipo></tipo>'
                    String tipo = campo.getChildTextTrim("tipo");

                    //Se obtiene el valor que esta entre los tags '<valor></valor>'
                    String valor = campo.getChildTextTrim("valor");

                    System.out.println("\t" + nombre + "\t\t" + tipo + "\t\t" + valor);
                }
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }
    
}
