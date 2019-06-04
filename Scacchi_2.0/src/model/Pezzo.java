package model;

import interfaces.Colore;
import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
@Id("pezzo")
public class Pezzo {
	@Param(0)
	String tipo;
	
	@Param(1)
	String c;
	
	@Param(2)
	int x;
	
	@Param(3)
	int y;
	public Pezzo(String tipo, String colore, int x, int y) {
		this.tipo=tipo;
		this.c=colore;
		this.x=x;
		this.y=y;
	}
	
	public Pezzo(Pezzo p) {
		this.tipo=p.tipo;
		this.c=p.c;
		this.x=p.x;
		this.y=p.y;
	}
	@Override
	public String toString() {
		return "Pezzo [tipo=" + tipo + ", c=" + c + ", x=" + x + ", y=" + y + "]";
	}

	public String getTipo() {
		return tipo;
	}
	
	public String getColore() {
		return c;
	}


	public void setC(String c) {
		this.c = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
