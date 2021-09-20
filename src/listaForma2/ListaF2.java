/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaForma2;

import Tripletas.Tripleta;
import static javax.management.Query.and;
import javax.swing.JOptionPane;

/**
 *
 * @author Anderson
 */
public class ListaF2 {
    private Nodo cabeza;
    private Nodo ultimo;

    public ListaF2() {
        cabeza = null;
        ultimo = null;
    }

    public Nodo getCabeza() {
        return cabeza;
    }
    
    public Nodo getUltimo(){
        Nodo p = cabeza;
        while(p.getLigaFila() != cabeza){
            p = p.getLigaFila();
        }
        return p;
    }
    
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
    
    public void insertarFinal(int f, int c, int d){
        Nodo nuevo = new Nodo(f,c,d);
       
        if(cabeza == null){
            cabeza = nuevo;
            cabeza.setLigaFila(cabeza);
        }else{
            Nodo aux = cabeza;
            while(aux.getLigaFila() != cabeza){
                aux = aux.getLigaFila();
            }
            aux.setLigaFila(nuevo);
            nuevo.setLigaFila(cabeza);
        }
        
    }
   
    public void ligarColumnas(){
        Nodo p, ant;
        int c = 0;
        
        ant = cabeza;
        p = cabeza.getLigaFila();
        
        while(c < cabeza.getColumna()){
            while(p != cabeza){
                if(p.getColumna() == c){
                    ant.setLigaColumna(p);
                    ant = p;
                    p = p.getLigaFila();
                    //System.out.println("Ligado pai");
                }else{
                    p = p.getLigaFila();
                }
            }
            c++;  
            p = p.getLigaFila();
            //System.out.println(c);
            if(c == this.getCabeza().getColumna()){
                ant.setLigaColumna(cabeza);
                //System.out.println("Circulado pa");
            }
                 
        }
    }
    
    public Nodo buscarReferencia(int fila, int columna){
        Nodo p = cabeza.getLigaFila();
        Nodo aux;
//         while(p != cabeza){
//                
//            p = p.getLigaFila();
//         }
        while(p.getFila() != fila && p.getColumna() < columna){
           p = p.getLigaFila();
        }
        if(p.getFila() != fila && p.getColumna() < columna){
            aux = p;
            return aux;
        }else{
            return null;
        }
    }
    public void insertPos(int fila, int columna, int dato){
        Nodo aux = cabeza.getLigaFila();
        Nodo aux1 = aux.getLigaFila();
        Nodo nuevo = new Nodo(fila, columna, dato);
        boolean inicio = false, medio = false  , fin = false, suma = false;
        
        
        while(aux != cabeza){
            if(aux.getFila() == fila && aux.getColumna() == columna){
                aux.setDato(aux.getDato() + dato);
                suma = true;
            }
            aux = aux.getLigaFila();
        }
        
        if(suma == false && medio == false && fin == false){
            aux = cabeza;
            if(nuevo.getFila() < aux.getFila() && nuevo.getFila()<= aux1.getFila() && aux1.getColumna() >= nuevo.getColumna()){
            aux.setLigaFila(nuevo);
            nuevo.setLigaFila(aux1);
            //System.out.println("Insertado al inicio");
            inicio = true;
            }else if(nuevo.getFila() < aux.getFila() && nuevo.getFila()<= aux1.getFila() && aux1.getColumna() <= nuevo.getColumna()){
                aux = aux.getLigaFila();
                aux1 = aux.getLigaFila();
                aux.setLigaFila(nuevo);
                nuevo.setLigaFila(aux1);
                inicio = true;
                //System.out.println("Insertado casi al inicio");
            }
        }
        
        if(inicio == false && fin == false && suma == false){
            aux = cabeza.getLigaFila();
            //System.out.println("Medio");
            if(fila <= this.getUltimo().getFila()){
                while(aux.getFila() != fila){
                    aux1 = aux;
                    aux = aux.getLigaFila();
                }
            //System.out.println("aux:" + aux.getFila() + " " + aux.getColumna() + " " + aux.getDato());

            //System.out.println("aux1:" + aux1.getFila() + " " + aux1.getColumna() + " " + aux1.getDato());
                if(nuevo.getColumna() < aux.getColumna()){
                    aux1.setLigaFila(nuevo);
                    nuevo.setLigaFila(aux);
                    medio = true;
                }else if(nuevo.getColumna() > aux.getColumna()){
                    aux1 = aux.getLigaFila();
                    aux.setLigaFila(nuevo);
                    nuevo.setLigaFila(aux1);
                    medio = true;
                }
                else{
                    aux1 = aux.getLigaFila();
                    aux.setLigaFila(nuevo);
                    nuevo.setLigaFila(aux1);
                    medio = true;
                }
            }else{
                medio = false;
            }
        }
        
        if(inicio == false && medio == false && suma == false){
            aux = cabeza.getLigaFila();
            //System.out.println("Aqui toy");
            this.insertarFinal(fila, columna, dato);
            fin = true;
        }
    }
    
