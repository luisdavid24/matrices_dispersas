package forma1;

public class Lista {
	Nodo1 punta;
	
	public Lista() {
		punta=null;
	}
	public Nodo1 getPunta() {
		return punta;
	}
	public void setPunta(Nodo1 punta) {
		this.punta=punta;
	}
	
	public void nuevaCabe(Nodo1 x) {
		punta=x;
	}
	
	public void InsertarFinal(int f,int c,int dato) {
		Nodo1 x=new Nodo1(f,c,dato);
		Nodo1 p;
		if(punta==null) {
			punta=x;
		}else {
			p=punta;
			while(p.getLiga()!=null) {
				p=p.getLiga();
			}
			p.setLiga(x);
		}
		
	}
	public void insertarFila(int f,int c,int dato) {
		Nodo1 x=new Nodo1(f,c,dato);
		Nodo1 p;
		if(punta==null) {
			punta=x;
		}else {
			p=punta;
			while(p.getLf()!=null) {
				p=p.getLf();
			}
			p.setLf(x);
		}
		
	}
	public void ponerCircular() {
		Nodo1 p;
		p=punta;
		while(p.getLiga()!=null) {
			p=p.getLiga();
		}
		p.setLiga(punta);
	}
	public void ponerCircularFila() {
		Nodo1 p;
		p=punta;
		while(p.getLf()!=null) {
			p=p.getLf();
		}
		p.setLf(punta);
		
		
	}
	public Nodo1 buscarFila(int fila) {
		Nodo1 p;
		p=punta;
		if(p.getF()==fila) {
			return p;
		}else {
			p=p.getLiga();
			while(p!=punta) {
				if(p.getF()==fila) {
					return p;
				}
				p=p.getLiga();
			}		
		}
		return null;
	}
	
	public Nodo1 buscarColumna(int columna) {
		Nodo1 p;
		p=punta;
		if(p.getC()==columna) {
			return p;
		}else {
			p=p.getLiga();
			while(p!=punta) {
				if(p.getC()==columna) {
					return p;
				}
				p=p.getLiga();
			}		
		}
		return null;
	}
	public void mostrar() {
		Nodo1 p;
		p=punta;
		System.out.println("Fila: "+p.getF()+" Columna: "+p.getC()+" Dato:"+p.getDato());
		p=p.getLiga();
		while(p!=punta) {
			System.out.println("Fila: "+p.getF()+" Columna: "+p.getC()+" Dato:"+p.getDato());
			p=p.getLiga();
		}
	}
	public void mostrarFila() {
		Nodo1 p;
		p=punta;
		System.out.print("[F:"+p.getF()+" C:"+p.getC()+"D:"+p.getDato()+"]->");
		p=p.getLf();
		while(p!=punta) {
			System.out.print("[F:"+p.getF()+" C"+p.getC()+" D:"+p.getDato()+"]->");
			p=p.getLf();
		}
		System.out.print("[F:"+p.getF()+" C:"+p.getC()+"D:"+p.getDato()+"]");
		
		
	}
	public void mostrarColuman(Nodo1 a) {
		Nodo1 p;
		p=a;
		System.out.println("Fila: "+p.getF()+" Columna: "+p.getC()+" Dato:"+p.getDato());
		p=p.getLc();
		while(p!=a) {
			System.out.println("Fila: "+p.getF()+" Columna: "+p.getC()+" Dato:"+p.getDato());
			p=p.getLc();
		}
	}
	public void mostrarColuman2(Nodo1 q) {
		Nodo1 p;
		p=q;
		System.out.println("Fila: "+p.getF()+" Columna: "+p.getC()+" Dato:"+p.getDato());
		p=p.getLc();
		while(p!=punta) {
			System.out.println("Fila: "+p.getF()+" Columna: "+p.getC()+" Dato:"+p.getDato());
			p=p.getLc();
		}
	}
}
