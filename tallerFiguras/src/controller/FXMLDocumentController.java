/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import com.sun.javafx.geom.Rectangle;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import static model.Tools.*;

/**
 *
 * @author Juan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label sText;
    @FXML
    private Canvas canvaId , canvaId1, canvaL;
    @FXML
    private ColorPicker colorTF, colorTL;
    @FXML
    private Slider slider;
    @FXML
    private MenuBar menu;
    private GraphicsContext g,g2,g3;
    private boolean estado;
    private double x,y;
    private char figura;
    DecimalFormat f;
    
    
    @FXML
    private void tipoFigura(ActionEvent event) {
        Button a = (Button) event.getTarget();
        figura = a.getId().charAt(0); 
    }
    @FXML
    private void guardarXML(ActionEvent event) throws FileNotFoundException {
        saveFileChooser("a");
    }
    @FXML
    private void recuperarXML(ActionEvent event) {
        openFileChooser();
    }
    @FXML
    private void borrarLienzo(ActionEvent event) {
        g.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
        g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
    }
    @FXML
    private void color(ActionEvent event) {
        Color colorF = colorTF.getValue();
        Color colorL = colorTL.getValue();
        g.setStroke(colorL);
        g2.setStroke(colorL);
        g.setFill(colorF);
        g2.setFill(colorF);        
    }
    @FXML
    private void grosor(MouseEvent event) {
        g3.clearRect(0, 0, canvaL.getWidth(), canvaL.getHeight());
        double valor = slider.getValue();
        g.setLineWidth(valor);
        g2.setLineWidth(valor);
        g3.setLineWidth(valor/2);
        sText.setText(f.format(valor));
        g3.strokeLine(0, canvaL.getHeight()/2, canvaL.getWidth(), canvaL.getHeight()/2);       
    }
    @FXML    
    private void printear(MouseEvent event) {
        if(!estado){
            x = event.getX();
            y = event.getY();
            estado = true;
            return;
        }
        switch(figura){
            case 'A':
                break;
            case 'B':
                break;
            case 'C':
                crearElipse(event);
                break;
            case 'D':
                crearCuadrado(event);
                break;
            case 'E':
                break;
            case 'F':
                break;
            case 'G':
                crearPoligono(event,3);
            case 'H':
                break;
            case 'I':
                crearPoligono(event,4);
                break;
            case 'J':
                crearPoligono(event,5);
                break;
            case 'K':
                crearPoligono(event,6);
                break;
            case 'L':
                break;
            case 'M':
                break;
            case 'N':
                break;
            case 'O':
                break;
            case 'P':
                crearEstrella(event,8);
                break;
            case 'Q':
                crearEstrella(event,10);
                break;
            case 'R':
                crearEstrella(event,12);
                break;
            case 'S':
                break;
            case 'T':
                break;
            case 'U':
                break;
            case 'V':
                break;
            case 'W':
                break;            
        }

    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        f = new DecimalFormat("#.0");
        estado = false;
        g = canvaId.getGraphicsContext2D();
        g2 = canvaId1.getGraphicsContext2D();
        g3 = canvaL.getGraphicsContext2D();
        g3.setStroke(Color.GRAY);
        colorTF.setValue(Color.BLACK);
        colorTL.setValue(Color.BLACK);
        slider.setValue(1.0);
        g3.strokeLine(0, canvaL.getHeight()/2, canvaL.getWidth(), canvaL.getHeight()/2);   
    }
    
    public void crearElipse(MouseEvent event){
        if(event.isShiftDown()){       
            g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
            g2.strokeOval(x, y, event.getX()-x, event.getY()-y);
            g2.fillOval(x, y, event.getX()-x, event.getY()-y);
            if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
                g.strokeOval(x, y, event.getX()-x, event.getY()-y);
                g.fillOval(x, y, event.getX()-x, event.getY()-y);
                estado = false;
            } 
        }else{           
            double dR = Math.sqrt(Math.pow(event.getX(), 2)+Math.pow(event.getY(), 2)) - Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
            g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
            g2.strokeOval(x, y, dR, dR);
            g2.fillOval(x, y, dR, dR);
            if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
                g.strokeOval(x, y, dR, dR);
                g.fillOval(x, y, dR, dR);
                estado = false;
            } 
        }  
    }
    
    public void crearCuadrado(MouseEvent event){
        if(event.isShiftDown()){       
            double[] pX = {x,x,event.getX(),event.getX()};
            double[] pY = {y,event.getY(),event.getY(),y};
            g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
            g2.strokePolygon(pX, pY, 4);
            g2.fillPolygon(pX, pY, 4);
            if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
            g.strokePolygon(pX, pY, 4);
            g.fillPolygon(pX, pY, 4);
            estado = false;
            } 
        }else{           
            double dX = event.getX()-x;
            double[] pX = {x,x,x+dX,x+dX};
            double[] pY = {y,y+dX,y+dX,y};
            g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
            g2.strokePolygon(pX, pY, 4);
            g2.fillPolygon(pX, pY, 4);
            if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
            g.strokePolygon(pX, pY, 4);
            g.fillPolygon(pX, pY, 4);
            estado = false;
            }
        }    
    }
    
    public void crearPoligono(MouseEvent event, int n){
        double coorX = event.getX();
        double coorY = event.getY();
        
        double radioFigura = Math.sqrt(Math.pow(coorX, 2)+Math.pow(coorY, 2)) - Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        
        double[] arrCoorX = new double[n];
        double[] arrCoorY = new double[n];
        
        
        for (int a = 0; a < n; a++) {
            arrCoorX[a] = x + (radioFigura * Math.cos(a * 2 * Math.PI / n)*2);
            arrCoorY[a] = y - (radioFigura * Math.sin(a * 2 * Math.PI / n)*2);
        }
        g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
        g2.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);
        g2.fillPolygon(arrCoorX, arrCoorY, arrCoorX.length);
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
            g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);
            g.fillPolygon(arrCoorX, arrCoorY, arrCoorX.length);
            estado = false;        
        }
    }
    
    public void crearEstrella(MouseEvent event, int nPuntas){
        double coorX = event.getX();
        double coorY = event.getY();
        double radioExt = Math.sqrt(Math.pow(coorX, 2)+Math.pow(coorY, 2)) - Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        double radioInt = radioExt/2;
        double inclinacion = Math.PI;
         
        double[] arrCoorX = new double[nPuntas];
        double[] arrCoorY = new double[nPuntas];
      
        double anguloEntreVertices = 2*Math.PI/nPuntas;
        for (int a = 0; a < nPuntas; a++) {
            double r = (a%2 == 0)?radioExt:radioInt;
            double i = a*anguloEntreVertices + inclinacion;
            arrCoorX[a] = r*Math.sin(i) + x;
            arrCoorY[a] = r*Math.cos(i) + y;  
        }
        g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());    
        g2.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);
        g2.fillPolygon(arrCoorX, arrCoorY, arrCoorX.length);
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
            g.strokePolygon(arrCoorX, arrCoorY, arrCoorX.length);
            g.fillPolygon(arrCoorX, arrCoorY, arrCoorX.length);
            estado = false;        
        }
        
    }
    
    
    
}


