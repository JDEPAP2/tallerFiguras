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
import javafx.scene.shape.ArcType;
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

//        //Figura Circulo. Arreglar diametro a conveniencia(nPuntas).
//        coorX = event.getX();
//        coorY = event.getY();
//        int diametro = 50;
//        int radio = diametro/2;
//        
//        g.strokeOval(coorX, coorY, diametro, diametro); 

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

//        //Figura Flecha Vista Izquierda. Arreglar medida del tamaño del lado a conveniencia(lado). 
//        coorX = event.getX();
//        coorY = event.getY();
//        int lado = 80;
//         
//        arrCoorX = new double[8];
//        arrCoorY = new double[8];
//        
//        arrCoorX[0] = coorX;
//        arrCoorY[0] = coorY;
//        
//        arrCoorX[1] = coorX + lado*Math.cos(-1);
//        arrCoorY[1] = coorY + lado*Math.sin(1);
//        
//        arrCoorX[2] = coorX + lado*Math.cos(-1);
//        arrCoorY[2] = coorY + lado*Math.sin(0.5);
//        
//        arrCoorX[3] = coorX + (lado*4)*Math.cos(-1);
//        arrCoorY[3] = coorY + lado*Math.sin(0.5);
//        
//        arrCoorX[4] = coorX + (lado*4)*Math.cos(-1);
//        arrCoorY[4] = coorY + lado*Math.sin(-0.5);
//        
//        arrCoorX[5] = coorX + lado*Math.cos(-1);
//        arrCoorY[5] = coorY + lado*Math.sin(-0.5);
//        
//        arrCoorX[6] = coorX + lado*Math.cos(-1);
//        arrCoorY[6] = coorY + lado*Math.sin(-1);
//        
//        arrCoorX[7] = coorX;
//        arrCoorY[7] = coorY;
//                
//        g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);

//------------------------------------------------------------------------------

//        //Figura Flecha Vista Derecha. Arreglar medida del tamaño del lado a conveniencia(lado). 
//        coorX = event.getX();
//        coorY = event.getY();
//        int lado = 80;
//         
//        arrCoorX = new double[8];
//        arrCoorY = new double[8];
//        
//        arrCoorX[0] = coorX;
//        arrCoorY[0] = coorY;
//        
//        arrCoorX[1] = coorX - lado*Math.cos(-1);
//        arrCoorY[1] = coorY - lado*Math.sin(1);
//        
//        arrCoorX[2] = coorX - lado*Math.cos(-1);
//        arrCoorY[2] = coorY - lado*Math.sin(0.5);
//        
//        arrCoorX[3] = coorX - (lado*4)*Math.cos(-1);
//        arrCoorY[3] = coorY - lado*Math.sin(0.5);
//        
//        arrCoorX[4] = coorX - (lado*4)*Math.cos(-1);
//        arrCoorY[4] = coorY - lado*Math.sin(-0.5);
//        
//        arrCoorX[5] = coorX - lado*Math.cos(-1);
//        arrCoorY[5] = coorY - lado*Math.sin(-0.5);
//        
//        arrCoorX[6] = coorX - lado*Math.cos(-1);
//        arrCoorY[6] = coorY - lado*Math.sin(-1);
//        
//        arrCoorX[7] = coorX;
//        arrCoorY[7] = coorY;
//                
//        g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);

//------------------------------------------------------------------------------

//        //Figura Flecha Vista Abajo. Arreglar medida del tamaño del lado a conveniencia(lado). 
//        coorX = event.getX();
//        coorY = event.getY();
//        int lado = 80;
//         
//        arrCoorX = new double[8];
//        arrCoorY = new double[8];
//        
//        arrCoorX[0] = coorX;
//        arrCoorY[0] = coorY;
//        
//        arrCoorX[1] = coorX - lado*Math.sin(1);
//        arrCoorY[1] = coorY - lado*Math.cos(-1);
//        
//        arrCoorX[2] = coorX - lado*Math.sin(0.5);
//        arrCoorY[2] = coorY - lado*Math.cos(-1);
//        
//        arrCoorX[3] = coorX - lado*Math.sin(0.5);
//        arrCoorY[3] = coorY - (lado*4)*Math.cos(-1);
//        
//        arrCoorX[4] = coorX - lado*Math.sin(-0.5);
//        arrCoorY[4] = coorY - (lado*4)*Math.cos(-1);
//        
//        arrCoorX[5] = coorX - lado*Math.sin(-0.5);
//        arrCoorY[5] = coorY - lado*Math.cos(-1);
//        
//        arrCoorX[6] = coorX - lado*Math.sin(-1);
//        arrCoorY[6] = coorY - lado*Math.cos(-1);
//        
//        arrCoorX[7] = coorX;
//        arrCoorY[7] = coorY;
//                
//        g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);
//------------------------------------------------------------------------------

