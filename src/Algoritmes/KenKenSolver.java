package Algoritmes;

import capaDomini.*;

public class KenKenSolver {
	
	private static TaulerKenKen KK;
	private static boolean trobat;
	
	private static void backtracking(int i, int j) {
		// Tenim solucio
		if (i==KK.getAlto()) {
			System.out.println("SOLUCIO");
			trobat = true;
		}
		// Continuem provant
		else {
			for (int value=1; value<=KK.getAncho() && !trobat; ++value) {
				if (KK.checkFila(i,value) && KK.checkCol(j,value)) {
					KK.setNumero(i, j, value);
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
			}
		}	
	}
	
	public void backtrackingSolver(TaulerKenKen T) {		
		KK = T;
		trobat = false;
		backtracking(0, 0);
	}
}