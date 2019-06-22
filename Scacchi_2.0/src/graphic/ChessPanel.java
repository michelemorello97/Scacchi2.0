package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import GameManager.GameManager;
import interfaces.Colore;
import model.Move;

public class ChessPanel extends JPanel{

	int div=80;
	String turno;
	GameManager gm;
	Image regina_bianca;
	Image regina_nera;
	Image re_bianco;
	Image re_nero;
	Image torre_bianca;
	Image torre_nera;
	Image cavallo_bianco;
	Image cavallo_nero;
	Image alfiere_bianco;
	Image alfiere_nero;
	Image pedone_bianco;
	Image pedone_nero;
	Image bianco;
	Image marrone;
	Image mossaPossibile;
	boolean scaccoAlReBianco;
	boolean scaccoAlReNero;
	MouseListener ml;
	
	public ChessPanel(int w, int h) {
		super();
		//ai=new Ai_Manager();
		gm=new GameManager(this);
		this.addMouseListener(gm);
		scaccoAlReBianco=false;
		scaccoAlReNero=false;
		loadImage();
		
		turno="bianco";
		this.setSize(w, h);
		
		
		
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if((i+j)%2==0)
					g.drawImage(bianco, j*div, i*div, div, div, null);
				else
					g.drawImage(marrone, j*div, i*div, div, div, null);
				
				if(gm.getPezzo(i, j)!=null) {
				if(gm.getPezzo(i, j).getTipo().equals("regina")) {
					if(gm.getPezzo(i, j).getC().equals("bianco"))
						g.drawImage(regina_bianca, j*div+21, i*div+7, null);
					else
						g.drawImage(regina_nera, j*div+21, i*div+7, null);
				}
				else if(gm.getPezzo(i, j).getTipo().equals("re")) {
					if(gm.getPezzo(i, j).getC().equals("bianco"))
						g.drawImage(re_bianco, j*div+21, i*div+4, null);
					else
						g.drawImage(re_nero, j*div+21, i*div+4, null);
				}
				else if(gm.getPezzo(i, j).getTipo().equals("torre")) {
					if(gm.getPezzo(i, j).getC().equals("bianco"))
						g.drawImage(torre_bianca, j*div+21, i*div+7, null);
					else
						g.drawImage(torre_nera, j*div+21, i*div+7, null);
				}
				else if(gm.getPezzo(i, j).getTipo().equals("cavallo")) {
					if(gm.getPezzo(i, j).getC().equals("bianco"))
						g.drawImage(cavallo_bianco, j*div+18, i*div+5, null);
					else
						g.drawImage(cavallo_nero, j*div+18, i*div+5, null);
				}
				else if(gm.getPezzo(i, j).getTipo().equals("alfiere")) {
					if(gm.getPezzo(i, j).getC().equals("bianco"))
						g.drawImage(alfiere_bianco, j*div+21, i*div+4, null);
					else
						g.drawImage(alfiere_nero, j*div+21, i*div+4, null);
				}
				else if(gm.getPezzo(i, j).getC().equals("bianco"))
						g.drawImage(pedone_bianco, j*div+23, i*div+14, null);
				else
						g.drawImage(pedone_nero, j*div+23, i*div+14, null);
					}
				}
			
			
			
		}
		g.setColor(Color.GREEN);
		if(gm.getMossePossibili().size()!=0)
			for(Move m: gm.getMossePossibili()) {
				g.fillOval((m.getX()*div)+29, (m.getY()*div)+29, 22, 22);
			}
		
		
	}

	
	

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}


	public void loadImage() {
		try {
			regina_bianca = ImageIO.read(getClass().getResource("../resources/reginaBianca.png"));
			regina_nera = ImageIO.read(getClass().getResource("../resources/reginaNera.png"));
			re_bianco = ImageIO.read(getClass().getResource("../resources/reBianco.png"));
			re_nero = ImageIO.read(getClass().getResource("../resources/reNero.png"));
			alfiere_bianco = ImageIO.read(getClass().getResource("../resources/alfiereBianco.png"));
			alfiere_nero = ImageIO.read(getClass().getResource("../resources/alfiereNero.png"));
			cavallo_bianco = ImageIO.read(getClass().getResource("../resources/cavalloBianco.png"));
			cavallo_nero = ImageIO.read(getClass().getResource("../resources/cavalloNero.png"));
			torre_bianca = ImageIO.read(getClass().getResource("../resources/torreBianca.png"));
			torre_nera = ImageIO.read(getClass().getResource("../resources/torreNera.png"));
			pedone_bianco = ImageIO.read(getClass().getResource("../resources/pedoneBianco.png"));
			pedone_nero = ImageIO.read(getClass().getResource("../resources/pedoneNero.png"));
			bianco=ImageIO.read(getClass().getResource("../resources/bianco.png"));
			marrone=ImageIO.read(getClass().getResource("../resources/marrone.png"));
			mossaPossibile=ImageIO.read(getClass().getResource("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/resources/mossa_permessa.png"));
			}
			catch (Exception e) {
				// TODO: handle exception
			}	}
	
}
