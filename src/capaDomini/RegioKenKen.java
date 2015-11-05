package capaDomini;

import java.util.*;

public class RegioKenKen extends Regio {

	private String operation;
	private int result;
	private int id;
	
	public RegioKenKen(int n) {
		super(n);
	}
	
	public RegioKenKen(Vector<Cella> vc) {
		super(vc.size(), vc);
	}
	
	public void Relaciona(int i, Cella c) {
		vCellas.add(i,c);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}