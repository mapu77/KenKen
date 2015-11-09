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
	
	public boolean estaCompleta() {
		for (int i=0; i<this.getNumCeldas(); ++i) {
			if (this.getCella(i).estaVacia()) return false;
		}
		return true;
 	}
	
	public int calculaRegioSuma() {
		int res = 0;
		for (int i=0; i<getNumCeldas(); ++i) {
			if (! getCella(i).estaVacia()) {
				res += getCella(i).getNumero();
			}
		}
		return res;
	}
	
	public int calculaRegioResta() {
		return Math.abs(getCella(0).getNumero() - getCella(1).getNumero());
	}
	
	public int calculaRegioMult() {
		int res = 1;
		for (int i=0; i<getNumCeldas(); ++i) {
			if (! getCella(i).estaVacia()) {
				res *= getCella(i).getNumero();
			}
		}
		return res;
	}
	
	public int calculaRegioDiv() {
		int op1 = getCella(0).getNumero()/getCella(1).getNumero();
		int op2 = getCella(1).getNumero()/getCella(0).getNumero();
		return (op1 >= 1) ? op1 : op2;
	}
	
	/* Pre: r està complerta */
	/* Post: retorna si al aplicar la operacio de r a les celes de r, s'obte el resultat associat a la regio */
	public boolean checkRegionC() {
		int res = resCheck();
		if (res == this.result) return true;
		else return false;
	}
	
	public boolean checkRegionI() {
		if (operation=="+" || operation=="*") {
			int res = resCheck();
			if (res > result) return false;
		}
		return true;
	}
	
	private int resCheck () {
		int res;
		switch (operation) {
		case "+":
			res = calculaRegioSuma();
			break;
		case "-":
			res = calculaRegioResta();
			break;
		case "*":
			res = calculaRegioMult();
			break;
		case "/":
			res = calculaRegioDiv();
			break;
		default:
			res = 0;
		}
		return res;
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