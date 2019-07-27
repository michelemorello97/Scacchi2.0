package ai_manager;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import model.AiMove;
import model.Focus;
import model.Move;
import model.Pezzo;
import model.ScaccoMatto;

public class Ai_Manager {
	Handler handler;
	InputProgram program;
	InputProgram facts;
	String encoding;
	Output output;
	AnswerSets answers;
	
	///home/michele/Scrivania/Intelligenza_Artificiale/dlv2
	public Ai_Manager() {
		handler= new DesktopHandler(new DLV2DesktopService("/home/michele/git/Scacchi2.0/Scacchi_2.0/src/ai_manager/dlv2"));
		facts= new ASPInputProgram();
		program= new InputProgram();
		
		try {
			ASPMapper.getInstance().registerClass(Pezzo.class);
			ASPMapper.getInstance().registerClass(Move.class);
			ASPMapper.getInstance().registerClass(Focus.class);
			ASPMapper.getInstance().registerClass(AiMove.class);
			ASPMapper.getInstance().registerClass(ScaccoMatto.class);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void load(String encoding) {
		program.addFilesPath(encoding);
		handler.addProgram(program);
	}
	
	
	public void addFocusFact(Pezzo p) {
		try {
			facts.addObjectInput(new Focus(p));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void newFacts(Pezzo p) {
		try {
			facts.addObjectInput(new Pezzo(p));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LinkedList<Move> start() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		LinkedList<Move> m=new LinkedList<>();
		handler.addProgram(facts);
		//Move m=new Move();
		
		output = handler.startSync();
		answers = (AnswerSets) output;
		
		for(AnswerSet a: answers.getAnswersets()) {
			for(Object obj: a.getAtoms())
				if(obj instanceof Move) {
					m.add((Move) obj);
				}
			
		}
		
		
		
		handler.removeProgram(facts);
		handler.removeProgram(program);
		program.clearFilesPaths();
		facts.clearAll();
		
		
		return m;
	}
	
	public AiMove startAI() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		AiMove m=new AiMove();
		handler.addProgram(facts);
		//Move m=new Move();
		
		output = handler.startSync();
		answers = (AnswerSets) output;
		
		for(AnswerSet a: answers.getAnswersets()) {
			for(Object obj: a.getAtoms()) {
				if(obj instanceof AiMove) {
					m=((AiMove) obj);
				}
				if(obj instanceof Focus)
					System.out.println(((Focus) obj).toString());
			}
			
		}
		if(m.getTipo()==null)
			m.setTipo("ScaccoMatto");
			System.out.println(m.toString());
		
		
		
		handler.removeProgram(facts);
		handler.removeProgram(program);

		program.clearFilesPaths();
		facts.clearAll();
		
		return m;
		
	}
	
	
	
	
	public boolean isScaccoMatto() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		ScaccoMatto s=new ScaccoMatto();
		handler.addProgram(facts);
		//Move m=new Move();
		
		output = handler.startSync();
		answers = (AnswerSets) output;
		
		for(AnswerSet a: answers.getAnswersets()) {
			for(Object obj: a.getAtoms()) {
				if(obj instanceof AiMove) 
					s=((ScaccoMatto) obj);
					
				
				}
			
		}
		System.out.println(s.getVal());
		
		
		handler.removeProgram(facts);
		handler.removeProgram(program);

		program.clearFilesPaths();
		facts.clearAll();
		if(s.getVal()==1)
			return true;
		return false;
		
	}
}

