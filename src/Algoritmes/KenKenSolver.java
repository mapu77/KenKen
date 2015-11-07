package Algoritmes;

import capaDomini.*;

public class KenKenSolver {
	
	private static TaulerKenKen KK;
	
	/* Retorna si x és un nombre valid per la fila r */
	private static boolean esValidenFila(int fila, int j, int x) {
		System.out.println("Comprovo " + x + " en fila");
		for (int col=0; col<KK.getAncho(); ++col) {
			if (j != col && KK.getNumero(fila,col) == x) return false;
		}
		return true;
	}
	
	/* Retorna si x és un nombre vàlid per la columna c */
	private static boolean esValidenColumna(int i, int col, int x) {
		System.out.println("Comprovo " + x + " en columna");
		for (int fila = 0; fila < KK.getAlto(); ++fila) {
			if (i != fila && KK.getNumero(fila,col) == x) return false;
		}
		return true;
	}
	
	private static int calculaRegioSuma(RegioKenKen r) {
		int res = 0;
		for (int i=0; i<r.getNumCeldas(); ++i) {
			res += r.getCella(i).getNumero();
		}
		return res;
	}
	
	private static int calculaRegioResta(RegioKenKen r) {
		return Math.abs(r.getCella(0).getNumero() - r.getCella(1).getNumero());
	}
	
	private static int calculaRegioMult(RegioKenKen r) {
		int res = 1;
		for (int i=0; i<r.getNumCeldas(); ++i) {
			res *= r.getCella(i).getNumero();
		}
		return res;
	}
	
	private static int calculaRegioDiv(RegioKenKen r) {
		int op1 = r.getCella(0).getNumero()/r.getCella(1).getNumero();
		int op2 = r.getCella(1).getNumero()/r.getCella(0).getNumero();
		return (op1 >= 1) ? op1 : op2;
	}
	
	/* Pre: r està completa */
	/* Post: retorna si al aplicar la operacio de r a les celes de r, s'obte el resultat associat a la regio */
	private static boolean checkRegion(RegioKenKen r) {
		int result;
		switch (r.getOperation()) {
		case "+":
			result = calculaRegioSuma(r);
			break;
		case "-":
			result = calculaRegioResta(r);
			break;
		case "*":
			result = calculaRegioMult(r);
			break;
		case "/":
			result = calculaRegioDiv(r);
			break;
		default:
			result = 0;
		}
		if (result == r.getResult()) return true;
		else return false;
	}
		
	private static void backtracking(int i, int j, int max) {
		// Tenim solucio
		if ((i+1)*(j+1) == max) System.out.println("Solucio");
		// Continuem provant
		else {
			System.out.println("Estic a (" + i + "," + j + ")");
			for (int value=1; value<=KK.getAncho(); ++value) {
				KK.setNumero(i,j,value);
				if (esValidenFila(i,j,value) && esValidenColumna(i,j,value)) {
					RegioKenKen r = KK.getRegio(KK.nRegio(i,j));
					if (r.estaCompleta()) {
						System.out.println("La regio " + r.getId() + " esta completa");
						if (checkRegion(r)) {
							if (j == KK.getAncho()-1) {
								backtracking(i+1,0,max);
							}
							else {
								backtracking(i,j+1,max);
							}
						}
					}
					else {
						System.out.println("La regio " + r.getId() + " esta incompleta");
						if (j==KK.getAncho()-1) {
							backtracking(i+1,0,max);
						}
						else {
							backtracking(i,j+1,max);
						}
					}	
				}
			}
			//KK.borra(i,j);
		}
		KK.borra(i,j);
	}
	
	public void backtrackingSolver(TaulerKenKen T) {		
		KK = T;
		backtracking(0, 0, KK.getNumCeldas());
	}
}