    public void sumarTerminos(){
       Nodo aux = cabeza.getLigaFila();
       Nodo aux1 = aux.getLigaFila();
       
       while(aux != cabeza){
           while(aux1 != cabeza){
               if(aux.getFila() == aux1.getFila() && aux.getColumna() == aux1.getColumna()){
                  aux.setDato(aux.getDato() + aux1.getDato());
                  aux.setLigaFila(aux1.getLigaFila());
               }
               aux1 = aux1.getLigaFila();
           }
           aux = aux.getLigaFila();
           aux1 = aux.getLigaFila();
       }
    }
    
    public void insertarPos(int fila, int columna, int dato){
        Nodo nuevo = new Nodo(fila, columna, dato);
        Nodo p = cabeza.getLigaFila();
        Nodo aux;
        boolean condicion = false;
        System.out.println(fila + " " + columna);
        if (fila < cabeza.getFila() && columna < cabeza.getFila()) {
            aux = this.buscarReferencia(fila, columna);
            if(aux != null){
                p = aux;
            }else{
                while(p.getFila() != fila && p.getColumna() != columna){
                    p = p.getLigaFila();
                }
            }
            System.out.println("Nuevo: " + nuevo.getFila() + " " + nuevo.getColumna());
            
                if(cabeza == null){
                    p.setLigaFila(nuevo);
                    nuevo.setLigaFila(cabeza);
                    System.out.println("Insertado al inicio");
                }else{
                    while(p != cabeza){
                        if(p.getFila() == fila && p.getColumna() == columna){
                            p.setDato(p.getDato() + dato);
                            System.out.println("Ya hay un dato en esta posición, lo vamos a sumar");
                            condicion = true;
                        }
                        p = p.getLigaFila();
                    }
                    if(condicion == false){
                        p = cabeza;
                        while(p.getLigaFila() != cabeza){
                            Nodo sgte = p.getLigaFila();
                            if(sgte.getFila() >= nuevo.getFila() && p.getFila() < nuevo.getFila()){
                                p.setLigaFila(nuevo);
                                nuevo.setLigaFila(sgte);
                                System.out.println("Insertado pa'");
                                p = p.getLigaFila();
                                break;
                            }else{
                                sgte = p;
                                p = p.getLigaFila();
                            }

                            if(p.getLigaFila() == cabeza){
                                this.insertarFinal(fila, columna, dato);
                                p = p.getLigaFila();
                            }
                        }
                    }       
                } 
        }else{
            System.out.println("La fila y/o columna que inserto no pertenece a la dimension de la matiz: " + cabeza.getFila() + " " + cabeza.getColumna());
        }
      this.ligarColumnas();
    }
    
    public void mostrarLista(){
        Nodo aux = cabeza;
        Nodo ant = null;
        
        while(ant == null || ant.getLigaFila()!= cabeza){
            System.out.print("["+ aux.getFila() + "|" + aux.getColumna() + "|" + aux.getDato() + "]" + "->");
            ant = aux;
            aux = aux.getLigaFila();
        }  
    }
    
