package capaDomini;

import java.util.*;

public class RegioKenKen extends Regio {

	private String operation;
	private int result;
	
	public RegioKenKen(Vector<Cella> vc) {
		super(vc.size(), vc);
	}

	private int id;

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