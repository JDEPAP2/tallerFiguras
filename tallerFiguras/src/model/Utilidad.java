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
import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import static model.Tools.*;

/**
 *
 * @author PC
 */
public class Utilidad {
    public static boolean crearArchivoXML(LinkedList<Figura> figuras){
        boolean t = false;
        
        Document doc = new Document();
        doc.setRootElement(new Element("Figuras"));
        int i = 1;
        for (Figura obj: figuras) {
            Element e = new Element("figura");
            e.setAttribute("nombre", obj.getNombre()+"");
            e.setAttribute("nPuntos",obj.getnPuntos()+"");
            e.setAttribute("radio",obj.getRadio()+"");
            e.setAttribute("lineWidth",obj.getLineWidth()+"");
            e.setAttribute("fillColor",obj.getFillColor()+"");
            e.setAttribute("lineColor",obj.getLineColor()+"");
            for(Punto2D punto: obj.getPuntos()){
                e.addContent(new Element("punto").setAttribute("x", punto.getX() + "").setAttribute("y", punto.getY() + ""));
            }
            doc.getRootElement().addContent(e);
        }
        Element oMayor = new Element("numeroFiguras").setText("" + figuras.size());
        doc.getRootElement().addContent(oMayor);
        
        XMLOutputter xmlOutputter = new XMLOutputter();
        try{
            File fileN = saveFileChooser();
            FileOutputStream file = new FileOutputStream(fileN);
            xmlOutputter.setFormat(Format.getCompactFormat().getPrettyFormat());
            xmlOutputter.output(doc, file);
            
            t = true;
        }catch(IOException e){
            System.out.println("no se guardo");
        }
        
        return t;
    }
}
