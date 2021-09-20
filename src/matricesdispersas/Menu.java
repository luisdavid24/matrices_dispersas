package matricesdispersas;

import Tripletas.Tripleta;
import forma1.Forma1;
import forma1.Lista;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import listaForma2.ListaF2;
import static matricesdispersas.Inicio.multiplicarFormas;
import static matricesdispersas.Inicio.sumarFormas;

/**
 *
 * @author Anderson
 */
public class Menu extends JFrame implements ActionListener {
    
    private JLabel label1, label2, label3, label4,fila, columna, dato;
    private JTextField txtfila, txtcolumna, txtdato;
    private JScrollPane scrollpane1;
    private JTextArea texto1;
    private JMenuBar menuBar;
    private JMenu tripletas, listaf1, listaf2, otras;
    private JMenuItem crear, insertar, sumar, multiplicar, eliminar, crearf1, crearf2, insertarf1, insertarf2,
            eliminarf1, eliminarf2, sumarf1, sumarf2, multiplicarf1, multiplicarf2, tripf1, f2f1, creadores;
    private Tripleta trip = new Tripleta();
    private ListaF2 listaForma2 = new ListaF2();
    private Lista listaForma1 = new Lista();
    private Forma1 forma1 = new Forma1();
    
    public Menu(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Proyecto Matrices Dispersas");
        getContentPane().setBackground(new Color(223, 200, 33));
        this.setIconImage(new ImageIcon(getClass().getResource("/images/poli-icon.png")).getImage());
        
        label1 = new JLabel("PROYECTO MATRICES DISPERSAS");
        label1.setBounds(15, 5, 250, 30);
	label1.setFont(new Font("Andale Mono", 1, 14));
	label1.setForeground(new Color(0,0,0));
	add(label1);
		
	texto1 = new JTextArea();
	texto1.setEditable(false);
	texto1.setFont(new Font("Andale Mono", 1 ,10));
	texto1.setText("\nBUENAS PROFE, LE PRESENTAMOS EL PROYECTO \nDE MATRICES DISPERSAS,"
            + " FUE BASTANTE ALGO BASTANTE DIFICIL,\nESPERAMOS SACAR UNA BUENA NOTA PARA SUBIR ANIMOS \n"
            + "COMO NO PODEMOS DEFENDER EL PROYECTO LE QUEREMOS\nCOMENTAR ALGUNOS 'BUGS' QUE NOS OCURRIERON DURANTE EL \n"
            + "DESARROLLO: EN ALGUNAS OPERACIONES CON LAS LISTAS SE\nOBTENIAN LOS RESULTADOS CORRECTOS PERO AL MOMENTO DE\nMOSTRAR "
            + "LA LISTA EN ALGUNAS OCASIONES NO SE MOSTRABA DE\nMANERA ORDENADA, NUNCA SUPIMOS EL PORQUÉ Y ESTO NO PASA CON\nTODAS LAS MATRICES"
            + ".\nDICHO ESTO: "
            +"\nEN ESTA PANTALLA SE MOSTRARAN DIFERENTES RESULTADOS DE LAS\nOPERACIONES CON LAS MATRICES DISPERSAS");
	scrollpane1 = new JScrollPane(texto1);
	scrollpane1.setBounds(10,30,380,270);
	add(scrollpane1);
                
        ImageIcon imagen = new ImageIcon(getClass().getResource("/images/poli.png"));
	label2 = new JLabel(imagen);
	label2.setBounds(325, 80, 300, 150);
	add(label2);
        
        menuBar = new JMenuBar();
	menuBar.setBackground(new Color(223, 200, 33));
	setJMenuBar(menuBar);
        
        tripletas = new JMenu("Tripletas");
	tripletas.setBackground(new Color(255,0,0));
	tripletas.setFont(new Font("Andale Mono", 1, 14));
	tripletas.setForeground(new Color(0, 0, 0));
	menuBar.add(tripletas);
        
        listaf1 = new JMenu("Listas Ligadas Forma 1");
	listaf1.setBackground(new Color(255,0,0));
	listaf1.setFont(new Font("Andale Mono", 1, 14));
	listaf1.setForeground(new Color(0, 0, 0));
	menuBar.add(listaf1);
        
        listaf2 = new JMenu("Listas Ligadas Forma 2");
	listaf2.setBackground(new Color(255,0,0));
	listaf2.setFont(new Font("Andale Mono", 1, 14));
	listaf2.setForeground(new Color(0, 0, 0));
	menuBar.add(listaf2);
        
        otras = new JMenu("Otras opciones");
        otras.setBackground(new Color(255,0,0));
        otras.setFont(new Font("Andale Mono",1,14));
        otras.setForeground(new Color(0, 0, 0));
	menuBar.add(otras);
        
        tripf1 = new JMenuItem("Tripletas + Forma1 = Forma 2");
        tripf1.setFont(new Font("Andale Mono",1,14));
        tripf1.setForeground(new Color(0,0,0));
        otras.add(tripf1);
        tripf1.addActionListener(this);
        
                
        f2f1 = new JMenuItem("Forma 2 * Forma 1 = Tripletas");
        f2f1.setFont(new Font("Andale Mono",1,14));
        f2f1.setForeground(new Color(0,0,0));
        otras.add(f2f1);
        f2f1.addActionListener(this);
        
        creadores = new JMenuItem("Creadores");
        creadores.setFont(new Font("Andale Mono",1,14));
        creadores.setForeground(new Color(0,0,0));
        otras.add(creadores);
        creadores.addActionListener(this);
         
        crear = new JMenuItem("Crear una lista de tripletas");
	crear.setFont(new Font("Andale Mono",1,14));
	crear.setForeground(new Color(0,0,0));
	tripletas.add(crear);
	crear.addActionListener(this);
        
        insertar = new JMenuItem("Insertar una tripleta");
	insertar.setFont(new Font("Andale Mono",1,14));
	insertar.setForeground(new Color(0,0,0));
	tripletas.add(insertar);
	insertar.addActionListener(this);
        
        eliminar = new JMenuItem("Eliminar una tripleta");
	eliminar.setFont(new Font("Andale Mono",1,14));
	eliminar.setForeground(new Color(0,0,0));
	tripletas.add(eliminar);
	eliminar.addActionListener(this);
        
        sumar = new JMenuItem("Sumar dos tripletas");
	sumar.setFont(new Font("Andale Mono",1,14));
	sumar.setForeground(new Color(0,0,0));
	tripletas.add(sumar);
	sumar.addActionListener(this);
        
        multiplicar = new JMenuItem("Multiplicar dos tripletas");
	multiplicar.setFont(new Font("Andale Mono",1,14));
	multiplicar.setForeground(new Color(0,0,0));
	tripletas.add(multiplicar);
	multiplicar.addActionListener(this);
        
        crearf1 = new JMenuItem("Crear Lista Forma 1");
        crearf1.setFont(new Font("Andale Mono",1,14));
        crearf1.setForeground(new Color(0,0,0));
        listaf1.add(crearf1);
        crearf1.addActionListener(this);
        
        insertarf1 = new JMenuItem("Insertar dato");
        insertarf1.setFont(new Font("Andale Mono",1,14));
        insertarf1.setForeground(new Color(0,0,0));
        listaf1.add(insertarf1);
        insertarf1.addActionListener(this);
        
        eliminarf1 = new JMenuItem("Eliminar dato");
        eliminarf1.setFont(new Font("Andale Mono",1,14));
        eliminarf1.setForeground(new Color(0,0,0));
        listaf1.add(eliminarf1);
        eliminarf1.addActionListener(this);
        
        sumarf1 = new JMenuItem("Sumar dos listas forma 1");
        sumarf1.setFont(new Font("Andale Mono",1,14));
        sumarf1.setForeground(new Color(0,0,0));
        listaf1.add(sumarf1);
        sumarf1.addActionListener(this);
        
        multiplicarf1 = new JMenuItem("Multiplicar dos listas forma 1");
        multiplicarf1.setFont(new Font("Andale Mono",1,14));
        multiplicarf1.setForeground(new Color(0,0,0));
        listaf1.add(multiplicarf1);
        multiplicarf1.addActionListener(this);
        
        crearf2 = new JMenuItem("Crear Lista Forma 2");
        crearf2.setFont(new Font("Andale Mono", 1, 14));
        crearf2.setForeground(new Color(0,0,0));
        listaf2.add(crearf2);
        crearf2.addActionListener(this);
       
        insertarf2 = new JMenuItem("Insertar Dato");
        insertarf2.setFont(new Font("Andale Mono", 1, 14));
        insertarf2.setForeground(new Color(0,0,0));
        listaf2.add(insertarf2);
        insertarf2.addActionListener(this);
         
        eliminarf2 = new JMenuItem("Eliminar Dato");
        eliminarf2.setFont(new Font("Andale Mono", 1, 14));
        eliminarf2.setForeground(new Color(0,0,0));
        listaf2.add(eliminarf2);
        eliminarf2.addActionListener(this);
       
        sumarf2 = new JMenuItem("Sumar dos listas forma 2");
        sumarf2.setFont(new Font("Andale Mono", 1, 14));
        sumarf2.setForeground(new Color(0,0,0));
        listaf2.add(sumarf2);
        sumarf2.addActionListener(this);
        
        multiplicarf2 = new JMenuItem("Multiplicar dos listas forma 2");
        multiplicarf2.setFont(new Font("Andale Mono", 1, 14));
        multiplicarf2.setForeground(new Color(0,0,0));
        listaf2.add(multiplicarf2);
        multiplicarf2.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == crear){
            int a[][] = crearMatriz();
            trip.crearTrip(a);
            texto1.setFont(new Font("Andale Mono", 1 ,13));
            texto1.setText("Mostrando Lista de Tripletas:" + "\n\n" + trip.mostrarv2());
        }
        