//        //Figura Flecha Vista Arriba. Arreglar medida del tamaño del lado a conveniencia(lado). 
//        coorX = event.getX();
//        coorY = event.getY();
//        int lado = 80;
//         
//        arrCoorX = new double[8];
//        arrCoorY = new double[8];
//        
//        arrCoorX[0] = coorX;
//        arrCoorY[0] = coorY;
//        
//        arrCoorX[1] = coorX + lado*Math.sin(1);
//        arrCoorY[1] = coorY + lado*Math.cos(-1);
//        
//        arrCoorX[2] = coorX + lado*Math.sin(0.5);
//        arrCoorY[2] = coorY + lado*Math.cos(-1);
//        
//        arrCoorX[3] = coorX + lado*Math.sin(0.5);
//        arrCoorY[3] = coorY + (lado*4)*Math.cos(-1);
//        
//        arrCoorX[4] = coorX + lado*Math.sin(-0.5);
//        arrCoorY[4] = coorY + (lado*4)*Math.cos(-1);
//        
//        arrCoorX[5] = coorX + lado*Math.sin(-0.5);
//        arrCoorY[5] = coorY + lado*Math.cos(-1);
//        
//        arrCoorX[6] = coorX + lado*Math.sin(-1);
//        arrCoorY[6] = coorY + lado*Math.cos(-1);
//        
//        arrCoorX[7] = coorX;
//        arrCoorY[7] = coorY;
//                                
//        g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);
//------------------------------------------------------------------------------

//        //Figura Trueno. Rayo. Sale desde la punta inferior derecha hacia arriba. Una hueva mrka. :)
//        coorX = event.getX();
//        coorY = event.getY();
//        int lado = 60;
//         
//        arrCoorX = new double[12];
//        arrCoorY = new double[12];
//        
//        arrCoorX[0] = coorX;
//        arrCoorY[0] = coorY;
//        
//        arrCoorX[1] = coorX - lado*Math.sin(-1);
//        arrCoorY[1] = coorY - (lado*2)*Math.cos(-0.5);
//        
//        arrCoorX[2] = coorX;
//        arrCoorY[2] = coorY - (lado*2)*Math.cos(-0.5);
//        
//        arrCoorX[3] = coorX - lado*Math.sin(-1);
//        arrCoorY[3] = coorY - 2*(lado*2)*Math.cos(-0.5);
//        
//        arrCoorX[4] = coorX;
//        arrCoorY[4] = coorY - 2*(lado*2)*Math.cos(-0.5);
//        
//        arrCoorX[5] = coorX - lado*Math.sin(-1);
//        arrCoorY[5] = coorY - 3*(lado*2)*Math.cos(-0.5);
//        
//        arrCoorX[6] = coorX - 0.5*(lado*2)*Math.sin(1.5);
//        arrCoorY[6] = coorY - 3*(lado*2)*Math.cos(-1.1);
//        
//        arrCoorX[7] = coorX - lado*Math.sin(0.3);
//        arrCoorY[7] = coorY - 2*(lado*2)*Math.cos(-0.8);
//        
//        arrCoorX[8] = coorX - 0.5*(lado*2)*Math.sin(1.5);
//        arrCoorY[8] = coorY - (lado*2)*Math.cos(-0.8) ;
//        
//        arrCoorX[9] = coorX - lado*Math.sin(0.3);
//        arrCoorY[9] = coorY - (lado*2)*Math.cos(-0.8);
//        
//        arrCoorX[10] = coorX - lado*Math.sin(2);
//        arrCoorY[10] = coorY;
//        
//        arrCoorX[11] = coorX;
//        arrCoorY[11] = coorY;
//                                
//        g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);
////        
//------------------------------------------------------------------------------

