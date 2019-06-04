package model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("move")
public class Move {
	

	@Param(0)
	String tipo;
	
	@Param(1)
	String c;
	
	@Param(2)
	int x;
	
	@Param(3)
	int y;
	
	public Move() { 
		
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
		return "Move [tipo=" + tipo + ", c=" + c + ", x=" + x + ", y=" + y + "]";
	}
}