        if(e.getSource() == insertar){
            try{
                int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de la fila: "));
                int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de la columna: "));
                int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número del dato: "));

                trip.insertarTrip(fila, columna, dato);
                texto1.setFont(new Font("Andale Mono", 1 ,13));
                texto1.setText("Mostrando la tripleta con el dato insertado:" + "\n\n" + trip.mostrarv2());
            }
            catch(Exception x){
                JOptionPane.showMessageDialog(null, "Antes debes crear una lista de tripletas", "Error",0);
            }
        }
        
        if(e.getSource() == eliminar){
             try{
                trip.eliminarDato();
                texto1.setText("Mostrando la tripleta con el dato borrado:" + "\n\n" + trip.mostrarv2());
            }
            catch(Exception x){
                JOptionPane.showMessageDialog(null, "Antes debes crear una lista de tripletas", "Error",0);
            }
        }
       
        if(e.getSource() == sumar){
            int matriz1[][] = crearMatriz();
            int matriz2[][] = crearMatriz();
            
            Tripleta trip1 = new Tripleta();
            Tripleta trip2 = new Tripleta();
            Tripleta trip3 = new Tripleta();
            
            trip1.crearTrip(matriz1);
            trip2.crearTrip(matriz2);
            trip3 = trip2;
            
            if(trip1.getFil(0) == trip2.getFil(0) && trip1.getCol(0) == trip2.getCol(0)){
                trip3 = trip1.sumar(trip2);
                texto1.setFont(new Font("Andale Mono", 1 ,13));
                texto1.setText("Resultado de las tripletas sumadas:\n" + trip3.mostrarv2());
                
                label2.setVisible(false);
                
                if(label3 != null){
                    label3.setVisible(false);
                }
             
                ImageIcon imagen = new ImageIcon(getClass().getResource("/images/happy.png"));
                label4 = new JLabel(imagen);
                label4.setBounds(325, 80, 300, 150);
                add(label4);
            }
            else{
                texto1.setFont(new Font("Andale Mono", 1 ,13));
                texto1.setText("\n\n\nLo sentimos, no se pueden sumar las tripletas porque\ntienen diferentes dimensiones. :(");
                
                label2.setVisible(false);
                label4.setVisible(false);
                
                ImageIcon imagen = new ImageIcon(getClass().getResource("/images/sad.png"));
                label3 = new JLabel(imagen);
                label3.setBounds(325, 80, 300, 150);
                add(label3);
            }        
        }
        