//        //Figura Trueno. Rayo. Sale desde la punta superior izquierda hacia abajo. Este si es. :)
//        coorX = event.getX();
//        coorY = event.getY();
//        int lado = 40;
//         
//        arrCoorX = new double[12];
//        arrCoorY = new double[12];
//        
//        arrCoorX[0] = coorX;
//        arrCoorY[0] = coorY;
//        
//        arrCoorX[1] = coorX + lado*Math.sin(2);
//        arrCoorY[1] = coorY;
//        
//        arrCoorX[2] = coorX + lado*Math.sin(0.3);
//        arrCoorY[2] = coorY + (lado*2)*Math.cos(-0.8);
//        
//        arrCoorX[3] = coorX + 0.5*(lado*2)*Math.sin(1.5);
//        arrCoorY[3] = coorY + (lado*2)*Math.cos(-0.8) ;
//        
//        arrCoorX[4] = coorX + lado*Math.sin(0.3);
//        arrCoorY[4] = coorY + 2*(lado*2)*Math.cos(-0.8);
//        
//        arrCoorX[5] = coorX + 0.5*(lado*2)*Math.sin(1.5);
//        arrCoorY[5] = coorY + 3*(lado*2)*Math.cos(-1.1);
//
//        arrCoorX[6] = coorX + lado*Math.sin(-1);
//        arrCoorY[6] = coorY + 3*(lado*2)*Math.cos(-0.5);
//                
//        arrCoorX[7] = coorX;
//        arrCoorY[7] = coorY + 2*(lado*2)*Math.cos(-0.5);
//
//        arrCoorX[8] = coorX + lado*Math.sin(-1);
//        arrCoorY[8] = coorY + 2*(lado*2)*Math.cos(-0.5);
//        
//        arrCoorX[9] = coorX;
//        arrCoorY[9] = coorY + (lado*2)*Math.cos(-0.5);
//        
//        arrCoorX[10] = coorX + lado*Math.sin(-1);
//        arrCoorY[10] = coorY + (lado*2)*Math.cos(-0.5);
//        
//        arrCoorX[11] = coorX;
//        arrCoorY[11] = coorY;
//                                
//        g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);
//------------------------------------------------------------------------------

        //Figura Redondeadas.
        coorX = event.getX();
        coorY = event.getY();
        int lado = 120;
        int angulo = lado;

        double[] arrCoorXa = new double[2];
        double[] arrCoorYa = new double[2];
        
        arrCoorXa[0] = coorX;
        arrCoorYa[0] = coorY;
        
        arrCoorXa[1] = coorX + 2*(lado*2)*Math.cos(1);
        arrCoorYa[1] = coorY;
        
        double[] arrCoorXb = new double[2];
        double[] arrCoorYb = new double[2];
        
        arrCoorXb[0] = coorX + 0.5*(lado*2)*Math.cos(1);
        arrCoorYb[0] = coorY + (lado*2)*Math.sin(1);
        
        arrCoorXb[1] = coorX + 2*(lado*2)*Math.cos(1);
        arrCoorYb[1] = coorY + (lado*2)*Math.sin(1);

        double[] arrCoorXba = new double[2];
        double[] arrCoorYba = new double[2];
        
        arrCoorXba[0] = coorX;
        arrCoorYba[0] = coorY + (lado*2)*Math.sin(1);
        
        arrCoorXba[1] = coorX;
        arrCoorYba[1] = coorY + (lado*2.5)*Math.sin(1);
        
        double[] arrCoorXbb = new double[2];
        double[] arrCoorYbb = new double[2];
        
        arrCoorXbb[0] = coorX;
        arrCoorYbb[0] = coorY + (lado*2.5)*Math.sin(1);
        
        arrCoorXbb[1] = coorX + 0.5*(lado*2)*Math.cos(1);
        arrCoorYbb[1] = coorY + (lado*2)*Math.sin(1);
        
        double[] arrCoorXc = new double[2];
        double[] arrCoorYc = new double[2];
        
        arrCoorXc[0] = coorX + (lado*-0.5);
        arrCoorYc[0] = coorY + (lado*0.5);
        
        arrCoorXc[1] = coorX + (lado*-0.5);
        arrCoorYc[1] = coorY + (lado*1.16);
        
        double[] arrCoorXd = new double[2];
        double[] arrCoorYd = new double[2];
        
        arrCoorXd[0] = coorX + (lado*2.6);
        arrCoorYd[0] = coorY + (lado*0.5);
        
        arrCoorXd[1] = coorX + (lado*2.6);
        arrCoorYd[1] = coorY + (lado*1.16);
        
        int angulosupader = (int) (coorX + (lado*1.6));
        int angulosupaizq = (int) (coorX + (lado*-0.5));
        
        int anguloinfbizqx = (int) (coorX + (lado*-0.5));
        int anguloinfbizqy = (int) (coorY + (lado*0.69));
        
        int anguloinfbderx = (int) (coorX + (lado*1.6));
        int anguloinfbdery = (int) (coorY + (lado*0.69));
        
        g.strokePolygon(arrCoorXa, arrCoorYa, arrCoorXa.length);
        g.strokePolygon(arrCoorXb, arrCoorYb, arrCoorXb.length);
        g.strokePolygon(arrCoorXba, arrCoorYba, arrCoorXba.length);
        g.strokePolygon(arrCoorXbb, arrCoorYbb, arrCoorXbb.length);
        g.strokePolygon(arrCoorXc, arrCoorYc, arrCoorXc.length);
        g.strokePolygon(arrCoorXd, arrCoorYd, arrCoorXd.length);
        
        g.strokeArc(angulosupaizq, arrCoorYa[0], angulo, angulo, 90, 90, ArcType.OPEN);
        g.strokeArc(anguloinfbizqx, anguloinfbizqy, angulo, angulo, 270, -90, ArcType.OPEN);
        g.strokeArc(angulosupader, arrCoorYa[0], angulo, angulo, 90, -90, ArcType.OPEN);
        g.strokeArc(anguloinfbderx, anguloinfbdery, angulo, angulo, 270, 90, ArcType.OPEN);
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