    public String mostrarv2(){
        Nodo aux = cabeza;
        Nodo ant = null;
        
        String resultado = "";
        while(ant == null || ant.getLigaFila()!= cabeza){
            resultado += "["+ aux.getFila() + "|" + aux.getColumna() + "|" + aux.getDato() + "]" + "->";
            ant = aux;
            aux = aux.getLigaFila();
        } 
        
        return resultado;
    }
    
    public String mostrarColumnasV2(){
        Nodo aux = cabeza;
        Nodo ant = null;
        String resultado = "";
        while(ant == null || ant.getLigaColumna()!= cabeza){
            resultado +=("|"+ aux.getFila() + "|" + aux.getColumna() + "|" + aux.getDato() + "|" + "->");
            ant = aux;
           aux = aux.getLigaColumna();
        } 
        return resultado;
    }
    
    public void mostrarPorColumnas(){
        Nodo aux = cabeza;
        Nodo ant = null;
        
        while(ant == null || ant.getLigaColumna()!= cabeza){
            System.out.print("|"+ aux.getFila() + "|" + aux.getColumna() + "|" + aux.getDato() + "|" + "->");
            ant = aux;
           aux = aux.getLigaColumna();
        }  
    }
    
    public void eliminar(int dato){
        Nodo p = cabeza;
        Nodo aux = cabeza;
        
        while(p.getLigaFila() != cabeza){
            if(p.getLigaFila().getDato() == dato){
                aux = p;
                p = p.getLigaFila().getLigaFila();
                aux.setLigaFila(p);
                System.out.println("Eliminado pa");
            }else{
                p = p.getLigaFila();
            }
        }
    }
      
    public ListaF2 sumar(ListaF2 lista2){
        
        ListaF2 resultado = lista2;
        
        Nodo p = this.getCabeza().getLigaFila();
        while( p != this.getCabeza()){
            resultado.insertarPos(p.getFila(), p.getColumna(), p.getDato());
            p = p.getLigaFila();
        }
        return resultado;
    }
    
    public ListaF2 crearListaTrip(Tripleta trip){
        
        int fila = trip.getFil(0);
        int f = 0;
        
        ListaF2 resultado = new ListaF2();
        resultado.insertarFinal(trip.getFil(0), trip.getCol(0), 0);

        while(f < fila){
            for (int i = 0; i < trip.getDato(0)+1; i++) {
                if(trip.getFil(i) == f){
                   resultado.insertarFinal(trip.getFil(i), trip.getCol(i), trip.getDato(i));
               }
            }
            f++;
        }
        return resultado;
    }
    
    public ListaF2 crearListaForm2(int [][] matriz){
        int columnas = 0, cont = 0;
        
       
        columnas = matriz[0].length;
        
        ListaF2 lista1 = new ListaF2();
      
        lista1.insertarFinal(matriz.length, columnas, 0);
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < columnas; j++) {
                if(matriz[i][j] != 0){
                    lista1.insertarFinal(i, j, matriz[i][j]);
                }
            }
        }
        return lista1;
    }
    
    public ListaF2 multiplicar(ListaF2 lista2){
        ListaF2 listaFilas = new ListaF2();
        ListaF2 listaColumnas = new ListaF2();
        ListaF2 listaResultado = new ListaF2();
        listaResultado.insertarFinal(this.getCabeza().getFila(), lista2.getCabeza().getColumna(), 0);
        Nodo aux = this.getCabeza().getLigaFila();
        Nodo aux1 = lista2.getCabeza().getLigaFila();
        int indice = 0;

        while(indice <= this.getCabeza().getFila()){
            while(aux != this.getCabeza()){
                while(aux1 != lista2.getCabeza()){
                    if(aux.getColumna() == indice && aux1.getFila() == indice){
                        listaResultado.insertarFinal(aux.getFila(), aux1.getColumna(), aux.getDato() * aux1.getDato());
                    }
                    aux1 = aux1.getLigaFila();
                }
                aux1 = lista2.getCabeza().getLigaFila();
                aux = aux.getLigaFila();
            }
            indice++;
            aux = this.getCabeza().getLigaFila();
        }
        return listaResultado;
    }
    
   
}
