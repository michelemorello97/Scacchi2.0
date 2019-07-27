package GameManager;

import java.awt.HeadlessException;
import java.awt.SystemTray;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import ai_manager.Ai_Manager;
import graphic.ChessPanel;
import model.AiMove;
import model.Move;
import model.Pezzo;

public class GameManager implements MouseListener{

	Pezzo[][] scacchiera;
	ChessPanel panel;
	Ai_Manager ai;
	Pezzo focus;
	LinkedList<Move> mossePossibili;
	public GameManager(ChessPanel panel) {
		
		mossePossibili=new LinkedList<>();
		this.panel=panel;
		ai=new Ai_Manager();
		initScacchiera();
				
		panel.repaint();
	}
	
	public Pezzo getPezzo(int i, int j) {
		return scacchiera[i][j];
	}

	
	public void initScacchiera() {
		scacchiera=new Pezzo[8][8];
		for(int i=0; i<8; i++) {
			scacchiera[1][i]=new Pezzo("pedone", i, "nero", i, 1);
			scacchiera[6][i]=new Pezzo("pedone", i, "bianco", i, 6);
		}
		scacchiera[0][0]=new Pezzo("torre", 0, "nero", 0, 0);
		scacchiera[0][7]=new Pezzo("torre", 1, "nero", 7, 0);
		scacchiera[0][1]=new Pezzo("cavallo", 0, "nero", 1, 0);
		scacchiera[0][6]=new Pezzo("cavallo", 1, "nero", 6, 0);
		scacchiera[0][2]=new Pezzo("alfiere", 0, "nero", 2, 0);
		scacchiera[0][5]=new Pezzo("alfiere", 1, "nero", 5, 0);
		scacchiera[0][3]=new Pezzo("regina", 0, "nero", 3, 0);
		scacchiera[0][4]=new Pezzo("re", 0, "nero", 4, 0);
		
		scacchiera[7][0]=new Pezzo("torre", 0, "bianco", 0, 7);
		scacchiera[7][7]=new Pezzo("torre", 1, "bianco", 7, 7);
		scacchiera[7][1]=new Pezzo("cavallo", 0, "bianco", 1, 7);
		scacchiera[7][6]=new Pezzo("cavallo", 1, "bianco", 6, 7);
		scacchiera[7][2]=new Pezzo("alfiere", 0, "bianco", 2, 7);
		scacchiera[7][5]=new Pezzo("alfiere", 1, "bianco", 5, 7);
		scacchiera[7][3]=new Pezzo("regina", 0, "bianco", 3, 7);
		scacchiera[7][4]=new Pezzo("re", 0, "bianco", 4, 7);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x=e.getX()/80;
		int y=e.getY()/80;
		if(scacchiera[y][x]!=null && scacchiera[y][x].getC()=="bianco"){
			focus=scacchiera[y][x];
			System.out.println(focus.toString());
			if(focus.getTipo()=="pedone") 
				mossePedone();
			
			else if(focus.getTipo()=="torre") 
				mosseTorre();

			else if(focus.getTipo()=="cavallo") 
				mosseCavallo();

			else if(focus.getTipo()=="alfiere")
				mosseAlfiere();

			else if(focus.getTipo()=="regina") 
				mosseRegina();

			else if(focus.getTipo()=="re")
				mosseRe();

		}		
		
		else if(focus!=null) 
			checkAndMove(x, y);
		
		if(scacchiera[y][x]!=null && scacchiera[y][x].getC().contains("nero")){
			System.out.println(scacchiera[y][x].toString());
		}
			
		
	}

	public LinkedList<Move> getMossePossibili() {
		return mossePossibili;
	}

