/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import modelo.Punto2D;

/**
 *
 * @author Juan
 */
public class FXMLDocumentController implements Initializable {


    
    @FXML
    private Canvas lienzo;
    
    @FXML
    private TextField idRadio;
    
//    @FXML
//    private ColorPicker color;
    
    
    double coorX, coorY;
    
    GraphicsContext g;
    
    HashMap<Integer,Punto2D> mapPuntos;
    
    int contador;
        
    double[] arrCoorX;
    
    double[] arrCoorY;
    
    LinkedList poligono = new LinkedList<>();
    
    
    @FXML
    private void nuevaFigura(MouseEvent event){

//        //Figura Rectangulares. Arreglar numero de lados a conveniencia(n). 
//        coorX = event.getX();
//        coorY = event.getY();
//        int n = 3; 
//        int radioFigura = 20;
//         
//        arrCoorX = new double[n];
//        arrCoorY = new double[n];
//        
//        for (int a = 0; a < n; a++) {
//            arrCoorX[a] = coorX + (radioFigura*Math.cos(a*2*Math.PI / n)*2);
//            arrCoorY[a] = coorY - (radioFigura*Math.sin(a*2*Math.PI / n)*2);
//        }
//        g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);

//------------------------------------------------------------------------------

//        //Figura Estrellas. Arreglar numero de lados a conveniencia(nPuntas). Para una estrellas de 5 lados, nPuntas debe ser el doble. 
//        coorX = event.getX();
//        coorY = event.getY();
//        int nPuntas = 12;
//        int radioExt = 40;
//        int radioInt = radioExt/2;
//        double inclinacion = Math.PI;
//         
//        arrCoorX = new double[nPuntas];
//        arrCoorY = new double[nPuntas];
//      
//        double anguloEntreVertices = 2*Math.PI/nPuntas;
//        for (int a = 0; a < nPuntas; a++) {
//            double r = (a%2 == 0)?radioExt:radioInt;
//            double i = a*anguloEntreVertices + inclinacion;
//            arrCoorX[a] = r*Math.sin(i) + coorX;
//            arrCoorY[a] = r*Math.cos(i) + coorY;  
//            }
//            g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);

//------------------------------------------------------------------------------

//------------------------------------------------------------------------------

//------------------------------------------------------------------------------

//------------------------------------------------------------------------------

//------------------------------------------------------------------------------

      }

// Otras cualidades de la figura:    
//        g.fillPolygon(arrCoorX, arrCoorY, arrCoorX.length);
//        g.setFill(color.getValue());
//        g.setStroke(Color.BLACK);
//        g.setLineWidth(2);   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        mapPuntos = new HashMap<>();
        contador = 0;
        g = lienzo.getGraphicsContext2D();
        double h = lienzo.getHeight();
        double w = lienzo.getWidth();
        
        g.setStroke(Color.PINK);
        g.setLineWidth(7);
        g.strokeRect(0, 0, w, h);
    }      
}


