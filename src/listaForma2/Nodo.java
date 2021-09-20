/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaForma2;

/**
 *
 * @author Anderson
 */
public class Nodo {
    private Nodo ligaFila;
    private Nodo ligaColumna;
    private int fila;
    private int columna; 
    private int dato;

    public Nodo(int fila, int columna, int dato) {
        this.ligaFila = null;
        this.ligaColumna = null;
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
    }

    public Nodo getLigaFila() {
        return ligaFila;
    }

    public void setLigaFila(Nodo ligaFila) {
        this.ligaFila = ligaFila;
    }

    public Nodo getLigaColumna() {
        return ligaColumna;
    }

    public void setLigaColumna(Nodo ligaColumna) {
        this.ligaColumna = ligaColumna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
    
    
}