	public void setMossePossibili(LinkedList<Move> mossePossibili) {
		this.mossePossibili = mossePossibili;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void mossePedone() {
		
		caricaScacchiera();
	
		ai.addFocusFact(focus);
		
		ai.load("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/encodings/Pedone");
		try {
			mossePossibili.clear();
			mossePossibili=ai.start();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(mossePossibili);
		panel.repaint();
	}
	
	
	public void mosseTorre() {
		
		caricaScacchiera();
		
		ai.addFocusFact(focus);
		
		ai.load("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/encodings/Torre");
		try {
			mossePossibili.clear();
			mossePossibili=ai.start();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(mossePossibili);
		panel.repaint();
	}
	
	public void mosseCavallo() {
		
		caricaScacchiera();
		
		ai.addFocusFact(focus);
		
		ai.load("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/encodings/Cavallo");
		try {
			mossePossibili.clear();
			mossePossibili=ai.start();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(mossePossibili);
		panel.repaint();
	}
	
	public void mosseAlfiere() {
		
		caricaScacchiera();
		
		ai.addFocusFact(focus);
		
		ai.load("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/encodings/Alfiere");
		try {
			mossePossibili.clear();
			mossePossibili=ai.start();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(mossePossibili);
		panel.repaint();
	}
	
	public void mosseRegina() {
		
		caricaScacchiera();
		
		ai.addFocusFact(focus);
		
		ai.load("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/encodings/Regina");
		try {
			mossePossibili.clear();
			mossePossibili=ai.start();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(mossePossibili);
		panel.repaint();
	}
	
	public void mosseRe() {
		
		caricaScacchiera();
		
		ai.addFocusFact(focus);
		
		ai.load("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/encodings/Re");
		try {
			mossePossibili.clear();
			mossePossibili=ai.start();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(mossePossibili);
		panel.repaint();
	}
	
	public void checkAndMove(int x, int y) {
		for(Move m: mossePossibili) {
			if(m.getX()==x && m.getY()==y) {
				scacchiera[focus.getY()][focus.getX()]=null;
				focus.setX(x);
				focus.setY(y);
				scacchiera[y][x]=focus;
				focus=null;
				mossePossibili.clear();
				if(scacchiera[y][x].getTipo().equals("pedone") && ((scacchiera[y][x].getC().equals("bianco") && y==0) || (scacchiera[y][x].getC().equals("nero") && y==7)))
				{
					scacchiera[y][x].setTipo("regina");
					scacchiera[y][x].setIndex(scacchiera[y][x].getIndex()+1);
				}
				panel.repaint();
				
				cambiaTurno();
			}
		}
	}
	
	public void caricaScacchiera() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(scacchiera[i][j]!=null && (i!=focus.getY() || j!=focus.getX()))
					ai.newFacts(scacchiera[i][j]);
			}
		}
	}
	
	public void caricaALL() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(scacchiera[i][j]!=null)
					ai.newFacts(scacchiera[i][j]);
			}
		}
	}
	public void cambiaTurno() {
		caricaALL();
		ai.load("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/encodings/AiEnEmY");
		try {
			mossePossibili.clear();
			//trovaMossa(ai.startAI());
			trovaMossa(ai.startAI());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		panel.repaint();
		
		caricaALL();
		ai.load("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/encodings/scaccoMatto");
		try {
			if(ai.isScaccoMatto()) {
				JOptionPane.showMessageDialog(null, "Scacco matto! Vincono i Neri!");
				System.exit(0);
			}
		} catch (HeadlessException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void trovaMossa(AiMove m) {
		if(!(m.getTipo().equals("ScaccoMatto"))) {
		String tipo=m.getTipo().substring(1, m.getTipo().length()-1);
		String colore= m.getC().substring(1, m.getC().length()-1);
		//scacchiera[m.getY()][m.getX()]=new Pezzo(tipo, m.getIndex(), colore, m.getX(), m.getY());
		
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++) {
				if(scacchiera[i][j]!=null && scacchiera[i][j].getTipo().equals(tipo) && scacchiera[i][j].getC().equals(colore) && scacchiera[i][j].getIndex()==m.getIndex()) {
					scacchiera[i][j]=null;
					if(m.getY()==7 && tipo.equals("pedone"))
						tipo="regina";
						
					scacchiera[m.getY()][m.getX()]=new Pezzo(tipo, m.getIndex(), colore, m.getX(), m.getY());
					break;
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Scacco matto! Vincono i Bianchi!");
			System.exit(0);
		}
	}
	
	public void turnAllPedone() {
		
	}
	
}
