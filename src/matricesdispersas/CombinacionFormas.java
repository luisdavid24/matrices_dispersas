/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricesdispersas;

import Tripletas.Tripleta;
import forma1.Lista;
import forma1.Nodo1;
import listaForma2.ListaF2;
import listaForma2.Nodo;

/**
 *
 * @author Anderson
 */
public class CombinacionFormas {

    public CombinacionFormas() {
    }
    
    
    public ListaF2 sumarFormas(Tripleta trip, Lista l1){
        ListaF2 lista2 = new ListaF2();
        ListaF2 resultado = new ListaF2();
        lista2 = lista2.crearListaTrip(trip);
        //lista2.mostrarLista();
        resultado.insertarFinal(trip.getFil(0), trip.getCol(0), 0);
        int[][] matriz = new int[trip.getFil(0)][ trip.getCol(0)];
        Nodo1 aux1 = l1.getPunta().getLiga();
        Nodo1 aux3;
        Nodo aux2 = lista2.getCabeza().getLigaFila();
        int res = 0;
        while(aux1 != l1.getPunta()){
            aux3 = aux1.getLf();
            while(aux3 != aux1){
                int fila, columna, dato;
                fila = aux3.getF();
                columna = aux3.getC();
                dato = aux3.getDato();
                int condi = 0;
                while(aux2 != lista2.getCabeza()){  
                    if(aux2.getFila() == fila && aux2.getColumna() == columna){
                        resultado.insertarFinal(fila, columna, dato + aux2.getDato());                        
                        condi = 1;
                    }
                    aux2 = aux2.getLigaFila();
                }
                aux2 = lista2.getCabeza().getLigaFila();
                aux3 = aux3.getLf();
                if(condi == 0){
                    resultado.insertarFinal(fila, columna, dato); 
                }
            }
            aux1 = aux1.getLiga();
        }
//        resultado.crearListaForm2(matriz);
        //resultado.mostrarLista();
        return resultado;
    }
    
    public Tripleta multiplicarFormas(Lista forma1, ListaF2 forma2){
        int indice = 0;
        ListaF2 listaResultado = new ListaF2();
        Nodo aux = forma2.getCabeza().getLigaFila();
        Nodo1 aux1 = forma1.getPunta().getLiga();
        Nodo1 aux2;
        listaResultado.insertarFinal(forma2.getCabeza().getFila(), forma1.getPunta().getC(), 0);
        int f = 0, dato = 0, c = 0, operaciones = 0;
        int[][] resultado = new int [forma2.getCabeza().getFila()][forma1.getPunta().getC()];
        
        while(f < forma2.getCabeza().getFila()){
            while(aux != forma2.getCabeza()){
                while(aux1 != forma1.getPunta()){
                    aux2 = aux1.getLf();
                    while(aux2 != aux1){
                        if(aux.getColumna() == f && aux2.getF()== f){
                            //listaResultado.insertPos(aux.getFila(), aux2.getC(), aux.getDato() * aux2.getDato());
                            operaciones = aux.getDato() * aux2.getDato();
                            operaciones += resultado[aux.getFila()][aux2.getC()];
                            resultado[aux.getFila()][aux2.getC()] = operaciones;
                        }
                        aux2 = aux2.getLf();
                    }
                    aux1= aux1.getLiga();
                }
                aux1 = forma1.getPunta().getLiga();
                aux = aux.getLigaFila();
            }
            f++;   
            aux = forma2.getCabeza().getLigaFila();
        }
        Tripleta resul = new Tripleta();
        resul.crearTrip(resultado);
        
        return resul;
    }
    
}
