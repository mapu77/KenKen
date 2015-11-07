package capaDomini;

import java.util.*;

public class RegioKenKen extends Regio {

	private String operation;
	private int result;
	private int id;
	
	public RegioKenKen(int n) {
		super(n);
		this.id = -1;
	}
	
	public RegioKenKen (int tamano, Vector<Cella> vc, String op, int res, int id) {
		super(tamano,vc);
		this.operation = op;
		this.result = res;
		this.id = id;
	}
	
	public RegioKenKen(Vector<Cella> vc) {
		super(vc.size(), vc);
		this.id = -1;
	}
	
 	public void Relaciona(int i, Cella c) {
		Vector<Cella> aux = this.getvCellas();
		aux.add(i,c);
		this.setvCellas(aux);
	}
	
	public boolean estaCompleta() {
		for (int i=0; i<this.getNumCeldas(); ++i) {
			if (this.getCella(i).estaVacia()) return false;
		}
		return true;
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