package model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
@Id("focus")
public class Focus {
	

	@Param(0)
	String tipo;
	
	@Param(1)
	String c;
	
	@Param(2)
	int x;
	
	@Param(3)
	int y;
	
	public Focus() { 
		
	}
	
	public Focus(Pezzo p) {
		this.tipo=p.tipo;
		this.c=p.c;
		this.x=p.x;
		this.y=p.y;
	}
	
	public Focus(Focus p) {
		this.tipo=p.tipo;
		this.c=p.c;
		this.x=p.x;
		this.y=p.y;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getC() {
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
	
	@Override
	public String toString() {
		return "Focus [tipo=" + tipo + ", c=" + c + ", x=" + x + ", y=" + y + "]";
	}
}
