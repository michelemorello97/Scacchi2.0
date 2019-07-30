package model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("scaccoReJava")
public class scaccoRe {
	@Param(0)
	int val;
	
public scaccoRe() {
		
	}

public scaccoRe(int val) {
	this.val=val;
}

public scaccoRe(scaccoRe s) {
	this.val=s.getVal();
}

public int getVal() {
	return val;
}

public void setVal(int val) {
	this.val = val;
}
}