        if(e.getSource() == multiplicar){
            int matriz1[][] = crearMatriz();
            int matriz2[][] = crearMatriz();
            
            Tripleta trip1 = new Tripleta();
            Tripleta trip2 = new Tripleta();
            Tripleta trip3 = new Tripleta();
            
            trip1.crearTrip(matriz1);
            trip2.crearTrip(matriz2);
            
           try{
                if(trip1.getCol(0) == trip2.getFil(0)){
                    trip3 = trip1.multiplicar(trip2);
                    texto1.setFont(new Font("Andale Mono", 1 ,13));
                    texto1.setText("Resultado de las tripletas multiplicadas:\n" + trip3.mostrarv2());

                    label2.setVisible(false);
                    if(label3 != null){
                        label3.setVisible(false);
                    }
                    
                    ImageIcon imagen = new ImageIcon(getClass().getResource("/images/happy.png"));
                    label4 = new JLabel(imagen);
                    label4.setBounds(325, 80, 300, 150);
                    add(label4);
                }
                else{
                    texto1.setFont(new Font("Andale Mono", 1 ,13));
                    texto1.setText("\n\n\nLo sentimos, no se pueden multiplicar las tripletas porque\nlas tripletas no cumplen la condición");

                    label2.setVisible(false);
                    label4.setVisible(false);

                    ImageIcon imagen = new ImageIcon(getClass().getResource("/images/sad.png"));
                    label3 = new JLabel(imagen);
                    label3.setBounds(325, 80, 300, 150);
                    add(label3);
                }
           }catch(Exception x){
               System.out.println("Profe, no le preste atención a esta exception, es por un problema de la interfaz pero nada grave");
           }  
        }
        
