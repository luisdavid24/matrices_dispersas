package forma1;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Forma1 {
	public Forma1() {}
	Scanner sc = new Scanner(System.in);
	
	public Lista crearForma1(int[][] matriz) {
		
		int fila=matriz.length;
		int columna=matriz[0].length;
		int numeroCabe=0;
		
		//Paso 1
		if(fila>columna) {
			numeroCabe=fila;
		}else {
			numeroCabe=columna;
		}
		Lista l1=new Lista();
		l1.InsertarFinal(fila, columna,0);
		
		for(int i=0;i<numeroCabe;i++) {
			l1.InsertarFinal(i, i, 0);
				
		}
		l1.ponerCircular();
		
		
		//Paso 2 
		for(int i=0;i<fila;i++) {
			Nodo1 aux;
			aux=l1.buscarFila(i);
			if(aux!=null) {
				Lista l2=new Lista();
				l2.nuevaCabe(aux);
				for(int j=0;j<columna;j++) {
					int dato=matriz[i][j];
					
					if(dato!=0) {
						l2.insertarFila(i,j,dato);
					}
				}
				l2.ponerCircularFila();
				//l2.mostrarFila();
				//System.out.println("");
			}
		}
            //Paso 3
            Nodo1 punta,p,q,Rc,aux;
            punta=l1.getPunta();
            aux=punta.getLiga();
            Rc=aux;
            while(Rc!=punta) {
                    p=buscarP(l1,Rc); 
                    q=aux;
                    while(q!=punta) {
                            if(q.getLf()!=null) {
                                    Nodo1 b;
                                    b=q.getLf();
                                    while(b!=q) {
                                            if(b.getC()==Rc.getC()) {
                                                    p.setLc(b);
                                                    p=b;

                                            }
                                            b=b.getLf();
                                    }
                            }
                            q=q.getLiga();

                    }
                    p.setLc(Rc);
                    Rc=Rc.getLiga();

            }
		
		return l1;
	}
        
        public Nodo1 buscarP(Lista Lista1,Nodo1 Rc) {
            Nodo1 punta=Lista1.getPunta();
            Nodo1 p=punta.getLiga();
            while(p.getC()!=Rc.getC()) {
                    p=p.getLiga();
            }
            return p;
        }
        
	public void mostrarForma1(Lista Lista1) {
            Nodo1 p=Lista1.getPunta();
            Nodo1 q=p;
            System.out.println("[F:"+q.getF()+"][C:"+q.getC()+"][D:"+q.getDato()+"]");
            q=q.getLiga();
            Nodo1 A;
            while(q!=p) {
                    A=q;
                    System.out.print("[F:"+A.getF()+"][C:"+A.getC()+"][D:"+A.getDato()+"] ");
                    if(A.getLf()!=null) {
                        A=A.getLf();
                        while(A!=q) {
                            System.out.print("[F:"+A.getF()+"][C:"+A.getC()+"][D:"+A.getDato()+"] ");
                            A=A.getLf();
                        }
                    }
                System.out.println("");
                q=q.getLiga();
            }
	}
        
        public String mostrarForma1V2(Lista Lista1) {
            Nodo1 p=Lista1.getPunta();
            Nodo1 q=p;
            String resultado = "";
            resultado +=("["+ q.getF()+ "|" + q.getC()+"|" + q.getDato()+"]" + "->");
            q=q.getLiga();
            Nodo1 A;
            while(q!=p) {
                    A=q;
                    resultado +=("["+ A.getF()+ "|" + A.getC()+"|" +A.getDato()+"]" + "->");
                    if(A.getLf()!=null) {
                        A=A.getLf();
                        while(A!=q) {
                            resultado +=("["+ A.getF()+ "|" + A.getC()+"|" +A.getDato()+"]" + "->");
                            A=A.getLf();
                        }
                    }
                resultado += "\n";
                q=q.getLiga();
            }
            return resultado;
	}
        
	public void insertarDato(Lista Lista1) {
                int fila = Integer.parseInt(JOptionPane.showInputDialog("Digite la fila del dato"));
                int columna = Integer.parseInt(JOptionPane.showInputDialog("Digite la columna del dato"));
                int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el nuevo dato"));
		Nodo1 Nuevo=new Nodo1(fila,columna,dato);
		Nodo1 Punta=Lista1.getPunta();
		Nodo1 A=Punta.getLiga();
		boolean condicion=false;
		while(A!=Punta) {
			if(A.getF()==fila) {
				Nodo1 B;
                                Nodo1 C;
				B=A;
				if(B.getLf()!=A) {
					C=B.getLf();
					while(C!=A) {
						if(C.getC()==columna) {
							System.out.println("Este estacio esta ocupado por otro datos");
							C=A;
						}else if(columna<C.getC()) {
							B.setLf(Nuevo);
							Nuevo.setLf(C);
							condicion=true;
						}else if(C==A) {
							B.setLf(Nuevo);
							Nuevo.setLf(C);
							condicion=true;
						}else {
							B=C;
							C=C.getLf();
						}
						
					}
				}else{
					A.setLf(Nuevo);
					Nuevo.setLf(A);
				}
				
			}
			A=A.getLiga();
		}
		if(condicion==true) {
			this.corregirLigaColumna(columna, Lista1);
		}
	}
	public void corregirLigaColumna(int columna,Lista Lista1 ) {
            Nodo1 punta;
		Nodo1 p,q,Rc,aux;
		punta=Lista1.getPunta();
		p=punta.getLiga();
		aux=p;
		q=p.getLf();
		Rc=p;
		int condicion=0;
		while(Rc!=punta && condicion==0) {
			if(Rc.getC()==columna) {
					condicion=5;
			}else {
				Rc=Rc.getLiga();
			}
		}
		while(p!=punta) {
			while(p!=q && q.getDato()!=0) {
				if(q.getC()==Rc.getC()){
					p.setLc(q);
					p=q;
				}
				q=q.getLf();
			}
			aux=aux.getLiga();
			if(aux==punta) {
				p.setLc(Rc);
				p=punta;
			}else {
				q=aux.getLf();
			}
		}
	}
	public void eliminarDato(Lista Lista1) {
                int fila = Integer.parseInt(JOptionPane.showInputDialog("Digite la fila del dato"));
                int columna = Integer.parseInt(JOptionPane.showInputDialog("Digite la columna del dato"));
                int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el dato que quiere eliminar"));
		Nodo1 Punta=Lista1.getPunta();
		Nodo1 A=Punta.getLiga();
		boolean condicion=false;
		while(A!=Punta) {
			if(A.getF()==fila) {
				Nodo1 B;
                                Nodo1 C;
				B=A;
				if(B.getLf()!=A) {
					C=B.getLf();
					while(C!=A) {
						if(C.getC()==columna) {
							if(C.getDato()==dato) {
								B.setLf(C.getLf());
								C=A;
								condicion=true;
							}
						}else {
							B=C;
							C=C.getLf();
						}
						
					}
				}
				
			}
			A=A.getLiga();
		}
		if(condicion==true) {
			this.corregirLigaColumna(columna, Lista1);
		}
		
	}
        
        public void corregirCircular(Lista l1) {
            Nodo1 p=l1.getPunta();
            Nodo1 q=p.getLiga();
            while(q!=p) {
                if(q.getLf()==null) {
                        q.setLf(q);
                }
                q=q.getLiga();
            }
        }
        
	public Lista multiplicar(Lista Lista1,Lista Lista2) {
		Nodo1 Punta1=Lista1.getPunta();
		Nodo1 Punta2=Lista2.getPunta();
		int columna1=Punta1.getC();
		int fila1=Punta1.getF();
		int columna2=Punta2.getC();
		int fila2=Punta2.getF();
		int[][] matriz=new int[fila1][columna2];
		if(columna1==fila2) {
			Lista Lista3=crearLista(fila1,columna2);
			int f=0,c=0,operacion=0;
			while(f<fila1) {
				int k=buscarIndice(f,Punta1);
				operacion=0;
				if(k!=-1) {
					Nodo1 A=Punta1.getLiga();
					while(A!=Punta1) {
						if(A.getF()==f) {
							Nodo1 B=A.getLf();
							while(B!=A) {
								int FilaBusqueda=B.getC();
								int dato=buscarDato(FilaBusqueda,c,Punta2);
								
								if(dato!=0) {
									operacion+=dato*B.getDato();
									
								}
								B=B.getLf();
							}
							matriz[f][c]=operacion;
							c++;
							if(c>=columna2) {
								
								c=0;
								f++;
								operacion=0;
							}
						}
						A=A.getLiga();
						
					}
				}else {
					f++;
					c=0;
				}
				
			}
			Lista3=crearForma1(matriz);
			return Lista3;
		}else {
			System.out.println("No se puede realizar la operacion");
			return null;
		}
		
	}
	public int buscarIndice(int f,Nodo1 Punta) {
		Nodo1 p=Punta.getLiga();
		while(p!=Punta) {
			if(p.getF()==f) {
				Nodo1 q=p.getLiga();
				if(q!=p) {
					return f;
				}
			}
			p=p.getLiga();
		}
		return -1;
	}
	public int buscarDato(int f, int c,Nodo1 Punta) {
		Nodo1 p=Punta.getLiga();
		while(p!=Punta) {
			if(p.getF()==f) {
				Nodo1 B=p.getLf();
				while(B!=p) {
					if(B.getC()==c) {
						return B.getDato();
					}
					B=B.getLf();
				}
			}
			p=p.getLiga();
		}
		
		return 0;
	}
	public Lista crearLista(int f,int c) {
		int numeroCabe=0;
		
		if(f>c) {
			numeroCabe=f;
		}else {
			numeroCabe=c;
		}
		Lista Lista1=new Lista();
		Lista1.InsertarFinal(f,c,0);
		
		for(int i=0;i<numeroCabe;i++) {
			Lista1.InsertarFinal(i, i, 0);
				
		}
		Lista1.ponerCircular();
		return Lista1;
		
		
	}
	public void llenar(Lista Lista,int f,int c,int dato) {
		Nodo1 Punta=Lista.getPunta();
		Nodo1 p=Punta.getLiga();
		Nodo1 nuevo=new Nodo1(f,c,dato);
		while(p!=Punta) {
			if(p.getF()==f) {
				Nodo1 A=p.getLiga();
				if(A==p) {
					p.setLf(nuevo);
				}else {
					int condicion=0;
					while(A.getLf()!=p && condicion==0) {
						if(A.getLf()!=null){
							
							A=A.getLf();
						}else {
							condicion=4;
						}
					}
					A.setLf(nuevo);
				}
				nuevo.setLf(p);
			}
			p=p.getLiga();
		}
	}
	public Lista sumar(Lista Lista1,Lista Lista2) {
		Nodo1 Punta1=Lista1.getPunta();
		Nodo1 Punta2=Lista2.getPunta();
		int columna1=Punta1.getC();
		int fila1=Punta1.getF();
		int columna2=Punta2.getC();
		int fila2=Punta2.getF();
		if(fila2==fila1 && columna1==columna2) {
			Lista Lista3=Lista1;
			Nodo1 p=Punta2.getLiga();
			while(p!=Punta2) {
				Nodo1 q=p.getLf();
				while(q!=p) {
					//verificar si ese nodo existe
					int indice=nodoExiste(Lista1,q.getF(),q.getC(),q.getDato());
					if(indice==-1) {
						agregarUnNodo(Lista1,q.getF(),q.getC(),q.getDato());
						System.out.println("Va tocar crear un nodo");
					}
					q=q.getLf();
				}
				
				p=p.getLiga();
			}
			ponerColumna(Lista3);
			return Lista3;
		}else {
			System.out.println("No se puede realizar la operacion");
			return null;
		}
	}
	public int nodoExiste(Lista Lista,int f,int c,int dato) {
		Nodo1 Punta=Lista.getPunta();
		Nodo1 p=Punta.getLiga();
		while(p!=Punta) {
			if(p.getF()==f) {
				Nodo1 b=p.getLf();
				while(b!=p) {
					if(b.getC()==c) {
						int dato1=b.getDato();
						dato1+=dato;
						b.setDato(dato1);
						return 1;
					}
					b=b.getLf();
				}
			}
			
			p=p.getLiga();
		}
		return -1;
	}
	public void agregarUnNodo(Lista lista,int f,int c,int dato) {
		Nodo1 punta=lista.getPunta();
		Nodo1 p=punta.getLiga();
		Nodo1 nuevo=new Nodo1(f,c,dato);
		boolean condicion=false;
		while(p!=punta && condicion==false) {
			if(p.getF()==f && condicion==false) {
				Nodo1 c1=p;
				Nodo1 b=p.getLf();
				while(b!=p && condicion==false) {
					if(b.getC()>c) {
						c1.setLf(nuevo);
						nuevo.setLf(b);
						condicion=true;
					}
					c1=b;
					b=b.getLf();
				}
			}
			p=p.getLiga();
		}
	}
	public void ponerColumna(Lista lista) {
            Nodo1 punta;
		Nodo1 p,q,Rc,aux;
		punta=lista.getPunta();
		p=punta.getLiga();
		aux=p;
		q=p.getLf();
		Rc=p;
		while(Rc!=punta) {
			while(p!=punta) {
				while(p!=q && q.getDato()!=0) {
					if(q.getC()==Rc.getC()){
						p.setLc(q);
						p=q;
					}
					q=q.getLf();
				}
				aux=aux.getLiga();
				if(aux==punta) {
					p.setLc(Rc);
					p=punta;
				}else {
					q=aux.getLf();
					
				}
			}
			Rc=Rc.getLiga();
			aux=punta.getLiga();
			
		}
		
	}
}

