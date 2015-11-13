package capaDomini.Algoritmes;

import capaDomini.Utils.*;

public class KenKenSolver {
	
	private static TaulerKenKen KK;
	private static boolean trobat;
	
	private static void IA () { // inteligencia artificial
		for (int i=0; i<KK.getNRegio(); ++i) {
			if (KK.getRegio(i).getNumCeldas() == 1) { //posem les regions d'1 cel�la en posicio correcta
				int res = KK.getRegio(i).getResult(); //i les bloquejam perque ningu les pugui tocar
				KK.getRegio(i).getCella(0).setNumero(res);
				KK.getRegio(i).getCella(0).bloquear();
			}
		}
	}
	
	private static void backtrackingIA(int i, int j) {
		// Tenim solucio
		if (i==KK.getAlto()) {
			trobat = true;
		}
		// Continuem provant
		else {
			if (KK.getCella(i, j).estaBloqueada()) {
				if (j+1==KK.getAncho()) {
					backtrackingIA(i+1,0);
				}
				else {
					backtrackingIA(i,j+1);
				}
			}
			else {
				for (int value=1; value<=KK.getAncho() && !trobat; ++value) {
					if (KK.checkFila(i,value) && KK.checkCol(j,value)) {
						KK.setNumero(i, j, value);
						RegioKenKen r = KK.getRegio(KK.nRegio(i,j));
						if ((r.estaCompleta() && r.checkRegionC()) || (!r.estaCompleta() && r.checkRegionI())) {
							if (j+1==KK.getAncho()) {
								backtrackingIA(i+1,0);
							}
							else {
								backtrackingIA(i,j+1);
							}
						}
					}
				}
				if (!trobat){
					KK.getCella(i, j).borra();
				}
			}
		}	
	}
	
	private static void backtracking(int i, int j) {
		// Tenim solucio
		if (i==KK.getAlto()) {
			trobat = true;
		}
		// Continuem provant
		else {
			for (int value=1; value<=KK.getAncho() && !trobat; ++value) {
				if (KK.checkFila(i,value) && KK.checkCol(j,value)) {
					KK.setNumero(i, j, value);
					RegioKenKen r = KK.getRegio(KK.nRegio(i,j));
					if ((r.estaCompleta() && r.checkRegionC()) || !r.estaCompleta()) {
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
	
	public long backtrackingSolver(TaulerKenKen T) {		
		KK = T;
		trobat = false;
		long t0 = System.nanoTime();
		backtracking(0,0);
		long t1 = System.nanoTime();
		return (t1-t0)/(long)Math.pow(10,9);
	}
	
	public long intelligentSolver(TaulerKenKen T) {
		KK = T;
		trobat = false;
		long t0 = System.nanoTime();
		IA();
		backtrackingIA(0,0);
		long t1 = System.nanoTime();
		return (t1-t0)/(long)Math.pow(10,9);
	}
}