        if(e.getSource() == crearf1){
            int[][] matriz = crearMatriz();
            
            listaForma1 = forma1.crearForma1(matriz);
            
            texto1.setFont(new Font("Andale Mono", 1 ,13));
            texto1.setText("Mostrando Lista Forma 1:" + "\n\n" + forma1.mostrarForma1V2(listaForma1));
        }
        
        if(e.getSource() == insertarf1){
            forma1.insertarDato(listaForma1);
            texto1.setText("Mostrando Lista Forma 1:" + "\n\n" + forma1.mostrarForma1V2(listaForma1));
        }
        
        if(e.getSource() == eliminarf1){
            forma1.eliminarDato(listaForma1);
            texto1.setText("Mostrando Lista Forma 1 con el dato ya eliminado:" + "\n\n" + forma1.mostrarForma1V2(listaForma1));
        }
        
        if(e.getSource() == sumarf1){
            int matriz1[][] = crearMatriz();
            int matriz2[][] = crearMatriz();
            
            Forma1 f1 = new Forma1();
            
            Lista l1 = new Lista();
            Lista l2 = new Lista();
            
            l1 = f1.crearForma1(matriz1);
            l2 = f1.crearForma1(matriz2);
            
            Lista resultado = new Lista();
            resultado = forma1.sumar(l1, l2);
            f1.mostrarForma1(resultado);
            texto1.setText("Mostrando el resultado de la suma:" + "\n\n" + f1.mostrarForma1V2(resultado));
            
        }
        
