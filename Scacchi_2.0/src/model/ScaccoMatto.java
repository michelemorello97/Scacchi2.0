package model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("scaccoMatto")
public class ScaccoMatto {
	@Param(0)
	int val;
	
public ScaccoMatto() {
		
	}

public ScaccoMatto(int val) {
	this.val=val;
}

public ScaccoMatto(ScaccoMatto s) {
	this.val=s.getVal();
}

public int getVal() {
	return val;
}

public void setVal(int val) {
	this.val = val;
}
}
