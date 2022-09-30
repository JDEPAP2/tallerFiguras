/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import model.Figura;
import model.Punto2D;
import static model.Utilidad.*;


/**
 *
 * @author Juan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Text  t1,t2,t3,t4,t5;
    @FXML
    private Label sText, coor, alert;
    @FXML
    private Canvas canvaId , canvaId1, canvaL;
    @FXML
    private ColorPicker colorTF, colorTL;
    @FXML
    private Slider slider;
    @FXML
    private MenuBar menu;
    @FXML
    private CheckBox check;
    private GraphicsContext g,g2,g3;
    private boolean estado;
    private double x,y;
    private char figura;
    private double grosor;
    private Color colorF;
    private Color colorL;
    private LinkedList<Figura> figuras;
    private LinkedList<Punto2D> curva;
    DecimalFormat f;
    
    @FXML
    private void checkB(ActionEvent event){
        if(check.isSelected()){
            g.setFill(Color.TRANSPARENT);
            g2.setFill(Color.TRANSPARENT);
            colorTF.setDisable(true);
            t5.setDisable(true);
        }else{
            colorTF.setDisable(false);
        }      
    }
    @FXML
    private void alerta(ActionEvent event){
        alert.setText("Si desea borrar el lienzo presion 'Edit' y despues 'Borrar Lienzo'");
    }   
    @FXML
    private void mostrarCoor(MouseEvent event) {
        Punto2D e = new Punto2D(event.getX(),event.getY());
        coor.setText(e.toString());
    }
    @FXML
    private void tipoFigura(ActionEvent event) {
        Button a = (Button) event.getTarget();
        figura = a.getId().charAt(0);
        alert.setText("Para crear una figura arrastre el mouse");
        if(figura == 'B'){
            curva.clear();
        }
    }
    @FXML
    private void guardarXML(ActionEvent event) throws FileNotFoundException {
        if (crearArchivoXML(figuras)){
            alert.setText("Las figuras se guardaron exitosamente");
        }
    }
    @FXML
    private void recuperarXML(ActionEvent event) {
    }
    @FXML
    private void borrarLienzo(ActionEvent event) {
        g.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
        g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
    }
    @FXML
    private void color(ActionEvent event) {
        colorF = colorTF.getValue();
        colorL = colorTL.getValue();
        g.setStroke(colorL);
        g2.setStroke(colorL);
        g.setFill(colorF);
        g2.setFill(colorF);        
    }
    @FXML
    private void grosor(MouseEvent event) {
        g3.clearRect(0, 0, canvaL.getWidth(), canvaL.getHeight());
        grosor = slider.getValue();
        g.setLineWidth(grosor);
        g2.setLineWidth(grosor);
        g3.setLineWidth(grosor/2);
        sText.setText(f.format(grosor));
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
                crearLinea(event);
                alert.setText("Para realizar lineas precisas presione [SHIFT] mientras arrastra");
                break;
            case 'B':
                crearCurva(event);
                break;
            case 'C':
                crearElipse(event);
                alert.setText("Para crear ovalos presione [SHIFT] mientras arrastra");
                break;
            case 'D':
                crearCuadrado(event);
                alert.setText("Para crear rectangulos presione [SHIFT] mientras arrastra");
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
            case 'X':
                break;  
        }

    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        curva = new LinkedList<>();
        figuras = new LinkedList<>();
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
                Punto2D[] puntos = new Punto2D[pX.length];
                for (int i = 0; i < puntos.length; i++) {
                    puntos[i] = new Punto2D(pX[i],pY[i]);
                }
                Figura obj = new Figura("Cuadrado",pX.length,0,grosor,puntos,colorF,colorL);
                figuras.add(obj);
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
                Punto2D[] puntos = new Punto2D[pX.length];
                for (int i = 0; i < puntos.length; i++) {
                    puntos[i] = new Punto2D(pX[i],pY[i]);
                }
                Figura obj = new Figura("Cuadrado",pX.length,0,grosor,puntos,colorF,colorL);
                figuras.add(obj);
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
            Punto2D[] puntos = new Punto2D[arrCoorX.length];
            for (int i = 0; i < puntos.length; i++) {
                puntos[i] = new Punto2D(arrCoorX[i],arrCoorY[i]);
            }
            Figura obj = new Figura("Poligono",n,radioFigura,grosor,puntos,colorF,colorL);
            figuras.add(obj);
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
            Punto2D[] puntos = new Punto2D[arrCoorX.length];
            for (int i = 0; i < puntos.length; i++) {
                puntos[i] = new Punto2D(arrCoorX[i],arrCoorY[i]);
            }
            Figura obj = new Figura("Estrella",nPuntas,radioExt,grosor,puntos,colorF,colorL);
            figuras.add(obj);
            estado = false;
            
        }
        
    }
    public void crearLinea(MouseEvent event){
        double pX = event.getX();
        double pY = event.getY();
        
        if(event.isShiftDown()){
            double dx = pX - x;
            double dy = pY - y;
            double h = Math.sqrt(2)* pX;
            double dp = dx-dy;
            if(dp < -20){
                g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
                g2.strokeLine(x, y, x, pY);
                if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
                    g.strokeLine(x, y, x, pY);   
                    Punto2D[] puntos = {new Punto2D(x,y), new Punto2D(x,pY)};
                    Figura obj = new Figura("Linea",2,grosor,puntos,colorL);
                    figuras.add(obj);
                    estado = false;       
                  }}
            else{
                if(dp > 20){
                    g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
                    g2.strokeLine(x, y, pX, y);
                    if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
                        g.strokeLine(x, y, pX, y);
                        Punto2D[] puntos = {new Punto2D(x,y), new Punto2D(pX,y)};
                        Figura obj = new Figura("Linea",2,grosor,puntos,colorL);
                        figuras.add(obj);
                        estado = false;       
                    }
                }else{
                    g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
                    g2.strokeLine(x, y, h-y, h-x);
                    if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
                        g.strokeLine(x, y, h - y, h - x);
                        Punto2D[] puntos = {new Punto2D(x,y), new Punto2D(h-y,h-x)};
                        Figura obj = new Figura("Linea",2,grosor,puntos,colorL);
                        figuras.add(obj);
                        estado = false;       
                    }
                }}
        }else{
            g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
            g2.strokeLine(x, y, pX, pY);
            if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
                    g.strokeLine(x, y, pX, pY);
                    Punto2D[] puntos = {new Punto2D(x,y), new Punto2D(pX,pY)};
                    Figura obj = new Figura("Linea",2,grosor,puntos,colorL);
                    figuras.add(obj);                    
                    estado = false;       
            }
        }
        
    }
    
    public void crearCurva(MouseEvent event){  
//        if(!curva.isEmpty()){
//            Punto2D ob = new Punto2D(x, y);  
//            curva.add(ob);
//        }
//        int len = curva.size();
//        double[] pX = new double[len+1];
//        double[] pY = new double[len+1];
//        
//        for (int i = 0; i < len ; i++) {
//                pX[i] = curva.get(i).getX();
//                pY[i] = curva.get(i).getY();
//            }
//        pX[len] = event.getX();
//        pY[len] = event.getY();
//        if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
//            Punto2D ob1 = new Punto2D(pX[len], pY[len]);
//            curva.add(ob1);            
//        }
//        g2.clearRect(0, 0, canvaId.getWidth(), canvaId.getHeight());
//        g2.strokeArc(x, y, event.getX()-x, event.getY()-y, 0, 10, ArcType.OPEN);
//        if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
//            g.strokeArc(x, y, event.getX()-x, event.getY()-y, 0, 10, ArcType.OPEN);
//        }
    }
}


