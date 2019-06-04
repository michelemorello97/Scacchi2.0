package ai_manager;

import java.lang.reflect.InvocationTargetException;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import model.Move;
import model.Pezzo;

public class Ai_Manager {
	Handler handler;
	InputProgram program;
	InputProgram facts;
	String encoding;
	Output output;
	AnswerSets answers;
	
	
	public Ai_Manager() {
		handler= new DesktopHandler(new DLV2DesktopService("/home/michele/Scrivania/Intelligenza_Artificiale/dlv2"));
		facts= new InputProgram();
		program= new InputProgram();
		
		try {
			ASPMapper.getInstance().registerClass(Pezzo.class);
			ASPMapper.getInstance().registerClass(Move.class);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void load(String encoding) {
		program.addFilesPath(encoding);
		handler.addProgram(program);
	}
	
	public void newFacts(Pezzo p) {
		try {
			facts.addObjectInput(new Pezzo(p));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		handler.addProgram(facts);
		Move m=new Move();
		
		output = handler.startSync();
		answers = (AnswerSets) output;
		
		for(AnswerSet a: answers.getAnswersets()) {
			for(Object obj: a.getAtoms())
				if(obj instanceof Move)
					m=(Move) obj;
		}
		
		
		System.out.println(m.toString());
		
		handler.removeProgram(facts);
		facts.clearAll();
		handler.removeProgram(program);
	}
}

