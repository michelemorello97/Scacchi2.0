package model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
@Id("aiMove")
public class AiMove {
	

	@Param(0)
	String tipo;
	
	@Param(1)
	int index;
	
	@Param(2)
	String c;
	
	@Param(3)
	int x;
	
	@Param(4)
	int y;
	
	public AiMove() { 
		
	}
	
	public AiMove(Pezzo p) {
		this.tipo=p.tipo;
		this.index=p.index;
		this.c=p.c;
		this.x=p.x;
		this.y=p.y;
	}
	
	public AiMove(AiMove p) {
		this.tipo=p.tipo;
		this.index=p.index;
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
		return "AiMove [tipo=" + tipo + ", index= "+ index + ", c=" + c + ", x=" + x + ", y=" + y + "]";
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
