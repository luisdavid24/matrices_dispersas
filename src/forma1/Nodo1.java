package forma1;

public class Nodo1 {
	private int f;
	private int c;
	private Nodo1 Lc;
	private Nodo1 Lf;
	private Nodo1 Liga;
	private int Dato;

	public Nodo1(int f,int c,int dato) {
		Lc=null;
		Lf=null;
		Liga=null;
		Dato=dato;
		this.f=f;
		this.c=c;
	}
	
	
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public Nodo1 getLc() {
		return Lc;
	}
	public void setLc(Nodo1 lc) {
		Lc = lc;
	}
	public Nodo1 getLf() {
		return Lf;
	}
	public void setLf(Nodo1 lf) {
		Lf = lf;
	}
	public Nodo1 getLiga() {
		return Liga;
	}
	public void setLiga(Nodo1 liga) {
		Liga = liga;
	}
	public int getDato() {
		return Dato;
	}
	public void setDato(int dato) {
		Dato = dato;
	}
}
