package Algoritmes;

import java.util.*;
import capaDomini.*;

public class KenKenGenerator {
	
	private Vector<Boolean> checked;
	private TaulerKenKen K;
	
	public KenKenGenerator(int n) {
		K = new TaulerKenKen(n);
		checked = new Vector<Boolean> (n);
		for (int i=0; i<checked.size(); ++i) checked.set(i, false);
	}
	
	public TaulerKenKen generateRandomly() {
		
		return K;
	}
	
	public TaulerKenKen generateKenKenby() {
		return K;
	}
	
	public TaulerKenKen generateKenKen() {
		return K;
	}
	
}
