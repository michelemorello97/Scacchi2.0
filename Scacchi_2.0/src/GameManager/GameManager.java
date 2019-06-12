package GameManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

import ai_manager.Ai_Manager;
import graphic.ChessPanel;
import interfaces.Colore;
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
			scacchiera[1][i]=new Pezzo("pedone"+i, "nero", i, 1);
			scacchiera[6][i]=new Pezzo("pedone"+i, "bianco", i, 6);
		}
		scacchiera[0][0]=new Pezzo("torre0", "nero", 0, 0);
		scacchiera[0][7]=new Pezzo("torre1", "nero", 7, 0);
		scacchiera[0][1]=new Pezzo("cavallo0", "nero", 1, 0);
		scacchiera[0][6]=new Pezzo("cavallo1", "nero", 6, 0);
		scacchiera[0][2]=new Pezzo("alfiere0", "nero", 2, 0);
		scacchiera[0][5]=new Pezzo("alfiere1", "nero", 5, 0);
		scacchiera[0][3]=new Pezzo("regina", "nero", 3, 0);
		scacchiera[0][4]=new Pezzo("re", "nero", 4, 0);
		
		scacchiera[7][0]=new Pezzo("torre0", "bianco", 0, 7);
		scacchiera[7][7]=new Pezzo("torre1", "bianco", 7, 7);
		scacchiera[7][1]=new Pezzo("cavallo0", "bianco", 1, 7);
		scacchiera[7][6]=new Pezzo("cavallo1", "bianco", 7, 6);
		scacchiera[7][2]=new Pezzo("alfiere0", "bianco", 2, 7);
		scacchiera[7][5]=new Pezzo("alfiere1", "bianco", 5, 7);
		scacchiera[7][3]=new Pezzo("regina", "bianco", 3, 7);
		scacchiera[7][4]=new Pezzo("re", "bianco", 4, 7);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x=e.getX()/80;
		int y=e.getY()/80;
		if(scacchiera[y][x]!=null && scacchiera[y][x].getC()=="bianco"){
			focus=scacchiera[y][x];
			
			if(focus.getTipo().contains("pedone"))
				mossePedone();
				
		}
		
		
		else if(focus!=null)
			checkAndMove(x, y);
			
			
		
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
	
	public void checkAndMove(int x, int y) {
		for(Move m: mossePossibili) {
			if(m.getX()==x && m.getY()==y) {
				scacchiera[focus.getY()][focus.getX()]=null;
				focus.setX(x);
				focus.setY(y);
				scacchiera[y][x]=focus;
				focus=null;
				mossePossibili.clear();
				panel.repaint();
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
}