        if(e.getSource() == multiplicarf1){
            int matriz1[][] = crearMatriz();
            int matriz2[][] = crearMatriz();
            
            Forma1 f1 = new Forma1();
            
            Lista l1 = new Lista();
            Lista l2 = new Lista();
            Lista resultado = new Lista();
            
            l1 = f1.crearForma1(matriz1);
            l2 = f1.crearForma1(matriz2);
            
            resultado = f1.multiplicar(l1, l2);
            if(resultado != null){
                texto1.setText("Mostrando el resultado de la suma:" + "\n\n" + f1.mostrarForma1V2(resultado));
            }else{
                JOptionPane.showMessageDialog(null, "No se puede visualizar", "Error",0);
            }
        }
        
        if(e.getSource() == crearf2){
            int matriz[][] = crearMatriz();
            listaForma2 = listaForma2.crearListaForm2(matriz);
            listaForma2.ligarColumnas();
            
            texto1.setFont(new Font("Andale Mono", 1 ,13));
            texto1.setText("Mostrando Lista Forma 2 por filas:" + "\n\n" + listaForma2.mostrarv2() + "\n\nMostrando Lista Forma 2 por columnas:" +"\n\n" + listaForma2.mostrarColumnasV2() +"\n\nSi no ves la lista completa puedes hacer un scroll");
        }
        
        if(e.getSource() == insertarf2){
            try{
                int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de la fila: "));
                int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de la columna: "));
                int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número del dato: "));
                if(fila <= listaForma2.getCabeza().getFila() && columna <= listaForma2.getCabeza().getColumna()){
                    listaForma2.insertPos(fila, columna, dato);
                    texto1.setFont(new Font("Andale Mono", 1 ,13));
                    texto1.setText("Mostrando la lista forma 2 con el dato insertado:" + "\n\n" + listaForma2.mostrarv2());
                }else{
                     JOptionPane.showMessageDialog(null, "La fila y/o columna no pertenecen a la dimension de la matriz " + listaForma2.getCabeza().getFila() + " " + listaForma2.getCabeza().getColumna() , "Error",0);
                }
            }
            catch(Exception x){
                JOptionPane.showMessageDialog(null, "Antes debes crear una lista Forma 2", "Error",0);
            }
        }
        
        if(e.getSource() == eliminarf2){
            int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato a eliminar"));
            listaForma2.eliminar(dato);
            texto1.setText("Mostrando la lista forma 2 sin el dato ya eliminado:" + "\n\n" + listaForma2.mostrarv2());
        }
        
        if(e.getSource() == sumarf2){
            int[][] matriz2 = crearMatriz();
            int[][] matriz3 = crearMatriz();
            
            ListaF2 lista1 = new ListaF2();
            lista1 = lista1.crearListaForm2(matriz3);
            ListaF2 lista2 = new ListaF2();
            lista2 = lista2.crearListaForm2(matriz2);
            
            if(lista1.getCabeza().getFila() == lista2.getCabeza().getFila() && lista1.getCabeza().getColumna() == lista2.getCabeza().getColumna()){
                ListaF2 suma = new ListaF2();
                suma = lista1.sumar(lista2);
                suma.ligarColumnas();
            
                texto1.setFont(new Font("Andale Mono", 1 ,13));
                texto1.setText("Mostrando el resultado de la suma:" + "\n\n" + suma.mostrarv2() + "\n\n Ahora por columnas\n\n" + suma.mostrarColumnasV2());
            }else{
                JOptionPane.showMessageDialog(null, "No se pueden sumar las listas porque no tienen las misma dimensiones", "Error",0);
            }
        }
        
