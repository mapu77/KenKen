package Algoritmes;

import capaDomini.*;

public class KenKenSolver {
	
	private static TaulerKenKen KK;
	private static boolean trobat;
	
	/* Retorna si x és un nombre valid per la fila r */
	private static boolean checkFila(int fila, int x) {
		for (int col=0; col<KK.getAncho(); ++col) {
			if (KK.getNumero(fila,col) == x) return false;
		}
		return true;
	}
	
	/* Retorna si x és un nombre vàlid per la columna c */
	private static boolean checkCol(int col, int x) {
		for (int fila = 0; fila < KK.getAncho(); ++fila) {
			if (KK.getNumero(fila,col) == x) return false;
		}
		return true;
	}
	
	private static void backtracking(int i, int j) {
		// Tenim solucio
		if (i==KK.getAlto()) {
			System.out.println("Solucio");
			trobat = true;
		}
		// Continuem provant
		else {
			for (int value=1; value<=KK.getAncho() && !trobat; ++value) {
				if (checkFila(i,value) && checkCol(j,value)) {
					KK.setNumero(i, j, value);
					KK.setNumeroRegio(i, j, value);
					RegioKenKen r = KK.getRegio(KK.nRegio(i,j));
					if ((r.estaCompleta() && r.checkRegion()) || !(r.estaCompleta())) {
						if (j+1==KK.getAncho()) {
							backtracking(i+1,0);
						}
						else {
							backtracking(i,j+1);
						}
					}
				}
			}
			if (!trobat){
				KK.getCella(i, j).borra();
				KK.setNumeroRegio(i, j, -1);
			}
		}	
	}
	
	public void backtrackingSolver(TaulerKenKen T) {		
		KK = T;
		trobat = false;
		backtracking(0, 0);
	}
}