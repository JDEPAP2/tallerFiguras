/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.paint.Color;

/**
 *
 * @author PC
 */
public class Figura {
    
    private String nombre;    
    private int nPuntos;    
    private double radio;    
    private double lineWidth;    
    private Punto2D[] puntos;
    private Color fillColor;
    private Color lineColor;

    public Figura() {
    }

    public Figura(String nombre, int nLados, double lineWidth, Punto2D[] puntos, Color lineColor) {
        this.nombre = nombre;
        this.nPuntos = nLados;
        this.lineWidth = lineWidth;
        this.puntos = puntos;
        this.lineColor = lineColor;
    }

    public Figura(String nombre, int nLados, double radio, double lineWidth, Punto2D[] puntos, Color fillColor, Color lineColor) {
        this.nombre = nombre;
        this.nPuntos = nLados;
        this.radio = radio;
        this.lineWidth = lineWidth;
        this.puntos = puntos;
        this.fillColor = fillColor;
        this.lineColor = lineColor;
    }
    
    
    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Punto2D[] getPuntos() {
        return puntos;
    }

    public void setPuntos(Punto2D[] puntos) {
        this.puntos = puntos;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public int getnPuntos() {
        return nPuntos;
    }

    public void setnPuntos(int nPuntos) {
        this.nPuntos = nPuntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