        if(e.getSource() == multiplicarf2){
            int[][] matriz2 = crearMatriz();
            int[][] matriz3 = crearMatriz();
            
            ListaF2 lista1 = new ListaF2();
            lista1 = lista1.crearListaForm2(matriz3);
            ListaF2 lista2 = new ListaF2();
            lista2 = lista2.crearListaForm2(matriz2);
            
            if(lista1.getCabeza().getFila() == lista2.getCabeza().getColumna()){
                ListaF2 multiplicacion = new ListaF2();
                multiplicacion = lista1.multiplicar(lista2);
                multiplicacion.ligarColumnas();
                
                texto1.setFont(new Font("Andale Mono", 1 ,13));
                texto1.setText("Mostrando el resultado de la multiplicación:" + "\n\n" + multiplicacion.mostrarv2() + "\n\n Ahora por columnas\n\n" + multiplicacion.mostrarColumnasV2());
            }else{
                JOptionPane.showMessageDialog(null, "No se pueden mulitplicar las listas porque el # de filas de lista 1\n es diferente al # de columnas de la lista 2", "Error",0);
            }
        }
        
        if(e.getSource() == tripf1){
            int matriz2[][] = crearMatriz();
            int matriz3[][] = crearMatriz();
            
            Forma1 forma1=new Forma1();
            ListaF2 lista2 = new ListaF2();
            Lista l1;
            CombinacionFormas resultado = new CombinacionFormas();
            
            Tripleta trip = new Tripleta();
            trip.crearTrip(matriz2);
            l1 = forma1.crearForma1(matriz3);
            ListaF2 resul = new ListaF2();
            
            if(trip.getFil(0) == l1.getPunta().getF() && trip.getCol(0) == l1.getPunta().getC()){
                resul = resultado.sumarFormas(trip, l1);
                resul.ligarColumnas();
                texto1.setFont(new Font("Andale Mono", 1 ,13));
                texto1.setText("Mostrando resultado de la suma de las formas:" + "\n\n" + resul.mostrarv2() + "\n\nMostrando el resultado por columnas:" +"\n\n" + resul.mostrarColumnasV2() +"\n\nSi no ves la lista completa puedes hacer un scroll");
            }else{
                JOptionPane.showMessageDialog(null, "No se pueden sumar las formas porque no son de las mismas dimensiones", "Error",0);
            }
           
            //No funciona bien el método
        }
        
        if(e.getSource() == f2f1){
            int matriz2[][] = crearMatriz();
            int matriz3[][] = crearMatriz();
            
            Forma1 forma1=new Forma1();
            ListaF2 lista2 = new ListaF2();
            Lista l1;
            CombinacionFormas resultado = new CombinacionFormas();
            l1 = forma1.crearForma1(matriz3);
            lista2 = lista2.crearListaForm2(matriz2);
            Tripleta res = new Tripleta();
            if(l1.getPunta().getF() == lista2.getCabeza().getColumna()){
                res = resultado.multiplicarFormas(l1, lista2);
                texto1.setFont(new Font("Andale Mono", 1 ,13));
                texto1.setText("Mostrando la tripleta resultado:" + "\n\n" + res.mostrarv2());
            }else{
                JOptionPane.showMessageDialog(null, "No se pueden sumar las formas porque no cumplen la condición para multiplicar", "Error",0);
            }
            
        }
        
        if(e.getSource() == creadores){
            JOptionPane.showMessageDialog(null, "Desarrollado por: Luis David Lopez & Anderson Garces", "Creadores",1);
        }
    }

    public int[][] crearMatriz(){
        
        int i = 0;
        int f = 0;
        int c = 0;
        int cont = 0;
        int mat[][];
        
        f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número de filas:"));
        c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número de columnas:"));
        
        int porcentaje = (int)(f*c*90)/100;
        mat = new int[f][c];
        
        for (i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
               mat[i][j] = 0 + (int)(Math.random()*30);
            }
        }
        
        while(i <= porcentaje){
            mat[(int)(0 + Math.random()*f)][(int)(0 + Math.random()*c)] = 0;
            i++;
        }
        
        String resultado = "";
        for (int j = 0; j < f; j++) {
            for (int k = 0; k < c; k++) {
                resultado += mat[j][k];
                resultado += "      ";
            }
            resultado +="\n";
        }
        
        JOptionPane.showMessageDialog(null, resultado, "Matriz generada automaticamente", 1);
        return mat;
    }
}
