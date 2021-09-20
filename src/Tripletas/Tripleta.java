package Tripletas;

import javax.swing.JOptionPane;

/**
 *
 * @author Anderson
 */
public class Tripleta {
    private int du;
    private int [][] trip;
    
    public Tripleta(){}
    
    public Tripleta(int f, int c, int d){
        int trip[][] = new int[d+1][3];
        trip[0][0] = f;
        trip[0][1] = c;
        trip[0][2] = d;
    }
 
    public int getDato(int pos){
        return trip[pos][2];
    }
    
    public int getCol(int pos)
     {
         return trip[pos][1];
     }
    
    public int getFil(int pos){
        return trip[pos][0];
    }
    
    public int getLeng(){
        return trip.length;
    }
    
    public void crearTrip(int[][] mat){
        int columnas = 0;
        int cont = 0;
       
        for (int i = 0; i < mat.length; i++) {
            columnas = mat[i].length;
        }
      
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < columnas; j++) {
               if((int)mat[i][j] != 0){
                   cont++;
               }
            }
        }
        
        trip = new int[cont+1][3];
        trip[0][0] = mat.length;
        trip[0][1] = columnas;
        trip[0][2] = cont;
        int k = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < columnas; j++) {
                if(mat[i][j] != 0){
                   trip[k][0] = i;
                   trip[k][1] = j;
                   trip[k][2] = mat[i][j];
                   k++;
                }
            }
        }
        
        System.out.println("Hecho");
    }
    
    public void mostrar(){
        String resultado = "";
        for (int i = 0; i < trip.length; i++) {
            for (int j = 0; j < 3; j++) {
                resultado += trip[i][j];
                resultado += "        ";
            }
            resultado += "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, "Lista de tripletas", 1);
    }
    
    public String mostrarv2(){
        String resultado = "";
        for (int i = 0; i < trip.length; i++) {
            for (int j = 0; j < 3; j++) {
                resultado += trip[i][j];
                resultado += "        ";
            }
            resultado += "\n";
        }
        return resultado;
    }
    
    
    public void insertarTrip(int f, int c, int d){
        int k = 1, j;
        //Buscando Fila
        while(k < trip[0][2]+1 && trip[k][0] < f && trip[k][2] != 0){
            k++;
        }
        //Fila encontrada buscando columna
        while(k<trip[0][2]+1 && trip[k][0] <= f && trip[k][1] < c && trip[k][2]!=0)
        {
            k++;
        }
        if(k < trip[0][2]+1 && trip[k][0] == f && trip[k][1] == c && trip[0][2] != 0){
            if(trip[k][2]+d != 0){
                trip[k][2] = trip[k][2]+d;
            }
            else{
                for ( j = k; j < trip[0][2]-1; j++) {
                   trip[j][0]= trip[j+1][0];
                   trip[j][1]= trip[j+1][1];
                   trip[j][2]= trip[j+1][2];
                }
                trip[0][2] = trip[0][2]-1;
            }
        }
        else{
            this.redimensionar();
            for(j = trip[0][2]+1; j>k; j--){
                trip[j][0]= trip[j-1][0];
                trip[j][1]= trip[j-1][1];
                trip[j][2]= trip[j-1][2];
                
            }
           trip[0][2] = trip[0][2]+1;
           trip[k][0] =f;
           trip[k][1] =c;
           trip[k][2] =d;
            
        }
    }
    
     public void redimensionar(){
         int k;
         int nt = trip[0][2];
         nt = nt+1;
         int aux[][] = new int[nt+1][3];
         
         for(k=0;k<trip[0][2]+1;k++)
           {
              aux[k][0] =trip[k][0];
              aux[k][1] =trip[k][1];
              aux[k][2] =trip[k][2]; 
           }
         trip = aux;
     }
     
     public void eliminarDato(){
        int tamano=trip[0][2];
        int [][] tripAux;
        tripAux = new int[tamano][3];
        int datoBorrar= Integer.parseInt(JOptionPane.showInputDialog("Digite el dato a borrar"));
        tripAux[0][0]=trip[0][0];
        tripAux[0][1]=trip[0][1];
        tripAux[0][2]=tamano-1;
        int k=1;
        for(int i = 1; i < trip.length; i++){
            if(trip[i][2]!=datoBorrar){
                tripAux[k][0]=trip[i][0];
                tripAux[k][1]=trip[i][1];
                tripAux[k][2]=trip[i][2];
                k++;
            }
        }
        trip=tripAux;
    }
    
     public Tripleta sumar(Tripleta b){
         
        Tripleta resp1 = new Tripleta();
        resp1 = b;
      
         for (int i = 1; i < this.getDato(0)+1; i++) {
             resp1.insertarTrip(this.getFil(i), this.getCol(i), this.getDato(i));
         }
        return resp1;
     }
     
     public Tripleta multiplicar(Tripleta b){
        Tripleta tripB = new Tripleta();
        tripB = b;
        int columnaA=trip[0][1];
        int filaA=trip[0][0];
        int filaB=tripB.getFil(0);
        int columnaB=tripB.getCol(0);
        int tamanoVector=columnaA*filaB*3;
        int vector[]=new int[tamanoVector];
        int l=0;
        Tripleta nueva= new Tripleta(); 
            
        if(columnaA==filaB){
            int f=0,c=0,operacion=0;
            while(f<filaA){
                operacion=0;
                int k=buscarIndice(f);
                if(k!=-1){
                    for(int i=k;i<trip.length;i++){
                        if(trip[i][0]==f){
                            int filaelemento=trip[i][1];
                            for(int j=1;j<tripB.getLeng();j++){
                                if(tripB.getFil(j)==filaelemento){
                                    if(tripB.getCol(j)==c){
                                        int datoB=tripB.getDato(j);
                                        int datoA=trip[i][2];
                                        operacion+=datoB*datoA;
                                    }
                                }   
                            }
                        }  
                    }
                    if(operacion!=0){
                        vector[l]=f;
                        l++;
                        vector[l]=c;
                        l++;
                        vector[l]=operacion;
                        l++;
                    }
                    c++;
                    if(c>=columnaB){
                        c=0;
                        f++;
                    
                    }
                }else{
                    f++;
                    c=0; 
                }
            }
        /*for(int i=0;i<vector.length;i++){
            System.out.print("-"+vector[i]+"-");
        }*/   
        nueva.llenarTripleta(vector,filaA,columnaB); 
           
        }else{
            System.out.println("No se puede hacer esa operacion");
        }

        return nueva;
       
    }
    public int buscarIndice(int f)
    { 
        for(int i=1;i<trip.length;i++){
            if(trip[i][0]==f){
                return i;
            }
        }
        return -1;
    }
    
    public void llenarTripleta(int[] vector,int fila,int columna){
        int columnas = 0;
        int cont = 0;
        int contador=0;
        for(int i=2;i<vector.length;i+=3){
            if(vector[i]!=0){
                contador++;
            }
        }
        trip = new int[contador+1][3];
        trip[0][0] = fila;
        trip[0][1] = columna;
        trip[0][2] = contador;
        int k=1;
        
        for (int i = 0; i <vector.length; i+=3) {
            if(vector[i+2]!= 0){
                   trip[k][0] = vector[i];
                   trip[k][1] = vector[i+1];
                   trip[k][2] = vector[i+2];
                   k++;
            }   
        }  
   }
     
}
