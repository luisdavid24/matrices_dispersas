package matricesdispersas;

import listaForma2.ListaF2;
import Tripletas.Tripleta;
import forma1.Forma1;
import forma1.Lista;
import forma1.Nodo1;
import javax.swing.JOptionPane;
import listaForma2.Nodo;

/**
 *
 * @author Anderson
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu ventanaMenu = new Menu();
        ventanaMenu.setBounds(0, 0, 600, 370);
        ventanaMenu.setVisible(true);
        ventanaMenu.setResizable(false);
        ventanaMenu.setLocationRelativeTo(null);

        
    /* Para sumar */
        
        //System.out.println("Mostra col");
        //suma.mostrarPorColumnas(); 
        
        
//        Forma1 forma1=new Forma1();
//        ListaF2 lista2 = new ListaF2();
//        Lista l1;
//        
//        Tripleta trip = new Tripleta();
//        trip.crearTrip(matriz2);
//        l1 = forma1.crearForma1(matriz3);
////        lista2 = lista2.crearListaTrip(trip);
////        lista2.mostrarLista();
//        ListaF2 resul = sumarFormas(trip, l1);
//        resul.mostrarLista();
        
//        Forma1 forma1=new Forma1();
//        ListaF2 lista2 = new ListaF2();
//        Lista l1;
//        l1 = forma1.crearForma1(matriz3);
//        lista2 = lista2.crearListaForm2(matriz2);
//        Tripleta resultado = new Tripleta();
//        resultado = multiplicarFormas(l1, lista2);
    }
   
    public static ListaF2 sumarFormas(Tripleta trip, Lista l1){
        ListaF2 lista2 = new ListaF2();
        ListaF2 resultado = new ListaF2();
        lista2 = lista2.crearListaTrip(trip);
        lista2.mostrarLista();
         ListaF2 nose = new ListaF2();
        resultado.insertarFinal(trip.getFil(0), trip.getCol(0), 0);
        
        Nodo1 aux1 = l1.getPunta().getLiga();
        Nodo1 aux3;
        Nodo aux2 = lista2.getCabeza().getLigaFila();
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
                System.out.println("Salio" + " " +condi);
                aux2 = lista2.getCabeza().getLigaFila();
                aux3 = aux3.getLf();
                if(condi == 0){
                    System.out.println("Hola");
                    resultado.insertPos(fila, columna, dato);
                }
            }
            aux1 = aux1.getLiga();
        }   
        return resultado;
    }
    
    public static Tripleta multiplicarFormas(Lista forma1, ListaF2 forma2){
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
        resul.mostrar();
        
        
        
        return null;
    }
    
    public static int buscar(Lista forma1, int fila, int c){
        Nodo1 aux = forma1.getPunta().getLiga();
        Nodo1 aux2;
        while(aux != forma1.getPunta()){
            if(aux.getF() == fila){
                aux2 = aux.getLf();
                while(aux2 != aux){
                    System.out.println(aux2.getF() + " " + aux2.getC() + " " + aux2.getDato() + " c: " + c);
                    if(aux2.getF()== fila){
                        return aux2.getDato();
                    }
                    aux2 = aux2.getLf();
                }
            }
            aux = aux.getLiga();
        }
        return 0;
    } 
}
